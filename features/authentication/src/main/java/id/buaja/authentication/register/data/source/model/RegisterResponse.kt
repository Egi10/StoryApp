package id.buaja.authentication.register.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.register.domain.model.Register

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    @Json(name = "error")
    val error: Boolean,
    @Json(name = "message")
    val message: String
)

fun RegisterResponse.mapToRegister() =
    Register(
        error = this.error,
        message = this.message
    )