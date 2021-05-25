package com.droiddaemon.instaassiggnment.ui.dashboard.stories

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.droiddaemon.instaassiggnment.databinding.StoriesListItemsBinding
import com.droiddaemon.libapi.responseModels.Tag

class StoriesAdapter : ListAdapter<Tag, StoriesAdapter.StoriesViewHolder>(StoriesDiffCallback()) {

    class StoriesViewHolder(val binding : StoriesListItemsBinding) : RecyclerView.ViewHolder(binding.root)


    private class StoriesDiffCallback : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = (oldItem == newItem)
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = (oldItem === newItem)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflator = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = StoriesListItemsBinding.inflate(inflator,parent,false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {

        val tag = getItem(position)
        holder.binding.storyTitle.text = tag.displayName
        holder.binding.storyImage.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
        holder.binding.root.apply {

            setOnClickListener{
                context.startActivity(
                    Intent(context,StoryActivity::class.java).apply {
                        putExtra("tag", tag.name)
                    }

                )
            }
        }

    }
}