package id.buaja.authentication.data.repository

import id.buaja.authentication.data.source.RemoteDataSource
import id.buaja.authentication.data.source.model.mapToRegister
import id.buaja.authentication.data.source.model.mapToRequest
import id.buaja.authentication.domain.model.register.Register
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.authentication.domain.repository.AuthenticationRepository
import id.buaja.common.result.Result
import id.buaja.common.result.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

class AuthenticationRepositoryImpl @Inject constructor(
    private val remoteRegisterDataSource: RemoteDataSource
) : AuthenticationRepository {
    override fun register(registerParam: RegisterParam): Flow<Result<Register>> {
        val request = registerParam.mapToRequest()

        return remoteRegisterDataSource.register(
            request = request
        ).map {
            it.mapToRegister()
        }.asResult()
    }
}