package es.carmenapps.arcana.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.carmenapps.arcana.TarotLectureAdapterAction
import es.carmenapps.arcana.core.ui.vo.ArcanaCardVO
import es.carmenapps.arcana.databinding.TarotLectureItemBinding

class TarotLectureAdapter(
  private val listener: (TarotLectureAdapterAction) -> Unit,
) : ListAdapter<ArcanaCardVO, RecyclerView.ViewHolder>(TarotCardListDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val binding = TarotLectureItemBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
    return TarotLectureViewHolder(binding)
  }


  override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
    when (viewHolder) {
      is TarotLectureViewHolder -> {
        viewHolder.bind(
          getItem(position) as ArcanaCardVO,
          listener
        )
      }
    }
  }

  inner class TarotLectureViewHolder(private val binding: TarotLectureItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
      item: ArcanaCardVO,
      listener: (TarotLectureAdapterAction) -> Unit
    ) {

      binding.titleCardName.text = item.name
      binding.cardMeaningText.text = item.meaning

      if (item.isReversed) {
        binding.imageView.rotation = 180F
      }

      Glide.with(itemView.context)
        .load(item.urlImage)
        .centerInside()
        .into(binding.imageView)
    }
  }


  class TarotCardListDiffUtil : DiffUtil.ItemCallback<ArcanaCardVO>() {
    override fun areItemsTheSame(oldItem: ArcanaCardVO, newItem: ArcanaCardVO): Boolean =
      oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: ArcanaCardVO, newItem: ArcanaCardVO): Boolean =
      oldItem == newItem

  }
}