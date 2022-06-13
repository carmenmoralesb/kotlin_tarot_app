package es.carmenapps.arcana.core.ui.vo

data class TarotHitVO(
  val listCards: List<ArcanaCardVO>
)

data class ArcanaCardVO(
  val name: String,
  val description: String,
  val meaning: String
)