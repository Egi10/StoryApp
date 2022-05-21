package id.buaja.authentication.data.source.routes

import id.buaja.authentication.data.source.model.login.LoginRequest
import id.buaja.authentication.data.source.model.login.LoginResponse
import id.buaja.authentication.data.source.model.register.RegisterRequest
import id.buaja.authentication.data.source.model.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}