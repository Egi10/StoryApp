package id.buaja.authentication.domain.usecase.login

import id.buaja.authentication.domain.model.login.Login
import id.buaja.authentication.domain.model.login.LoginParam
import id.buaja.authentication.domain.repository.AuthenticationRepository
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

class LoginUseCaseImpl @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : LoginUseCase {
    override fun invoke(param: LoginParam): Flow<Result<Login>> {
        return authenticationRepository.login(
            loginParam = param
        )
    }
}