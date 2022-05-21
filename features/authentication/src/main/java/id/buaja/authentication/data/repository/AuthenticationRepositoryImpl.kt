package id.buaja.authentication.data.repository

import id.buaja.authentication.data.source.RemoteDataSource
import id.buaja.authentication.data.source.model.login.mapToLogin
import id.buaja.authentication.data.source.model.login.mapToRequest
import id.buaja.authentication.data.source.model.register.mapToRegister
import id.buaja.authentication.data.source.model.register.mapToRequest
import id.buaja.authentication.domain.model.login.Login
import id.buaja.authentication.domain.model.login.LoginParam
import id.buaja.authentication.domain.model.register.Register
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.authentication.domain.repository.AuthenticationRepository
import id.buaja.common.result.Result
import id.buaja.common.result.asResult
import id.buaja.datastore.DataStoreManager
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

class AuthenticationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dataStoreManager: DataStoreManager
) : AuthenticationRepository {
    override fun register(registerParam: RegisterParam): Flow<Result<Register>> {
        val request = registerParam.mapToRequest()

        return remoteDataSource.register(
            request = request
        ).map {
            it.mapToRegister()
        }.asResult()
    }

    @OptIn(FlowPreview::class)
    override fun login(loginParam: LoginParam): Flow<Result<Login>> {
        val request = loginParam.mapToRequest()

        return remoteDataSource.login(
            request = request
        ).flatMapMerge { loginResponse ->
            dataStoreManager.saveToken(
                token = loginResponse.loginResult.token
            )

            return@flatMapMerge flow {
                emit(loginResponse)
            }
        }.map {
            it.mapToLogin()
        }.asResult()
    }
}