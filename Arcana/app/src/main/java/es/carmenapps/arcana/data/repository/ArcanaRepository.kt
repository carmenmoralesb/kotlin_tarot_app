package es.carmenapps.arcana.data.repository

import es.carmenapps.arcana.data.model.ArcanaCardBO
import es.carmenapps.arcana.data.model.TarotHitBO
import es.carmenapps.arcana.data.remote.toBo
import es.carmenapps.arcana.network.ArcanaApi
import timber.log.Timber
import javax.inject.Inject

class ArcanaRepository @Inject constructor(
  private val remoteService: ArcanaApi
) {
  suspend fun getAllCards(): List<ArcanaCardBO> {
    val cards = mutableListOf<ArcanaCardBO>()
    val resource = remoteService.getCards()

    if (resource.isNotEmpty()) {
      cards.addAll(
        resource.map { it.toBo() }
      )
    }
    return cards
  }

  suspend fun getRandomCards(numberRandom: Int): List<ArcanaCardBO> {
    val cards = mutableListOf<ArcanaCardBO>()
    val resource = remoteService.getRandomCards(numberRandom).toBo()
    Timber.d("Cartas randomizadas  + ${cards.firstOrNull()?.description}")

    return resource.listCards
  }

  suspend fun getOneCard(id: Int): ArcanaCardBO {
    val resource = remoteService.getCard(id)
    return resource.toBo()
  }
}
