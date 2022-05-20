package id.buaja.authentication.register.domain.usecase

import id.buaja.authentication.register.domain.model.Register
import id.buaja.authentication.register.domain.model.RegisterParam
import id.buaja.authentication.register.domain.register.RegisterRepository
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

class RegisterUseCaseImpl @Inject constructor(
    private val registerRepository: RegisterRepository
) : RegisterUseCase {
    override fun invoke(registerParam: RegisterParam): Flow<Result<Register>> {
        return registerRepository.register(
            registerParam = registerParam
        )
    }
}