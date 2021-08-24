package com.example.spaceinfo.ui.overview.overviewRecycler



import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spaceinfo.databinding.ItemHolderBinding


class OverviewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding: ItemHolderBinding = ItemHolderBinding.bind(itemView)

    fun bind(url: String) {
        Glide
            .with(itemView.context)
            .load(url)
            .into(binding.imagePost)
    }



}