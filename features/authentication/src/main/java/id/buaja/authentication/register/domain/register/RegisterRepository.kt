package id.buaja.authentication.register.domain.register

import id.buaja.authentication.register.domain.model.Register
import id.buaja.authentication.register.domain.model.RegisterParam
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

interface RegisterRepository {
    fun register(registerParam: RegisterParam): Flow<Result<Register>>
}