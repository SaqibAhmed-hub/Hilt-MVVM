package com.example.hiltmvvm.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltmvvm.data.network.dto.Result
import com.example.hiltmvvm.data.repository.MainRepository
import com.example.hiltmvvm.utils.NetworkResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) :ViewModel(){

    private val _data = MutableLiveData<List<Result>>()
    val data: LiveData<List<Result>> =_data


    fun getData(){
        viewModelScope.launch {
            mainRepository.getCharacterData().collectLatest{
                _data.value = it
            }
        }


    }


}