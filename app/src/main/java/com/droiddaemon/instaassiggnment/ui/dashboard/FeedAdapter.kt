package com.droiddaemon.instaassiggnment.ui.dashboard

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.droiddaemon.instaassiggnment.R
import com.droiddaemon.instaassiggnment.databinding.GelleryListItemBinding
import com.droiddaemon.libapi.responseModels.Image

class FeedAdapter() :
    ListAdapter<Image, FeedAdapter.FeedViewHolder>(FeedDiffCallback()) {


    class FeedViewHolder(val binding : GelleryListItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }

    class FeedDiffCallback : DiffUtil.ItemCallback<Image>(){

        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() === newItem.toString()
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val inflator = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = GelleryListItemBinding.inflate(inflator,parent,false)

        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        val image  = getItem(position)
        holder.binding.textViewCaption.text = image.title
        holder.binding.imageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.place_holder_image)
            error(R.drawable.place_holder_image)
        }

    }

}