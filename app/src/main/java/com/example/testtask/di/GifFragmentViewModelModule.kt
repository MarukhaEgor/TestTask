package com.example.testtask.di

import com.example.testtask.ui.gifsListFragment.GifListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gifListFragmentViewModel = module {
    viewModel { GifListFragmentViewModel(get()) }
}