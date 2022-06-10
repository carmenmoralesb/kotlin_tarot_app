package es.carmenapps.arcana.data.result

import es.carmenapps.arcana.data.remote.ArcanaCardDTO

sealed class ArcanaResult

object Loading: ArcanaResult()

class ArcanaCardsSuccess(val cards: List<ArcanaCardDTO>): ArcanaResult()

class ArcanaCardsError(val error: Exception): ArcanaResult()

class ArcanaCardSuccess(val card: ArcanaCardDTO): ArcanaResult()

class ArcanaCardError(val error: Exception): ArcanaResult()