package es.carmenapps.arcana.data.remote

import com.google.gson.annotations.SerializedName
import es.carmenapps.arcana.data.model.ArcanaCardBO

data class ArcanaListCardsDTO(
  @SerializedName("nhits")
  val nhits: String,
  @SerializedName("cards")
  val cards: List<ArcanaCardDTO>,
)

fun ArcanaListCardsDTO.toBo(): List<ArcanaCardBO> {
  return cards.map { it.toBo() }
}