package id.buaja.authentication.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.domain.model.register.Register

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    @field:Json(name = "error")
    val error: Boolean,
    @field:Json(name = "message")
    val message: String
)

fun RegisterResponse.mapToRegister() =
    Register(
        error = this.error,
        message = this.message
    )