package com.example.myfirstviewpager2.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class Page2ViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from a cool section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun getIndex(): Int {
        return _index.value!!
    }
}