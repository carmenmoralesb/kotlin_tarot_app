package es.carmenapps.arcana.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.carmenapps.arcana.data.model.toVo
import es.carmenapps.arcana.data.repository.ArcanaRepository
import kotlinx.coroutines.launch
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

      if (lisCardLecture.isNotEmpty()) {
        _tarotLectureState.postValue(TarotLectureState.Render(lisCardLecture))
      } else {
        _tarotLectureState.postValue(TarotLectureState.Error)
      }
    }
  }
}