package com.example.newzu.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.api.models.News
import com.example.newzu.databinding.ListItemNewsBinding

class NewsRecyclerAdapter :
    ListAdapter<News, NewsRecyclerAdapter.NewsViewHolder>(NewsDiffCallback()) {

    class NewsViewHolder(val binding: ListItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    class NewsDiffCallback: DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }

         @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return newItem === oldItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemNewsBinding.inflate(inflater, parent, false)

        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)

        holder.binding.tvTitle.text = news.title
        if(news.author != null) {
            holder.binding.tvAuthorName.text = "-by "+news.author
        }
        holder.binding.tvDescription.text = news.description
        holder.binding.ivImage.load(news.urlToImage)

    }

    data class NewsEpoxyModel(
        val news: News

    )
}