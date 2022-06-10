package es.carmenapps.arcana.util

fun getZodiac(day: Int, month: Int): String {
  var astroSign = ""
  // checks month and date within the
  // valid range of a specified zodiac
  when (month) {
    12 -> {
      astroSign = if (day < 22) "Sagittarius" else "Capricorn"
    }
    1 -> {
      astroSign = if (day < 20) "Capricorn" else "Aquarius"
    }
    2 -> {
      astroSign = if (day < 19) "Aquarius" else "Pisces"
    }
    3 -> {
      astroSign = if (day < 21) "Pisces" else "Aries"
    }
    4 -> {
      astroSign = if (day < 20) "Aries" else "Taurus"
    }
    5 -> {
      astroSign = if (day < 21) "Taurus" else "Gemini"
    }
    6 -> {
      astroSign = if (day < 21) "Gemini" else "Cancer"
    }
    7 -> {
      astroSign = if (day < 23) "Cancer" else "Leo"
    }
    8 -> {
      astroSign = if (day < 23) "Leo" else "Virgo"
    }
    9 -> {
      astroSign = if (day < 23) "Virgo" else "Libra"
    }
    10 -> {
      astroSign = if (day < 23) "Libra" else "Scorpio"
    }
    11 -> {
      astroSign = if (day < 22) "Scorpio" else "Sagittarius"
    }
  }
  return astroSign
}