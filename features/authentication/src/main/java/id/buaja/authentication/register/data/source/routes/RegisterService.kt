package id.buaja.authentication.register.data.source.routes

import id.buaja.authentication.register.data.source.model.RegisterRequest
import id.buaja.authentication.register.data.source.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse
}