package com.example.spaceinfo.ui.overview

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spaceinfo.AppState
import com.example.spaceinfo.ui.overview.overviewRecycler.OverviewAdapter
import com.example.spaceinfo.databinding.FragmentOverviewBinding
import kotlinx.coroutines.flow.collectLatest


class OverviewFragment : Fragment() {

    private val TAG: String? = "SECONDS"
    private var _binding: FragmentOverviewBinding? = null

    private val binding get() = _binding!!

//    private val viewModel: OverviewViewModel by lazy {
//        ViewModelProvider(this).get(OverviewViewModel::class.java)
//    }

    private var adapterOver = OverviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        binding.rv.itemAnimator = null
        //val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val layoutManager = GridLayoutManager(context, 3)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapterOver

        initViewModel()
//        viewModel.liveData().observe(viewLifecycleOwner, {
//            renderData(it)
//        })



        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.SuccessList -> {
                Log.d(TAG, "renderData:")
                //adapterOver.pictures = state.serverResponseData
            }
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(OverviewViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListPicture().collectLatest {
                adapterOver.submitData(it)
            }
        }
    }


    fun createAdapter() {
//        val flexboxLayoutManager = FlexboxLayoutManager(context).apply {
//            flexWrap = FlexWrap.WRAP
//            flexDirection = FlexDirection.ROW
//            alignItems = AlignItems.STRETCH
//        }

//        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
//        binding.rv.layoutManager = layoutManager
//        binding.rv.adapter = adapterOver


//        binding.rv.apply {
//            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            binding.rv.layoutManager = layoutManager
//            adapter = adapterOver
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}