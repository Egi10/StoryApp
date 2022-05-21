package id.buaja.common.result

import kotlinx.coroutines.flow.*
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: String? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart {
            emit(Result.Loading)
        }
        .catch {
            emit(fetchError(it))
        }
}

/**
 * Response @link [https://developer.mozilla.org/en-US/docs/Web/HTTP/Status]
 */
fun fetchError(throwable: Throwable): Result.Error {
    return when (throwable) {
        is IOException -> {
            Result.Error(throwable.message)
        }

        is HttpException -> {
            when (throwable.code()) {
                in 400..499 -> {
                    val response = throwable.response()?.errorBody()?.string()

                    val jsonObject = response?.let { JSONObject(it) }
                    val message = jsonObject?.getString("message")

                    Result.Error(message)
                }

                else -> {
                    Result.Error(throwable.message)
                }
            }
        }

        else -> {
            Result.Error(throwable.message)
        }
    }
}