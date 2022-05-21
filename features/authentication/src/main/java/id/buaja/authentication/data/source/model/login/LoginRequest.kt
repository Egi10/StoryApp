package id.buaja.authentication.data.source.model.login


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.authentication.domain.model.login.LoginParam

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)

fun LoginParam.mapToRequest() =
    LoginRequest(
        email = this.email,
        password = this.password
    )