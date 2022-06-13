package es.carmenapps.arcana.core.ui

import androidx.lifecycle.*
import es.carmenapps.arcana.data.model.ArcanaCardBO
import es.carmenapps.arcana.data.model.toVo
import es.carmenapps.arcana.data.remote.toBo
import es.carmenapps.arcana.data.repository.ArcanaRepository
import es.carmenapps.arcana.data.result.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class TarotLectureViewModel @Inject constructor(
  private val repository: ArcanaRepository,
) : ViewModel() {


  private val _tarotLectureState = MutableLiveData<TarotLectureState>()
  val tarotLectureState: LiveData<TarotLectureState>
    get() = _tarotLectureState

  fun init() {
    _tarotLectureState.postValue(TarotLectureState.Loading)
    retrieveLecture()
  }

  private fun retrieveLecture() {
    viewModelScope.launch {
      var cardsLecture = listOf<ArcanaCardBO>()

      repository.getRandomCards(4).asFlow().collect { value ->
        when (value) {
          is ArcanaCardsSuccess -> {
            cardsLecture = value.cards.map { it.toBo() }
          }
          is ArcanaCardError -> {
            Timber.d("Error en la lectura")
          }
          is ArcanaCardSuccess -> {
            Timber.d("Error en la lectura")
          }
          is ArcanaCardsError -> {
            Timber.d("Error en la lectura")
          }
          Loading -> {

          }
        }
      }

      val lisCardLecture = cardsLecture.map { it.toVo() }

      viewModelScope.launch {
        _tarotLectureState.postValue(TarotLectureState.Render(lisCardLecture))
      }
    }
  }
}