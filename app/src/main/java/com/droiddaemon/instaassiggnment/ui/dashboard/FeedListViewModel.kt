package com.droiddaemon.instaassiggnment.ui.dashboard

import android.media.Image
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddaemon.instaassiggnment.data.Repository
import com.droiddaemon.libapi.responseModels.GelleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class FeedListViewModel : ViewModel() {
    private val repo = Repository()


    private val _feed = MutableLiveData<List<com.droiddaemon.libapi.responseModels.Image>>()

    val feed: LiveData<List<com.droiddaemon.libapi.responseModels.Image>> = _feed

    fun updateFeed(feedType: String) {
        viewModelScope.launch(Dispatchers.IO)
        {
            when (feedType) {
                "hot" -> _feed.postValue(repo.fetchHotFeed())
                "top" -> _feed.postValue(repo.fetchTopFeed())

                else -> Log.e("Something went wrong", "Error while loading feeds")

            }
        }

    }

}