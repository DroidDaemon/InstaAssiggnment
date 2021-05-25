package com.droiddaemon.instaassiggnment.ui.dashboard.stories

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.droiddaemon.instaassiggnment.databinding.PagerListItemBinding
import com.droiddaemon.libapi.responseModels.Image

class StoryPagerAdapter():
ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallBack()) {

    class StoryPageViewHolder(val binding: PagerListItemBinding) : RecyclerView.ViewHolder(binding.root)

    class StoryDiffCallBack: DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image)= (oldItem === newItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflator = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PagerListItemBinding.inflate(inflator,parent,false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {

        val image = getItem(position)
      val imgUrl =   if(image?.isAlbum == true && image.imagesCount != 0){
          image.images!![0].link!!
      } else {
          image.link
      }
        imgUrl?.let {
            holder.binding.pagerImage.load(imgUrl)
        }

    }
}