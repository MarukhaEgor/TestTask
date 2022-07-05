package com.example.testtask.ui.gifsListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testtask.databinding.FragmentGifListBinding
import com.example.testtask.ext.dpToPx
import com.example.testtask.ui.gifsListFragment.adapter.GifsAdapter
import com.example.testtask.utils.Constants
import com.example.testtask.utils.GifListItemDecoration
import org.koin.android.ext.android.inject


class GifListFragment : Fragment() {

    private val viewModel: GifListFragmentViewModel by inject()
    private lateinit var binding: FragmentGifListBinding

    private val gifsAdapter by lazy {
        GifsAdapter(showDetail = { showDetail(it) })
    }

    private fun showDetail(url: String) {
        viewModel.goToDetail(url)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGifListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
        observe()
        viewModel.getGifUri()
    }

    private fun observe() {
        viewModel.gifDetail.observe(viewLifecycleOwner) {
            it.let { gifsAdapter.submitList(it) }
        }
        viewModel.navigationEventDetail.observe(viewLifecycleOwner, ::navigate)
    }

    private fun initRv() {
        binding.rvGifList.apply {
            adapter = gifsAdapter
            layoutManager = GridLayoutManager(
                requireContext(),
                Constants.RV_COLUMNS_NUMBER
            )
            addItemDecoration(
                GifListItemDecoration(
                    requireContext().dpToPx(Constants.RV_ITEM_MARGIN)
                )
            )
        }
    }

    private fun navigate(direction: NavDirections) = findNavController().navigate(direction)

}