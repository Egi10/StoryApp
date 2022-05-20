package id.buaja.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import id.buaja.datastore.extensions.datastore
import id.buaja.datastore.utils.PreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreManagerImpl(
    @ApplicationContext private val context: Context
) : DataStoreManager {
    override suspend fun saveToken(token: String) {
        context.datastore.edit {
            it[PreferencesKey.TOKEN] = token
        }
    }

    override suspend fun deleteToken() {
        context.datastore.edit {
            it.remove(PreferencesKey.TOKEN)
        }
    }

    override fun getToken(): Flow<String> {
        return context.datastore.data.map {
            it[PreferencesKey.TOKEN] ?: ""
        }
    }
}