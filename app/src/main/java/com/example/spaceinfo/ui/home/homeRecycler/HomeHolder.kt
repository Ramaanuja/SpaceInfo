package com.example.spaceinfo.ui.home.homeRecycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spaceinfo.databinding.HomeItemBinding

class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: HomeItemBinding = HomeItemBinding.bind(itemView)

//    fun onBind(picture: Picture) {
//        Glide.with(itemView.context)
//            .load(picture.url)
//            .into(binding.homeItemImageView)
//    }

}