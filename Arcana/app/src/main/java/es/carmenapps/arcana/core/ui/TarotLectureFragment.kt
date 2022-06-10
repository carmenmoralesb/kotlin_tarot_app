package es.carmenapps.arcana.core.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.carmenapps.arcana.R

class TarotLectureFragment : Fragment() {

  companion object {
    fun newInstance() = TarotLectureFragment()
  }

  private lateinit var viewModel: TarotLectureViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.tarot_lecture_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(TarotLectureViewModel::class.java)
    // TODO: Use the ViewModel
  }

}