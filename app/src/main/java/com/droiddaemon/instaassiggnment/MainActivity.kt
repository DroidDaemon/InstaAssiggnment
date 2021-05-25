package com.droiddaemon.instaassiggnment

import android.os.Bundle
import android.text.Layout
import android.widget.LinearLayout
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droiddaemon.instaassiggnment.databinding.ActivityMainBinding
import com.droiddaemon.instaassiggnment.ui.dashboard.stories.StoriesAdapter
import com.droiddaemon.instaassiggnment.ui.dashboard.stories.StoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdapter = StoriesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storyListRecycler.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = storiesAdapter
        }


        setupNav()


        storiesViewModel.getTags()


    }

    private fun setupNav(){
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_hot, R.id.navigation_top))
////        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()

        storiesViewModel.tags.observe(this) {
            storiesAdapter.submitList(it)
        }
    }
}