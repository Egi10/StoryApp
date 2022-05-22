package id.buaja.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import id.buaja.common.di.IoDispatcher
import id.buaja.datastore.extensions.datastore
import id.buaja.datastore.utils.PreferencesKey
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DataStoreManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : DataStoreManager {
    override suspend fun saveToken(token: String) {
        withContext(ioDispatcher) {
            context.datastore.edit {
                it[PreferencesKey.TOKEN] = token
            }
        }
    }

    override suspend fun deleteToken() {
        withContext(ioDispatcher) {
            context.datastore.edit {
                it.remove(PreferencesKey.TOKEN)
            }
        }
    }

    override fun getToken(): Flow<String> {
        return context.datastore.data.map {
            it[PreferencesKey.TOKEN] ?: ""
        }.flowOn(ioDispatcher)
    }

    override suspend fun getTokens(): String {
        val data = context.datastore.data.first()
        return data[PreferencesKey.TOKEN] ?: ""
    }
}