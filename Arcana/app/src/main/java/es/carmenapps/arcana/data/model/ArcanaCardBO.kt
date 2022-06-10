package es.carmenapps.arcana.data.model

data class ArcanaCardBO(
  val name: String,
  val value: String,
  val suit: String,
  val type: String,
  val description: String,
  val image: Int,
  val meaningUp: String,
  val meaningRev: String
)