package es.carmenapps.arcana.core.ui

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
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

@HiltViewModel
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
      val cardsLecture = repository.getRandomCards(4)
      val lisCardLecture = cardsLecture.map { it.toVo() }

      viewModelScope.launch {
        _tarotLectureState.postValue(TarotLectureState.Render(lisCardLecture))
      }
    }
  }
}