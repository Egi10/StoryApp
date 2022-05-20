package id.buaja.authentication.register.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.register.domain.model.RegisterParam

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "password")
    val password: String
)

fun RegisterParam.mapToRequest() =
    RegisterRequest(
        email = this.email,
        name = this.name,
        password = this.password
    )