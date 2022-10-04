package es.carmenapps.arcana.core.ui

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import dagger.hilt.android.AndroidEntryPoint
import es.carmenapps.arcana.MainNavGraphDirections
import es.carmenapps.arcana.TarotLectureAdapterAction
import es.carmenapps.arcana.core.adapter.HomeAdapter
import es.carmenapps.arcana.core.adapter.TarotLectureAdapter
import es.carmenapps.arcana.core.ui.vo.ArcanaCardVO
import es.carmenapps.arcana.databinding.TarotLectureFragmentBinding

@AndroidEntryPoint
class TarotLectureFragment : Fragment() {
  private var binding: TarotLectureFragmentBinding? = null
  private val viewModel: TarotLectureViewModel by viewModels()

  private lateinit var navController: NavController
  private val adapter by lazy {
    TarotLectureAdapter(::adapterListener)
  }


  @SuppressLint("SetTextI18n")
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    navController = findNavController()
    binding = TarotLectureFragmentBinding.inflate(inflater, container, false)
    return binding!!.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initViewModel()
    initRecycler()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    binding = null
  }

  override fun onPause() {
    super.onPause()
  }

  private fun adapterListener(actions: TarotLectureAdapterAction) {
    when (actions) {
      is TarotLectureAdapterAction -> {
      }
    }
  }

  private fun initRecycler() {
    val linearLayoutManager = LinearLayoutManager(context)
    binding?.recyclerView?.layoutManager = linearLayoutManager
    binding?.recyclerView?.adapter = this.adapter
  }

  private fun initViewModel() {
    viewModel.init()
    viewModel.tarotLectureState.observe(viewLifecycleOwner) { state ->
      when (state) {
        TarotLectureState.Error -> {
          showLoading(false)
          showError(true)
        }
        TarotLectureState.Loading -> {
          showLoading(true)
          showError(false)
        }
        is TarotLectureState.Render -> {
          showLoading(false)
          showError(false)
          handleRender(state.listCardsLecture)
        }
      }
    }
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

  private fun handleRender(listCardsLecture: List<ArcanaCardVO>) {
    adapter.submitList(listCardsLecture)
  }

}