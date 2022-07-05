package com.example.testtask.ui.gifsListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.testtask.data.model.SingleGifModel
import com.example.testtask.data.Repository
import com.example.testtask.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class GifListFragmentViewModel(private val repository: Repository): ViewModel() {

    private val _navigationEventDetail = SingleLiveEvent<NavDirections>()
    val navigationEventDetail: LiveData<NavDirections> = _navigationEventDetail

    private val _gifDetail = MutableLiveData<MutableList<SingleGifModel>>()
    val gifDetail: LiveData<MutableList<SingleGifModel>> = _gifDetail

    fun getGifUri(){
        viewModelScope.launch {
            val tempData = repository.getGif()
            _gifDetail.value = tempData.data as MutableList<SingleGifModel>
        }
    }

    fun goToDetail(url: String) {
        _navigationEventDetail.value =
            GifListFragmentDirections.actionGifListFragmentToDetailFragment(url)
    }
}