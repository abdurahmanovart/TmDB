package ai.arturxdroid.tmdb.di

import ai.arturxdroid.tmdb.network.TmDBApi
import ai.arturxdroid.tmdb.network.TmDBRepository
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
public class NetworkModule {

    public val BASE_URL = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun provideAuthInterceptor(): Interceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    @Provides
    @Singleton
    fun provideClient(authInterceptor: Interceptor): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideLifehackApi(retrofit: Retrofit): TmDBApi =
        retrofit.create(TmDBApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: TmDBApi): TmDBRepository {
        return TmDBRepository(api)
    }
}