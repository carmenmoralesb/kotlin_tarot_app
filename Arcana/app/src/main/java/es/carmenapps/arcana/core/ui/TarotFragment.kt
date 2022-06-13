package es.carmenapps.arcana.core.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import es.carmenapps.arcana.MainNavGraphDirections
import es.carmenapps.arcana.core.adapter.HomeAdapter
import es.carmenapps.arcana.databinding.TarotFragmentBinding
import es.carmenapps.arcana.util.APP_NAME


class TarotFragment : Fragment() {

  private var binding: TarotFragmentBinding? = null
  private lateinit var prefs: SharedPreferences
  private lateinit var navController: NavController
  private val viewModel: TarotViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    prefs = this.requireActivity().getSharedPreferences(APP_NAME, 0)
    (activity as AppCompatActivity?)!!.supportActionBar!!.hide()    // load data to language list
  }

  @SuppressLint("SetTextI18n")
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // val homeViewModel =
    //   ViewModelProvider(this)[HomeViewModel::class.java]
    navController = findNavController()
    binding = TarotFragmentBinding.inflate(inflater, container, false)
    return binding!!.root
  }

  override fun onResume() {
    super.onResume()
    binding?.buttonGoToLecture?.setOnClickListener {
      navController.navigate(
        MainNavGraphDirections.goToTarotLecture()
      )
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    viewModel.randomUrls.clear()
    binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViewModel()
  }

  override fun onPause() {
    super.onPause()
    viewModel.randomUrls.clear()
  }

  private fun adapterListener(actions: HoroscopeListAdapterAction) {
    when (actions) {
      is HoroscopeListAdapterAction.DetailAction -> {

      }
    }
  }

  private fun initViewModel() {
    viewModel.tarotListState.observe(viewLifecycleOwner) { state ->
      when (state) {
        TarotListState.Error -> {
          showLoading(false)
          showError(true)
        }
        TarotListState.Loading -> {
          showLoading(true)
          showError(false)
        }
        is TarotListState.Render -> {
          showLoading(false)
          showError(false)
          handleRender()
        }
      }
    }
    viewModel.init()
  }

  private fun showLoading(boolean: Boolean) {
    if (boolean) {
      binding?.spinner?.root?.visibility = View.VISIBLE
    } else {
      binding?.spinner?.root?.visibility = View.GONE
    }
  }

  private fun showError(boolean: Boolean) {
    if (boolean) {
      binding?.errorScreen?.root?.visibility = View.VISIBLE
    } else {
      binding?.errorScreen?.root?.visibility = View.GONE
    }
  }

  private fun handleRender() {
    binding?.cardOne?.setOnClickListener {
      // Past
      setAnimation(binding?.cardOne, viewModel.randomUrls.get(0))
    }
    binding?.cardTwo?.setOnClickListener {
      // Present
      setAnimation(binding?.cardTwo, viewModel.randomUrls.get(1))
    }
    binding?.cardThree?.setOnClickListener {
      // Prediction
      setAnimation(binding?.cardThree, viewModel.randomUrls.get(2))
    }
  }

  private fun setAnimation(card: ImageView?, url: String) {
    val oa1 = ObjectAnimator.ofFloat(card, "scaleX", 1f, 0f)
    val oa2 = ObjectAnimator.ofFloat(card, "scaleX", 0f, 1f)
    oa1.interpolator = DecelerateInterpolator()
    oa2.interpolator = AccelerateDecelerateInterpolator()
    oa1.addListener(object : AnimatorListenerAdapter() {
      override fun onAnimationEnd(animation: Animator?) {
        super.onAnimationEnd(animation)

        context?.let {
          if (card != null) {
            Glide.with(it)
              .load(url)
              .centerInside()
              .into(card)
          }
        }

        oa2.start()
      }
    })
    oa1.start()
  }

}