package com.example.spaceinfo.ui.overview.overviewRecycler


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.spaceinfo.datalayer.remotedatasource.dto.Picture
import com.example.spaceinfo.datalayer.repository.Repository

class PicturePaging(val rep: Repository): PagingSource<Int, Picture>() {
    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? {

        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picture> {
        return try {
            val nextPage: Int = params.key ?: counter
            val response = rep.getListPictures()

            counter = nextPage
            var nextPageNumber: Int? = ++counter

            counter = nextPage
            var prevPageNumber: Int? = --counter


            var list: List<Picture> = listOf()
            response.body()?.let {
                list = it
            }
            LoadResult.Page(
                data = list,
                prevKey = prevPageNumber,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
        private var counter: Int = 0
    }



}