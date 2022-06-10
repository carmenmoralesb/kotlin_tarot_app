package es.carmenapps.arcana.core.ui

sealed class HoroscopeListAdapterAction {
  data class DetailAction(val name: String) : HoroscopeListAdapterAction()
  //TODO FUTURE ACTIONS ON ROWS
}