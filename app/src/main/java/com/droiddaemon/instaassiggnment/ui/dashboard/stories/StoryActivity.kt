package com.droiddaemon.instaassiggnment.ui.dashboard.stories

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.viewpager2.widget.ViewPager2
import com.droiddaemon.instaassiggnment.R
import com.droiddaemon.instaassiggnment.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private val storyViewModel by viewModels<StoryPagerViewModel>()
    private lateinit var binding: ActivityStoryBinding
    private val storyPagerAdapter = StoryPagerAdapter()
    private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")
        tagName?.let { storyViewModel.getTagGallery(it) }

        binding.storyViewPager.adapter = storyPagerAdapter

        binding.storyViewPager.registerOnPageChangeCallback(pageChangeCallback)



    }

    private val nextPageRunnable = Runnable {
        binding.storyViewPager.currentItem++
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.progressBar.scaleX = 0F
            binding.progressBar.animate().cancel()
            binding.progressBar.animate().scaleX(1F).setDuration(5000).setStartDelay(10).start()

            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable,5000)
        }
    }


    override fun onResume() {
        super.onResume()

        storyViewModel.images.observe(this) {
            storyPagerAdapter.submitList(it)
        }
    }
}