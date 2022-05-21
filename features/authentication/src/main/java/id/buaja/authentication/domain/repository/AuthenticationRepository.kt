package id.buaja.authentication.domain.repository

import id.buaja.authentication.domain.model.login.Login
import id.buaja.authentication.domain.model.login.LoginParam
import id.buaja.authentication.domain.model.register.Register
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

interface AuthenticationRepository {
    fun register(registerParam: RegisterParam): Flow<Result<Register>>
    fun login(loginParam: LoginParam): Flow<Result<Login>>
}