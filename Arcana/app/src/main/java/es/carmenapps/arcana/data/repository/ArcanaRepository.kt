package es.carmenapps.arcana.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import es.carmenapps.arcana.data.remote.toBo
import es.carmenapps.arcana.data.result.*
import es.carmenapps.arcana.network.ArcanaApi
import kotlinx.coroutines.Dispatchers

class ArcanaRepository(private val arcanaApi: ArcanaApi) {

  fun getCards(): LiveData<ArcanaResult> = liveData(Dispatchers.IO) {
    emit(Loading)
    try {
      emit(ArcanaCardsSuccess(arcanaApi.getCards()))
    } catch (e: Exception) {
      emit(ArcanaCardsError(e))
    }
  }

  fun getCard(id: Int): LiveData<ArcanaResult> = liveData(Dispatchers.IO) {
    emit(Loading)
    try {
      emit(ArcanaCardSuccess(arcanaApi.getCard(id)))
    } catch (e: Exception) {
      emit(ArcanaCardError(e))
    }
  }

  fun getRandomCards(nhit: Int): LiveData<ArcanaResult> = liveData(Dispatchers.IO) {
    emit(Loading)
    try {
      emit(ArcanaCardsSuccess(arcanaApi.getRandomCards(nhit)))
    } catch (e: Exception) {
      emit(ArcanaCardsError(e))
    }
  }

}