package es.carmenapps.arcana.data.remote

import com.google.gson.annotations.SerializedName
import es.carmenapps.arcana.data.model.ArcanaCardBO
import es.carmenapps.arcana.data.model.CardPhoto

data class ArcanaCardDTO(
  @SerializedName("name")
  val name: String,
  @SerializedName("name_short")
  val name_short: String,
  @SerializedName("value")
  val value: String,
  @SerializedName("suit")
  val suit: String,
  @SerializedName("type")
  val type: String,
  @SerializedName("meaning_up")
  val meaningUp: String,
  @SerializedName("meaning_rev")
  val meaningRev: String,
  @SerializedName("desc")
  val desc: String,
)

fun ArcanaCardDTO.toBo(): ArcanaCardBO  {
  val getImage = CardPhoto.valueOf(this.name_short)
  return ArcanaCardBO(
    name = this.name,
    image = getImage.resource,
    value = this.value,
    suit = this.suit,
    type = this.type,
    description = this.desc,
    meaningUp = this.meaningUp,
    meaningRev = this.meaningRev
  )
}