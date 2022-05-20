package id.buaja.datastore.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import id.buaja.datastore.utils.PreferencesKey


val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = PreferencesKey.DATA_STORE_NAME)