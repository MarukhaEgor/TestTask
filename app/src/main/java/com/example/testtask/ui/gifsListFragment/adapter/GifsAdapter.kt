package com.example.testtask.ui.gifsListFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.ItemsBinding
import com.example.testtask.ext.loadGif
import com.example.testtask.data.model.SingleGifModel

class GifsAdapter(
    private val showDetail: (url: String) -> Unit,
) : ListAdapter<SingleGifModel, GifsAdapter.ViewHolder>(GifsDiff) {

    object GifsDiff : DiffUtil.ItemCallback<SingleGifModel>() {
        override fun areItemsTheSame(
            oldItem: SingleGifModel,
            newItem: SingleGifModel,
        ): Boolean {
            return oldItem.images.original.url == newItem.images.original.url
        }

        override fun areContentsTheSame(
            oldItem: SingleGifModel,
            newItem: SingleGifModel,
        ): Boolean {
            return oldItem.images.original.url == newItem.images.original.url
        }
    }

    inner class ViewHolder(private val binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gif: SingleGifModel) {
            binding.apply {
                ivGifTableItem.loadGif(gif.images.original.url)
            }
            itemView.setOnClickListener {
                showDetail(gif.images.original.url)
            }
        }
    }

    private fun showDetail(gif: SingleGifModel) = showDetail(gif.images.original.url)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(ItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gif = getItem(position)
        gif.let { holder.bind(it) }
    }
}