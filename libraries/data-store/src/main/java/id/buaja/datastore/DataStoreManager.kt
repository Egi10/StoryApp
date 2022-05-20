package id.buaja.datastore

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun saveToken(token: String)
    suspend fun deleteToken()
    fun getToken(): Flow<String>
}