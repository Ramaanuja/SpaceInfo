package com.example.spaceinfo.ui.overview

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceinfo.ResponseResult
import com.example.spaceinfo.databinding.FragmentOverviewBinding



class OverviewFragment : Fragment() {

    private val TAG: String? = "SECONDS"
    private var _binding: FragmentOverviewBinding? = null

    private val binding get() = _binding!!
    var isLoading = false

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

//    private var adapterOver = OverviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        binding.rv.itemAnimator = null
        val layoutManager = GridLayoutManager(context, 3)
//        binding.rv.layoutManager = layoutManager
//        binding.rv.adapter = adapterOver
//        binding.rv.addOnScrollListener(scrollListener)



//        viewModel.liveData().observe(viewLifecycleOwner, {
//            renderData(it)
//        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

//    private fun renderData(state: ResponseResult) {
//        when (state) {
//            is ResponseResult.SuccessList -> {
//                Log.d(TAG, "renderData:")
//                isLoading = false
//                adapterOver.addToList(state.serverResponseData)
//            }
//        }
//    }



//        var scrollListener = object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
////                val totalItemCount = recyclerView.layoutManager?.itemCount
////                val lastVisibleItem = (recyclerView.layoutManager as GridLayoutManager).findLastVisibleItemPosition()
////                if (totalItemCount == lastVisibleItem + 1)  {
////                    Log.d("MyTAG", "Load new list")
////                        viewModel.getList()
//                }
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                val layoutManager = recyclerView.layoutManager as GridLayoutManager
//                if (!isLoading) {
//                    if (layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == adapterOver.listOfPicture.size - 1) {
//                        isLoading = true
//                        viewModel.getList()
//                    }
//                }
//            }
//        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}