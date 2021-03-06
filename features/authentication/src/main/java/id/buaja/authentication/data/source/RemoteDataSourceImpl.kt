package id.buaja.authentication.data.source

import id.buaja.authentication.data.source.model.login.LoginRequest
import id.buaja.authentication.data.source.model.register.RegisterRequest
import id.buaja.authentication.data.source.routes.AuthenticationService
import id.buaja.common.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override fun register(request: RegisterRequest) = flow {
        emit(
            authenticationService.register(
                request = request
            )
        )
    }.flowOn(ioDispatcher)

    override fun login(request: LoginRequest) = flow {
        emit(
            authenticationService.login(
                request = request
            )
        )
    }.flowOn(ioDispatcher)
}