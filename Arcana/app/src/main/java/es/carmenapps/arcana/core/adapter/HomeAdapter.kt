package es.carmenapps.arcana.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.carmenapps.arcana.core.ui.HoroscopeListAdapterAction
import es.carmenapps.arcana.core.ui.vo.HoroscopeVO
import es.carmenapps.arcana.databinding.RecyclerHomeItemBinding


class HomeAdapter(
  private val listener: (HoroscopeListAdapterAction) -> Unit,
) : ListAdapter<HoroscopeVO, RecyclerView.ViewHolder>(HoroscopeListDiffUtil()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val binding = RecyclerHomeItemBinding.inflate(
      LayoutInflater.from(parent.context),
      parent,
      false
    )
    return HoroscopeListHolder(binding)
  }


  override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
    when (viewHolder) {
      is HoroscopeListHolder -> {
        viewHolder.bind(
          getItem(position) as HoroscopeVO,
          listener
        )
      }
    }
  }

  inner class HoroscopeListHolder(private val binding: RecyclerHomeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
      item: HoroscopeVO,
      listener: (HoroscopeListAdapterAction) -> Unit
    ) {

      binding.textView.text = item.name
      binding.textDate.text = item.dates

      Glide.with(itemView.context)
        .load(item.photoAvatar)
        .centerInside()
        .into(binding.imageViewPhoto)

      binding.root.setOnClickListener {
        listener(
          HoroscopeListAdapterAction.DetailAction(
            item.name
          )
        )
      }

    }
  }


  class HoroscopeListDiffUtil : DiffUtil.ItemCallback<HoroscopeVO>() {
    override fun areItemsTheSame(oldItem: HoroscopeVO, newItem: HoroscopeVO): Boolean =
      oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: HoroscopeVO, newItem: HoroscopeVO): Boolean =
      oldItem == newItem

  }
}