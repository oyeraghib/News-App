package com.example.newzu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newzu.databinding.FragmentNewsBinding

class NewsFragment:Fragment() {

    private lateinit var _binding: FragmentNewsBinding
    private val newsViewModel : NewsViewModel by viewModels()

    private var newsRecyclerAdapter = NewsRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsViewModel.fetchTopHeadlines()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        _binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvNews.adapter = newsRecyclerAdapter

        newsViewModel.news.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "Total news items received ${it.size}", Toast.LENGTH_SHORT).show()
            newsRecyclerAdapter.submitList(it)
        })
        return _binding.root

    }
}