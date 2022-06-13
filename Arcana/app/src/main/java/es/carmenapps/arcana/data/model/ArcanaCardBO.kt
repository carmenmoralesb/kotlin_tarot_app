package es.carmenapps.arcana.data.model

import es.carmenapps.arcana.core.ui.vo.ArcanaCardVO
import kotlin.random.Random

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

fun ArcanaCardBO.toVo(): ArcanaCardVO {
  // chooses random boolean
  val isRev = Random.nextBoolean()

  return ArcanaCardVO(
    description = this.description,
    name = this.name,
    meaning = if (isRev) {
      this.meaningRev
    } else this.meaningUp
  )
}