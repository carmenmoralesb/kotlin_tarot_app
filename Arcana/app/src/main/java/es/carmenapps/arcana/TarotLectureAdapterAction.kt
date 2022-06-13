package es.carmenapps.arcana

import es.carmenapps.arcana.core.ui.HoroscopeListAdapterAction

sealed class TarotLectureAdapterAction {
  data class DetailAction(val name: String) : TarotLectureAdapterAction()
  //TODO FUTURE ACTIONS ON ROWS
}