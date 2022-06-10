package es.carmenapps.arcana.network

import es.carmenapps.arcana.data.remote.ArcanaCardDTO
import es.carmenapps.arcana.util.ARCANA_URL
import es.carmenapps.arcana.util.ARCANA_URL_CARDS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TarotApi {

  @GET(ARCANA_URL_CARDS)
  suspend fun getHoroscope(): List<ArcanaCardDTO>

  companion object {

    private var backedApi: TarotApi? = null

    val instance: TarotApi by lazy {
      if (backedApi == null){
        backedApi = createApi()
        backedApi!!
      }else {
        backedApi!!
      }
    }

    private fun createApi(): TarotApi {
      //Interceptor
      val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
      }
      //Client
      val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

      //Retrofit
      val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(ARCANA_URL)
        .build()

      return retrofit.create(TarotApi::class.java)
    }


  }

}