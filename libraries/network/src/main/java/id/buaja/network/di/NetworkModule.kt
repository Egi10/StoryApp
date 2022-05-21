package id.buaja.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.datastore.DataStoreManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Interceptor Okhtpp
 * https://medium.com/@riteshakya037/okhttp-and-the-beauty-of-interceptor-cad4b78af0bf
 * Refresh Token
 * https://stackoverflow.com/questions/22450036/refreshing-oauth-token-using-retrofit-without-modifying-all-calls
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkhttpClient(dataStoreManager: DataStoreManager): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original = chain.request()

                val token = runBlocking {
                    dataStoreManager.getToken()
                }
                val request = original.newBuilder()

                if (token.toString().isNotEmpty()) {
                    request.header("Authorization", "Bearer ${dataStoreManager.getToken()}")
                }

                request.method(original.method(), original.body())

                return@addInterceptor chain.proceed(request.build())
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        /**
         * Added a KotlinJsonAdapterFactory to do a pojo to json converter in moshi
         * if calling Body in Retrofit.
         */
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("https://story-api.dicoding.dev/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .build()
    }

}