package id.buaja.authentication.data.source

import id.buaja.authentication.data.source.model.login.LoginRequest
import id.buaja.authentication.data.source.model.login.LoginResponse
import id.buaja.authentication.data.source.model.register.RegisterRequest
import id.buaja.authentication.data.source.model.register.RegisterResponse
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {
    fun register(request: RegisterRequest): Flow<RegisterResponse>
    fun login(request: LoginRequest): Flow<LoginResponse>
}