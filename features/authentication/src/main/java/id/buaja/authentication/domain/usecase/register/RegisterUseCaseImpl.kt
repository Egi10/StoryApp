package id.buaja.authentication.domain.usecase.register

import id.buaja.authentication.domain.model.register.Register
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.authentication.domain.repository.AuthenticationRepository
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

class RegisterUseCaseImpl @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : RegisterUseCase {
    override fun invoke(registerParam: RegisterParam): Flow<Result<Register>> {
        return authenticationRepository.register(
            registerParam = registerParam
        )
    }
}