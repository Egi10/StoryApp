package id.buaja.authentication.data.source.model.login


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.domain.model.login.Login

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "error")
    val error: Boolean,
    @Json(name = "loginResult")
    val loginResult: LoginResult,
    @Json(name = "message")
    val message: String
)

@JsonClass(generateAdapter = true)
data class LoginResult(
    @Json(name = "name")
    val name: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "userId")
    val userId: String
)

fun LoginResponse.mapToLogin() =
    Login(
        error = this.error,
        message = this.message
    )