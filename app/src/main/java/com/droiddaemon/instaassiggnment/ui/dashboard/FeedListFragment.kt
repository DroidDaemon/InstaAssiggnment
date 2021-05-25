package com.droiddaemon.instaassiggnment.ui.dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.ActivityNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.droiddaemon.instaassiggnment.R
import com.droiddaemon.instaassiggnment.databinding.FeedListFragmentBinding

class FeedListFragment : Fragment() {

    companion object {
        fun newInstance() =
            FeedListFragment()
    }

    private val viewModel: FeedListViewModel by activityViewModels()
    private val feedAdapter = FeedAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let {
            viewModel.updateFeed(it)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FeedListFragmentBinding.inflate(inflater, container, false)
        binding.recyclerViewFeed.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFeed.adapter = feedAdapter
        viewModel.feed.observe({ lifecycle }) {
            feedAdapter.submitList(it)
        }

        return binding.root
    }


}