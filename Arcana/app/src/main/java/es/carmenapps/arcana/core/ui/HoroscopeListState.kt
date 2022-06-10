package es.carmenapps.arcana.core.ui

import es.carmenapps.arcana.core.ui.vo.HoroscopeVO

sealed class HoroscopeListState {
  data class Render(val listHoroscope: List<HoroscopeVO>) : HoroscopeListState()
  object Loading : HoroscopeListState()
  object Error : HoroscopeListState()
}