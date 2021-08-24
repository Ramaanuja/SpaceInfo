package com.example.spaceinfo.ui.home.homeRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceinfo.R


//class HomeAdapter() : RecyclerView.Adapter<HomeHolder>() {
//
//    var seeAlsoList = listOf<Picture>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
//        return HomeHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
//        holder.onBind(seeAlsoList[position])
//    }
//
//    override fun getItemCount(): Int = seeAlsoList.size
//}