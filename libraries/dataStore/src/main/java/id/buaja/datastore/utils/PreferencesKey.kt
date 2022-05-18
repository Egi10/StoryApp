package id.buaja.datastore.utils

import androidx.datastore.preferences.core.stringPreferencesKey

internal object PreferencesKey {
    const val DATA_STORE_NAME = "AUTHENTICATIONS"

    val TOKEN = stringPreferencesKey(name = "token")
}