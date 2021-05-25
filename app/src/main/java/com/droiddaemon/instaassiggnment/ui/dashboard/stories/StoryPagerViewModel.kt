package com.droiddaemon.instaassiggnment.ui.dashboard.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddaemon.instaassiggnment.data.Repository
import com.droiddaemon.libapi.responseModels.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class StoryPagerViewModel : ViewModel() {

    private val repo = Repository()
    private val _images = MutableLiveData<List<Image>>()

    val images : LiveData<List<Image>> = _images

    fun getTagGallery(tagName :String)  = viewModelScope.launch ( Dispatchers.IO ){

        _images.postValue(repo.getTagGallery(tagName))
    }


}