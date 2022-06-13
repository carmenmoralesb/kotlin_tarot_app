package es.carmenapps.arcana.data.model

import es.carmenapps.arcana.R

fun getCardPhoto(nameShort: String): String {

  return when (nameShort) {
    // MAJORS
    "ar01" -> "magician"
    "ar02" -> "priestess"
    "ar03" -> "empress"
    "ar04" -> "emperor"
    "ar05" -> "heirophant"
    "ar06" -> "lovers"
    "ar07" -> "chariot"
    "ar08" -> "Fortitude"
    "ar09" -> "hermit"
    "ar10" -> "wheeloffortune"
    "ar11" -> "justice"
    "ar12" -> "hanged"
    "ar13" -> "death"
    "ar14" -> "temperance"
    "ar15" -> "devil"
    "ar16" -> "tower"
    "ar17" -> "star"
    "ar18" -> "moon"
    "ar19" -> "sun"
    "ar20" -> "judgement"
    "ar21" -> "fool"
    "ar22" -> "world"

    // WANDS
    "wapa" -> "pagewands"
    "wakn" -> "knightwands"
    "waqn" -> "queenwands"
    "waki" -> "kinbgwands"
    "waac" -> "acewands"
    "wa02" -> "2wands"
    "wa03" -> "3wands"
    "wa04" -> "4wands"
    "wa05" -> "5wands"
    "wa06" -> "6wands"
    "wa07" -> "7wands"
    "wa08" -> "8wands"
    "wa09" -> "9wands"
    "wa10" -> "10wands"

    // PENTACLES
    "pepa" -> "pagewands"
    "pekn" -> "knightwands"
    "peqn" -> "queenwands"
    "peki" -> "kinbgwands"
    "peac" -> "acewands"
    "pe02" -> "2wands"
    "pe03" -> "3wands"
    "pe04" -> "4wands"
    "pe05" -> "5wands"
    "pe06" -> "6wands"
    "pe07" -> "7wands"
    "pe08" -> "8wands"
    "pe09" -> "9wands"
    "pe10" -> "10wands"

    // CUPS
    "cupa" -> "pagecups"
    "cukn" -> "knightcups"
    "cuqn" -> "queencups"
    "cuki" -> "kinbgcups"
    "cuac" -> "acecups"
    "cu02" -> "2cups"
    "cu03" -> "3cups"
    "cu04" -> "4cups"
    "cu05" -> "5cups"
    "cu06" -> "6cups"
    "cu07" -> "7cups"
    "cu08" -> "8cups"
    "cu09" -> "9cups"
    "cu10" -> "10cups"

    // SWORDS
    "swpa" -> "pageswords"
    "swkn" -> "knightswords"
    "swqn" -> "queenswords"
    "swki" -> "kinbgswords"
    "swac" -> "aceswords"
    "sw02" -> "2swords"
    "sw03" -> "3swords"
    "sw04" -> "4swords"
    "sw05" -> "5swords"
    "sw06" -> "6swords"
    "sw07" -> "7swords"
    "sw08" -> "8swords"
    "sw09" -> "9swords"
    "sw10" -> "10swords"

    else -> {
      ""
    }
  }


}