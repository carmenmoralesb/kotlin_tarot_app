package es.carmenapps.arcana.core.ui

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import es.carmenapps.arcana.MainNavGraphDirections
import es.carmenapps.arcana.core.adapter.HomeAdapter
import es.carmenapps.arcana.core.ui.vo.HoroscopeVO
import es.carmenapps.arcana.databinding.FragmentHomeBinding
import es.carmenapps.arcana.util.APP_NAME


class HomeFragment : Fragment() {

  private var binding: FragmentHomeBinding? = null
  private lateinit var prefs: SharedPreferences
  private lateinit var listHoroscopeVO: List<HoroscopeVO>
  private lateinit var navController: NavController
  private val viewModel: HoroscopeListViewModel by viewModels()

  private val adapter by lazy {
    HomeAdapter(::adapterListener)
  }

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
    binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding!!.root
  }

  override fun onResume() {
    super.onResume()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecycler()
    initViewModel()
  }

  private fun adapterListener(actions: HoroscopeListAdapterAction) {
    when (actions) {
      is HoroscopeListAdapterAction.DetailAction -> {
        navController.navigate(
          MainNavGraphDirections.goToHoroscopeDetail(
            actions.name
          )
        )
      }
    }
  }

  private fun initViewModel() {
    viewModel.horoscopeListState.observe(viewLifecycleOwner) { state ->
      when (state) {
        HoroscopeListState.Error -> {
          showLoading(false)
          showError(true)
        }
        HoroscopeListState.Loading -> {
          showLoading(true)
          showError(false)
        }
        is HoroscopeListState.Render -> {
          showLoading(false)
          showError(false)
          handleRender(state.listHoroscope)
        }
      }
    }
    viewModel.init()
  }

  private fun initRecycler() {
    val linearLayoutManager = GridLayoutManager(context, 2)
    binding?.recyclerView?.layoutManager = linearLayoutManager
    binding?.recyclerView?.setHasFixedSize(true)
    binding?.recyclerView?.adapter = this.adapter
  }

  private fun showLoading(boolean: Boolean) {
    if (boolean) {
      binding?.spinner?.root?.visibility = View.VISIBLE
    } else {
      binding?.spinner?.root?.visibility  = View.GONE
    }
  }

  private fun showError(boolean: Boolean) {
    if (boolean) {
      binding?.errorScreen?.root?.visibility = View.VISIBLE
    } else {
      binding?.errorScreen?.root?.visibility = View.GONE
    }
  }

  private fun handleRender(horoscope: List<HoroscopeVO>) {
    adapter.submitList(horoscope)
  }

}