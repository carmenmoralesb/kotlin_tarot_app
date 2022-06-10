package es.carmenapps.arcana.data.model

import es.carmenapps.arcana.R

enum class Suits {
  WANDS, PENTACLES, SWORDS, CUPS
}

enum class Type {
  MINOR, MAJOR
}

enum class CardPhoto(val nameShort: String, val resource: Int) {
  //MAJORS
  THE_DEVIL("ar15", R.drawable.ic_the_devil),
  HIGH_PRIESTESS("ar02", R.drawable.ic_high_priestess),
  THE_MOON("ar18", R.drawable.ic_the_moon),
  THE_EMPRESS("ar03", R.drawable.ic_the_empress),

  //SWORDS
  ACE_SWORD("sw01", R.drawable.ic_ace_of_swords),
  TWO_SWORD("sw02", R.drawable.ic_the_moon),
  THREE_SWORDS("sw03", R.drawable.ic_three_of_swords),
  FOUR_SWORDS("sw04", R.drawable.ic_four_of_swords),
  FIVE_SWORDS("sw05", R.drawable.ic_five_of_swords),
  SIX_SWORDS("sw06", R.drawable.ic_six_of_swords),
  SEVEN_SWORDS("sw07", R.drawable.ic_seven_of_swords),
  EIGHT_SWORDS("sw08", R.drawable.ic_eight_of_swords),
  NINE_SWORDS("sw09", R.drawable.ic_nine_of_swords),
  TEN_SWORDS("sw10", R.drawable.ic_ten_of_swords),
  PAGE_SWORDS("swpa", R.drawable.ic_ten_of_swords),
  KNIGHT_SWORDS("swpa", R.drawable.ic_knight_of_swords),
  QUEEN_SWORDS("swpa", R.drawable.ic_queen_of_swords),
  KING_SWORDS("sw12", R.drawable.ic_king_of_swords),

  // PENTACLES
  ONE_PENTACLES("pe01", R.drawable.ic_the_moon),
  TWO_PENTACLES("pe02", R.drawable.ic_the_moon),
  THREE_PENTACLES("pe03", R.drawable.ic_the_moon),
  FOUR_PENTACLES("pe04", R.drawable.ic_the_moon),
  FIVE_PENTACLES("pe05", R.drawable.ic_the_moon),
  SIX_PENTACLES("pe06", R.drawable.ic_the_moon),
  SEVEN_PENTACLES("pe07", R.drawable.ic_the_moon),
  NINE_PENTACLES("pe08", R.drawable.ic_the_moon),
  TEN_PENTACLES("pe09", R.drawable.ic_the_moon),
  PAGE_PENTACLES("pepa", R.drawable.ic_the_moon),
  KNIGHT_PENTACLES("pekn", R.drawable.ic_the_moon),
  QUEEN_PENTACLES("pequ", R.drawable.ic_the_moon),
  KING_PENTACLES("peki", R.drawable.ic_the_moon),

  //CUPS
  ONE_CUPS("cu01", R.drawable.ic_ace_of_cups),
  TWO_CUPS("cu02", R.drawable.ic_two_of_cups),
  THREE_CUPS("cu03", R.drawable.ic_three_of_cups),
  FOUR_CUPS("cu04", R.drawable.ic_the_moon),
  FIVE_CUPS("cu05", R.drawable.ic_the_moon),
  SIX_CUPS("cu06", R.drawable.ic_the_moon),
  SEVEN_CUPS("cu07", R.drawable.ic_the_moon),
  NINE_CUPS("cu08", R.drawable.ic_the_moon),
  TEN_CUPS("cu09", R.drawable.ic_the_moon),
  PAGE_CUPS("cupa", R.drawable.ic_the_moon),
  KNIGHT_CUPS("cukn", R.drawable.ic_the_moon),
  QUEEN_CUPS("cuqu", R.drawable.ic_the_moon),
  KING_CUPS("cuki", R.drawable.ic_the_moon),

  // WANDS
  ONE_WANDS("wa01", R.drawable.ic_the_moon),
  TWO_WANDS("wa02", R.drawable.ic_the_moon),
  THREE_WANDS("wa03", R.drawable.ic_the_moon),
  FOUR_WANDS("wa04", R.drawable.ic_the_moon),
  FIVE_WANDS("wa05", R.drawable.ic_the_moon),
  SIX_WANDS("wa06", R.drawable.ic_the_moon),
  SEVEN_WANDS("wa07", R.drawable.ic_the_moon),
  NINE_WANDS("wa08", R.drawable.ic_the_moon),
  TEN_WANDS("wa09", R.drawable.ic_the_moon),
  PAGE_WANDS("wapa", R.drawable.ic_the_moon),
  KNIGHT_WANDS("wakn", R.drawable.ic_the_moon),
  QUEEN_WANDS("waqu", R.drawable.ic_the_moon),
  KING_WANDS("waki", R.drawable.ic_the_moon),

}