package id.buaja.authentication.register.data.repository

import id.buaja.authentication.register.data.source.RemoteRegisterDataSource
import id.buaja.authentication.register.data.source.model.mapToRequest
import id.buaja.authentication.register.domain.model.Register
import id.buaja.authentication.register.domain.model.RegisterParam
import id.buaja.authentication.register.domain.register.RegisterRepository
import id.buaja.common.result.Result
import id.buaja.common.result.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

class RegisterRepositoryImpl @Inject constructor(
    private val remoteRegisterDataSource: RemoteRegisterDataSource
) : RegisterRepository {
    override fun register(registerParam: RegisterParam): Flow<Result<Register>> {
        val request = registerParam.mapToRequest()

        return remoteRegisterDataSource.register(
            request = request
        ).map {
            Register(
                error = it.error,
                message = it.message
            )
        }.asResult()
    }
}