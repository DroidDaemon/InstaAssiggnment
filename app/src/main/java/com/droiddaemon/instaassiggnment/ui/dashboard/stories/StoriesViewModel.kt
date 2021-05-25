package com.droiddaemon.instaassiggnment.ui.dashboard.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddaemon.instaassiggnment.data.Repository
import com.droiddaemon.libapi.responseModels.Gallery
import com.droiddaemon.libapi.responseModels.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {

    private val repo = Repository()
    private val _tags = MutableLiveData<List<Tag>>()

    val tags : LiveData<List<Tag>> = _tags

    fun getTags() = viewModelScope.launch (Dispatchers.IO ){
        _tags.postValue(repo.getTags())
    }



}