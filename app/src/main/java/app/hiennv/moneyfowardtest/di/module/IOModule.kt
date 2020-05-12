package app.hiennv.moneyfowardtest.di.module

import app.hiennv.moneyfowardtest.BuildConfig
import app.hiennv.moneyfowardtest.repository.Endpoint
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class IOModule {
    private val endpoint: Endpoint

    init {
        val okHttpBuilder = OkHttpClient.Builder()

        val okHttpClient = okHttpBuilder.build()

        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.ENDPOINT)
                .client(okHttpClient)
                .build()

        endpoint = retrofit.create(Endpoint::class.java)
    }

    @Provides
    @Singleton
    internal fun provideEndpoint(): Endpoint = endpoint
}