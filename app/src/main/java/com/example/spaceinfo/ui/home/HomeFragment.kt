package com.example.spaceinfo.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.example.spaceinfo.AppState
import com.example.spaceinfo.ui.calendar.BottomSheetFragment
import com.example.spaceinfo.R
import com.example.spaceinfo.databinding.FragmentHomeBinding
import com.example.spaceinfo.ui.home.homeRecycler.HomeAdapter
import com.example.spaceinfo.ui.overview.OverviewViewModel
import com.example.spaceinfo.ui.overview.overviewRecycler.OverviewAdapter
import kotlinx.coroutines.flow.collectLatest


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    private var adapterOver = HomeAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true);


        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.homeRecyclerView.layoutManager = layoutManager
        binding.homeRecyclerView.adapter = adapterOver

        viewModel.getList()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.tool_bar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_calendar -> {
                val blankFragment = BottomSheetFragment()
                fragmentManager?.let { blankFragment.show(it, blankFragment.tag) }
            }
        }
        return false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer<AppState> { renderData(it) })
    }



    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Success -> {
                val serverResponseData = state.serverResponseData
                val url = serverResponseData.url
                binding.mainImageView.load(url) {
                    lifecycle(this@HomeFragment)
//                    error(R.drawable.ic_no_photo_vector)
//                    placeholder(R.drawable.ic_no_photo_vector)
                }
                binding.titleTextView.text = serverResponseData.title
                binding.descriptionTextView.text = serverResponseData.explanation


            }
            is AppState.SuccessList -> {
                adapterOver.seeAlsoList = state.serverResponseData
            }
            is AppState.Loading -> {
                //Отобразите загрузку
                //showLoading()
            }
            is AppState.Error -> {

            }
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}