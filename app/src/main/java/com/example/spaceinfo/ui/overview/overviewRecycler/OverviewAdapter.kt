package com.example.spaceinfo.ui.overview.overviewRecycler


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.R



class OverviewAdapter() : PagingDataAdapter<Picture, OverviewHolder>(DiffUtilCallBack()) {


    override fun onBindViewHolder(holder: OverviewHolder, position: Int) {
        getItem(position)?.url?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_holder, parent, false)
        return OverviewHolder(inflater)
    }
}


class DiffUtilCallBack : DiffUtil.ItemCallback<Picture>() {
    override fun areItemsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Picture, newItem: Picture): Boolean {
        return oldItem.url == newItem.url
    }

}
