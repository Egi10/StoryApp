package id.buaja.authentication.domain.usecase.login

import id.buaja.authentication.domain.model.login.Login
import id.buaja.authentication.domain.model.login.LoginParam
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

interface LoginUseCase {
    operator fun invoke(param: LoginParam): Flow<Result<Login>>
}