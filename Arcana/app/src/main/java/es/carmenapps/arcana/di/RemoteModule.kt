package es.carmenapps.arcana.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.carmenapps.arcana.network.ArcanaApi
import es.carmenapps.arcana.util.ARCANA_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {

  @Singleton
  @Provides
  fun provideRemoteService(): ArcanaApi {

    val interceptor = HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
    //Client
    val client = OkHttpClient.Builder()
      .addInterceptor(interceptor)
      .build()

    val retrofit = Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .baseUrl(ARCANA_URL)
      .build()

    return retrofit.create(ArcanaApi::class.java)
  }
}