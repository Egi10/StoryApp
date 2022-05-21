package id.buaja.authentication.data.source

import id.buaja.authentication.data.source.model.RegisterRequest
import id.buaja.authentication.data.source.model.RegisterResponse
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {
    fun register(request: RegisterRequest): Flow<RegisterResponse>
}