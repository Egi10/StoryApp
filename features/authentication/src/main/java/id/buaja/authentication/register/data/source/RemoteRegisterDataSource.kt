package id.buaja.authentication.register.data.source

import id.buaja.authentication.register.data.source.model.RegisterRequest
import id.buaja.authentication.register.data.source.model.RegisterResponse
import kotlinx.coroutines.flow.Flow


interface RemoteRegisterDataSource {
    fun register(request: RegisterRequest): Flow<RegisterResponse>
}