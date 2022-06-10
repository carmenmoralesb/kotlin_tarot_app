package es.carmenapps.arcana.core.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import es.carmenapps.arcana.R
import es.carmenapps.arcana.core.ui.vo.HoroscopeVO
import es.carmenapps.arcana.core.ui.vo.zodiacToVo
import es.carmenapps.arcana.databinding.FragmentDetailHoroscopeBinding
import java.util.*

class FragmentDetailHoroscope : Fragment() {
  private lateinit var prefs: SharedPreferences
  private var binding: FragmentDetailHoroscopeBinding? = null
  private lateinit var zodiac: HoroscopeVO
  private val args: FragmentDetailHoroscopeArgs by navArgs()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    /*  arguments?.let {
       param1 = it.getString(ARG_PARAM1)
       param2 = it.getString(ARG_PARAM2)
     } */
  }


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDetailHoroscopeBinding.inflate(inflater, container, false)
    return binding!!.root
  }

  override fun onResume() {
    super.onResume()
    zodiac = zodiacToVo(args.name.uppercase(Locale.getDefault()))

    binding?.let {
      Glide
        .with(this)
        .load(zodiac.photoBig)
        .centerCrop()
        .into(it.horoscopePhotoBig)
    };


    binding?.toolbarTitle?.title = zodiac.name

    binding?.horoscopePhotoBig?.let {
      Glide.with(this)
        .load(zodiac.photoBig)
        .centerInside()
        .into(it)
    }

    val resourceBackgorund = when (zodiac.name) {
      "Aquarius" -> resources.getColor(R.color.aquarius)
      "Taurus" -> resources.getColor(R.color.taurus)
      "Scorpio" -> resources.getColor(R.color.scorpio)
      "Virgo" -> resources.getColor(R.color.virgo)
      "Libra" -> resources.getColor(R.color.libra)
      "Capricorn" -> resources.getColor(R.color.capricorn)
      "Gemini" -> resources.getColor(R.color.gemini)
      "Sagittarius" -> resources.getColor(R.color.sagittarius)
      "Pisces" -> resources.getColor(R.color.pisces)
      "Cancer" -> resources.getColor(R.color.cancer)
      "Leo" -> resources.getColor(R.color.leo)
      "Aries" -> resources.getColor(R.color.aries)

      else -> resources.getColor(R.color.white)
    }

    binding?.horoscopePhotoBig?.setBackgroundColor(
      resourceBackgorund
    )

    binding?.horoscopeDescriptionText?.text = zodiac.description
    binding?.chipCrimson?.text = zodiac.defenses.get(1)
    binding?.chipYellow?.text = zodiac.defects.get(1)
    binding?.chipRed?.text = zodiac.defenses.get(2)
  }

  companion object {
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
      FragmentDetailHoroscope().apply {
        arguments = Bundle().apply {
          // putString(ARG_PARAM1, param1)
          // putString(ARG_PARAM2, param2)
        }
      }
  }
}