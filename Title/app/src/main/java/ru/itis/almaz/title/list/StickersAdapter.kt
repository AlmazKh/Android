package ru.itis.almaz.title.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_sticker.view.*
import ru.itis.almaz.title.R
import ru.itis.almaz.title.data.Sticker

class StickersAdapter(private val clickListener: (Sticker, View) -> Unit) :
    ListAdapter<Sticker, StickersAdapter.Holder>(StickerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        return Holder(
            inflater.inflate(
                R.layout.item_sticker,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sticker: Sticker, clickListener: (Sticker, View) -> Unit) {
            itemView.tv_name.text = sticker.name
            Glide.with(itemView)
                .load(sticker.photoUrl)
                .into(itemView.iv_photo)

            itemView.setOnClickListener {
                clickListener(sticker, it)
            }
        }
    }

    class StickerDiffCallback : DiffUtil.ItemCallback<Sticker>() {
        override fun areItemsTheSame(oldItem: Sticker, newItem: Sticker): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Sticker, newItem: Sticker): Boolean {
            return oldItem == newItem
        }
    }
}
