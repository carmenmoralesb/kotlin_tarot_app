package es.carmenapps.arcana.core.ui.vo

import java.util.*

data class HoroscopeVO(
  val name: String,
  val photoAvatar: String,
  val photoBig: String,
  val description: String,
  val element: String,
  val defenses: List<String>,
  val defects: List<String>,
  val dates: String
)

fun zodiacToVo(name: String): HoroscopeVO {
  val photoBigUrl =
    "https://astrostyle.com/wp-content/uploads/2020/04/${name.lowercase(Locale.getDefault())}-zodiac-sign-astrostyle.png"
  val photoCircle = "https://astrostyle.com/wp-content/uploads/2020/07/${
    name.replaceFirstChar {
      if (it.isLowerCase()) it.titlecase(
        Locale.getDefault()
      ) else it.toString()
    }
  }-circle-icon.png"

  return when (name.uppercase(Locale.getDefault())) {
    "CANCER" -> {
      HoroscopeVO(
        "Cancer",
        photoCircle,
        photoBigUrl,
        "Those born under the zodiac sign Cancer need to be needed. In all aspects of their lives, they have an overwhelming desire to feel loved and appreciated in order to develop a sense of security and identity. " +
            "To the crab, their sense of home is incredibly important to their feeling of safety.",
        "Water",
        listOf("Nurturing", "Supportive", "Healing"),
        listOf("Dependent", "Indirect", "Moody", "Passive Aggressive"),
        "(June 21-July 22)"
      )
    }

    "SCORPIO" -> {
      HoroscopeVO(
        "Scorpio",
        photoCircle,
        photoBigUrl,
        "Scorpios love to enjoy their own company, so much so that they can become irritated if they are not given their personal alone time. T" +
            "hey are one of the most independent signs of the zodiac and work very well by themselves. Most of them will have an air of mysterious darkness around them, " +
            "they are great at keeping secrets and feel emotions very intensely. " +
            "Because of their independence, they tend to mature very quickly as children, and become fiercely determined (sometimes even forceful) adults.",
        "Water",
        listOf("Passionate", "Driven", "Perceptive"),
        listOf("Vindictive", "Paranoid", "Destructive"),
        "(Oct 23 - Nov 21)"
      )
    }
    "TAURUS" -> {
      HoroscopeVO(
        "Taurus",
        photoCircle,
        photoBigUrl,
        "Those born under the Taurus zodiac sign are often one of the most reliable and dependable signs of the zodiac. They value their sense of security and stability, and this is their role as the second sign of the zodiac. After Aries brings its fiery energy, it is Taurus that lays down the foundations. They will always search for stability in both their choices and the people they associate with.",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Apr 20 - May 20)"
      )
    }

    "CAPRICORN" -> {
      HoroscopeVO(
        "Capricorn",
        photoCircle,
        photoBigUrl,
        "Capricorn is a sign that represents time and responsibility, and its representatives are traditional and often very serious by nature. These individuals possess an inner state of independence that enables significant progress both in their personal and professional lives. They are masters of self-control and have the ability to lead the way, make solid and realistic plans, and manage many people who work for them at any time. They will learn from their mistakes and get to the top based solely on their experience and expertise.\n" +
            "\n" +
            "Belonging to the element of Earth , like Taurus and Virgo, this is the last sign in the trio of practicality and grounding. Not only do they focus on the material world, but they have the ability to use the most out of it. Unfortunately, this element also makes them stiff and sometimes too stubborn to move from one perspective or point in a relationship. They have a hard time accepting differences of other people that are too far from their character, and out of fear might try to impose their traditional values aggressively.",
        "Earth",
        listOf("Disciplined", "Responsible", "Self-control"),
        listOf("Know-it-all", "Unforgiving", "Condescending"),
        "(Dec 22 - Jan 19)"
      )
    }

    "ARIES" -> {
      HoroscopeVO(
        "Aries",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Mar 21 - Apr 19)"
      )
    }

    "SAGITTARIUS" -> {
      HoroscopeVO(
        "Sagttarius",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Nov 22 - Dec 21)"
      )
    }
    "VIRGO" -> {
      HoroscopeVO(
        "Virgo",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Aug 23 - Sep 22)"
      )
    }
    "PISCES" -> {
      HoroscopeVO(
        "Pisces",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Feb 19 - Mar 20)"
      )
    }
    "AQUARIUS" -> {
      HoroscopeVO(
        "Aquarius",
        photoCircle,
        photoBigUrl,
        "One of the most obvious traits of those born under the Aquarius zodiac sign is " +
            "that they are kind, friendly and generous, though later you may find that they are quite guarded and may choose to keep some emotional distance. Alongside this, they are quite subversive and rebellious - filled with many quirks that make them memorable characters of the zodiac  Despite their friendly nature, they have a reputation for being outsiders - ones that cooly observe  society, while sometimes also feeling detached from the systems that run it. Although they can be quite aloof, they are also deeply concerned with humanitarian causes. Aquarians tend to care very much for the welfare of others and society as a whole.",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Jan 20 - Feb 18)"
      )
    }

    "LEO" -> {
      HoroscopeVO(
        "Leo",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Feb 19 - Mar 20)"
      )
    }

    "GEMINI" -> {
      HoroscopeVO(
        "Leo",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Feb 19 - Mar 20)"
      )
    }

    else -> {
      HoroscopeVO(
        "Unknown",
        photoCircle,
        photoBigUrl,
        "",
        "Earth",
        listOf("Steady", "Driven", "Trustworthy"),
        listOf("Materialistic", "Fanatical", "Indulgent"),
        "(Oct 23 - Nov 21)"
      )
    }
  }
}
