package id.buaja.authentication.domain.usecase.register

import id.buaja.authentication.domain.model.register.Register
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

interface RegisterUseCase {
    operator fun invoke(registerParam: RegisterParam): Flow<Result<Register>>
}