package com.example.spaceinfo.ui.home.homeRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceinfo.R
import com.example.spaceinfo.domain.entities.PictureOfDay
import com.example.spaceinfo.ui.home.HomeViewModel
import javax.inject.Inject


//class HomeAdapter @Inject constructor(private val viewModel: HomeViewModel) : RecyclerView.Adapter<HomeHolder>() {
class HomeAdapter @Inject constructor() : RecyclerView.Adapter<HomeHolder>() {

    var seeAlsoList = listOf<PictureOfDay>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.onBind(seeAlsoList[position])
    }

    override fun getItemCount(): Int = seeAlsoList.size
}