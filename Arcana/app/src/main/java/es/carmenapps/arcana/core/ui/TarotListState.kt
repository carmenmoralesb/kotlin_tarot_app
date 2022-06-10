package es.carmenapps.arcana.core.ui

sealed class TarotListState {
  data class Render(val listUrls: List<String>) : TarotListState()
  object Loading : TarotListState()
  object Error : TarotListState()

}