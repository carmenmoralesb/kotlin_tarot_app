package es.carmenapps.arcana.network

import es.carmenapps.arcana.data.remote.ArcanaCardDTO
import es.carmenapps.arcana.data.remote.TarotHitDTO
import es.carmenapps.arcana.util.ARCANA_URL
import es.carmenapps.arcana.util.ARCANA_URL_CARDS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArcanaApi {

  @GET(ARCANA_URL_CARDS)
  suspend fun getCards(): List<ArcanaCardDTO>

  @GET("${ARCANA_URL_CARDS}name_short")
  suspend fun getCard(@Path("id") id: Int): ArcanaCardDTO

  @GET("${ARCANA_URL_CARDS}random")
  suspend fun getRandomCards(@Query(value = "n", encoded = true) id: Int): TarotHitDTO
}