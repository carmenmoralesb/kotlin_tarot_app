package es.carmenapps.arcana.data.remote

import com.google.gson.annotations.SerializedName
import es.carmenapps.arcana.data.model.ArcanaCardBO
import es.carmenapps.arcana.data.model.TarotHitBO
import es.carmenapps.arcana.data.model.getCardPhoto

data class TarotHitDTO(
  @SerializedName("nhits")
  val nhits: Int,
  @SerializedName("cards")
  val cards: List<ArcanaCardDTO>
)

data class ArcanaCardDTO(
  @SerializedName("name")
  val name: String,
  @SerializedName("name_short")
  val name_short: String,
  @SerializedName("value")
  val value: String,
  @SerializedName("suit")
  val suit: String?,
  @SerializedName("type")
  val type: String,
  @SerializedName("meaning_up")
  val meaningUp: String,
  @SerializedName("meaning_rev")
  val meaningRev: String,
  @SerializedName("desc")
  val desc: String,
)

fun TarotHitDTO.toBo(): TarotHitBO {
  return TarotHitBO(listCards = this.cards.map { it.toBo() })
}

fun ArcanaCardDTO.toBo(): ArcanaCardBO {
  return ArcanaCardBO(
    name = this.name,
    image = "https://cdn.thetarotlady.com/wp-content/uploads/2018/12/${getCardPhoto(this.name_short)}.jpg",
    value = this.value,
    suit = this.suit ?: "",
    type = this.type,
    description = this.desc,
    meaningUp = this.meaningUp,
    meaningRev = this.meaningRev
  )
}