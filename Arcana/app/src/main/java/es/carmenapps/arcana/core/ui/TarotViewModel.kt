package es.carmenapps.arcana.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.carmenapps.arcana.core.ui.vo.zodiacToVo
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class TarotViewModel @Inject constructor(
  //private val repository: Repository,
) : ViewModel() {

  val randomUrls = mutableListOf<String>()

  private val _tarotListState = MutableLiveData<TarotListState>()
  val tarotListState: LiveData<TarotListState>
    get() = _tarotListState

  fun init() {
    _tarotListState.postValue(TarotListState.Loading)
    generateCardUrl()
  }

  private fun generateCardUrl(): String {
    val numberList =
      listOf("ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "king", "queen", "knight")
    val minorList = listOf("cups", "pent", "swords", "wands")
    val majorList = listOf(
      "highpriestess",
      "empress",
      "emperor",
      "heirophant",
      "lovers",
      "chariot",
      "strength",
      "hermit",
      "wheeloffortune",
      "hanged",
      "death",
      "temperance",
      "devil",
      "tower",
      "star",
      "moon",
      "sun",
      "judgement",
      "world"
    )

    val randomMinor = numberList.randomOrNull() + minorList.randomOrNull()
    val randomMajor = majorList.randomOrNull()

    val listOfRandom = listOf(randomMajor.toString(), randomMinor)
    while (randomUrls.size < 4) {
      val randomMinor = numberList.randomOrNull() + minorList.randomOrNull()
      val randomMajor = majorList.randomOrNull()
      val listOfRandom = listOf(randomMajor.toString(), randomMinor)
      val generatedUrl =
        "https://cdn.thetarotlady.com/wp-content/uploads/2018/12/${listOfRandom.random()}.jpg"

      if (!listOfRandom.contains(generatedUrl)) {
        randomUrls.add(generatedUrl)
      }

      viewModelScope.launch {
        _tarotListState.postValue(TarotListState.Render(randomUrls))
      }
    }
    return "https://cdn.thetarotlady.com/wp-content/uploads/2018/12/${listOfRandom.random()}.jpg"
  }

}