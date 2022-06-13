package es.carmenapps.arcana.core.ui

import es.carmenapps.arcana.core.ui.vo.ArcanaCardVO
import es.carmenapps.arcana.data.model.ArcanaCardBO

sealed class TarotLectureState {
  data class Render(val listCardsLecture:  List<ArcanaCardVO>) : TarotLectureState()
  object Loading : TarotLectureState()
  object Error : TarotLectureState()

}