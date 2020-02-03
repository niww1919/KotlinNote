package com.example.kotlinnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinnote.data.entity.NoteRepository

class MainViewModel() : ViewModel() {
    private val viewStateLiveData: MutableLiveData<MainViewState> = MutableLiveData()

    init {
        viewStateLiveData.value = MainViewState(NoteRepository.getNotes())

    }

    fun viewState() :LiveData<MainViewState> = viewStateLiveData

}