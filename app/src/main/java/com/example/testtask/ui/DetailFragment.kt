package com.example.testtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testtask.databinding.FragmentDetailBinding
import com.example.testtask.databinding.FragmentGifListBinding
import com.example.testtask.ext.loadGif
import com.example.testtask.utils.Constants

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val gifUrl: String? = bundle?.getString(Constants.ARGS_KEY)
        if (bundle != null) {
            setUpData(gifUrl)
        }
    }

    private fun setUpData(gifUrl: String?) {
        binding.ivGifDetail.loadGif(gifUrl)
    }


}