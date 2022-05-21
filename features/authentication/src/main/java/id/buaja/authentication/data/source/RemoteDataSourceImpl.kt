package id.buaja.authentication.data.source

import id.buaja.authentication.data.source.model.RegisterRequest
import id.buaja.authentication.data.source.model.RegisterResponse
import id.buaja.authentication.data.source.routes.RegisterService
import id.buaja.common.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val registerService: RegisterService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {
    override fun register(request: RegisterRequest) = flow<RegisterResponse> {
        registerService.register(
            request = request
        )
    }.flowOn(ioDispatcher)
}