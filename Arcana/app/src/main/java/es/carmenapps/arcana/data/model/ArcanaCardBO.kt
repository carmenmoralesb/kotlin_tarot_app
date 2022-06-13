package es.carmenapps.arcana.data.model

import es.carmenapps.arcana.core.ui.vo.ArcanaCardVO
import es.carmenapps.arcana.core.ui.vo.TarotHitVO
import kotlin.random.Random

data class TarotHitBO(
  val listCards: List<ArcanaCardBO>
)

data class ArcanaCardBO(
  val name: String,
  val value: String,
  val suit: String,
  val type: String,
  val description: String,
  val image: String,
  val meaningUp: String,
  val meaningRev: String
)

fun TarotHitBO.toVo(): TarotHitVO {
  // chooses random boolean
  return TarotHitVO(
    listCards = this.listCards.map { it.toVo() }
  )
}

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