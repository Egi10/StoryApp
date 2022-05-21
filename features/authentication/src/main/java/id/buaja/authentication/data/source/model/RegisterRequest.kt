package id.buaja.authentication.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.domain.model.register.RegisterParam

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    @field:Json(name = "email")
    val email: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "password")
    val password: String
)

fun RegisterParam.mapToRequest() =
    RegisterRequest(
        email = this.email,
        name = this.name,
        password = this.password
    )