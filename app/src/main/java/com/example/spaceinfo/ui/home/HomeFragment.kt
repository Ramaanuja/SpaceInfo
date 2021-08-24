package com.example.spaceinfo.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.spaceinfo.R
import com.example.spaceinfo.databinding.FragmentHomeBinding
import com.example.spaceinfo.ui.calendar.BottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
//    private var adapterOver = HomeAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true);
        viewModel.getStartPicture()
//        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        binding.homeRecyclerView.layoutManager = layoutManager
//        binding.homeRecyclerView.adapter = adapterOver

        viewModel.pictureLiveData.observe(viewLifecycleOwner){picture->
            binding.titleTextView.text = picture.title
            binding.descriptionTextView.text = picture.explanation
            Glide.with(requireContext())
                .load(picture.url)
                .into(binding.mainImageView)
        }

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

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel.getData().observe(viewLifecycleOwner, Observer<ResponseResult> { renderData(it) })
//    }
//
//
//
//    private fun renderData(state: ResponseResult) {
//        when (state) {
//            is ResponseResult.Success -> {
//                val serverResponseData = state.serverResponseData
//                val url = serverResponseData.url
//                binding.mainImageView.load(url) {
//                    lifecycle(this@HomeFragment)
////                    error(R.drawable.ic_no_photo_vector)
////                    placeholder(R.drawable.ic_no_photo_vector)
//                }
//                binding.titleTextView.text = serverResponseData.title
//                binding.descriptionTextView.text = serverResponseData.explanation
//
//
//            }
//            is ResponseResult.SuccessList -> {
//                adapterOver.seeAlsoList = state.serverResponseData
//            }
//            is ResponseResult.Loading -> {
//                //Отобразите загрузку
//                //showLoading()
//            }
//            is ResponseResult.Error -> {
//
//            }
//        }
//    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}