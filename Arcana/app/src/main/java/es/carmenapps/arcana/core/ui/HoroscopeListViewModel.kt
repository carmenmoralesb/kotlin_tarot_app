package es.carmenapps.arcana.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.carmenapps.arcana.core.ui.vo.zodiacToVo
import kotlinx.coroutines.launch
import javax.inject.Inject

class HoroscopeListViewModel @Inject constructor(
  //private val repository: Repository,
) : ViewModel() {
  private val _horoscopeListState = MutableLiveData<HoroscopeListState>()
  val horoscopeListState: LiveData<HoroscopeListState>
    get() = _horoscopeListState

  fun init() {
    _horoscopeListState.postValue(HoroscopeListState.Loading)
    loadHoroscopes()
  }

  private fun loadHoroscopes() {
    val listHoroscopes: List<String> = listOf(
      "Taurus",
      "Pisces",
      "Aquarius",
      "Capricorn",
      "Scorpio",
      "Cancer",
      "Virgo",
      "Gemini",
      "Leo",
      "Aries"
    )
    viewModelScope.launch {
      val listHoroscopeVO = listHoroscopes.map { zodiacToVo(it) }
      if (listHoroscopeVO.isEmpty().not()) {
        _horoscopeListState.postValue(HoroscopeListState.Render(listHoroscopeVO))
      } else {
        _horoscopeListState.postValue(HoroscopeListState.Error)
      }
    }
  }

}