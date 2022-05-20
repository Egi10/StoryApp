package id.buaja.authentication.register.data.source

import id.buaja.authentication.register.data.source.model.RegisterRequest
import id.buaja.authentication.register.data.source.model.RegisterResponse
import id.buaja.authentication.register.data.source.routes.RegisterService
import id.buaja.common.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRegisterDataSourceImpl @Inject constructor(
    private val registerService: RegisterService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteRegisterDataSource {
    override fun register(request: RegisterRequest) = flow<RegisterResponse> {
        registerService.register(
            request = request
        )
    }.flowOn(ioDispatcher)
}