package com.example.kotlinmvvmdaggerrxsample.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmdaggerrxsample.R
import com.example.kotlinmvvmdaggerrxsample.databinding.ItemPostBinding
import com.example.kotlinmvvmdaggerrxsample.model.Post

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private lateinit var postList: List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_post, parent, false
        )

        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) postList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    fun updatePostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val postViewModel = PostViewModel()

        fun bind(post: Post) {
            postViewModel.bind(post)
            binding.postViewModel = postViewModel
        }
    }
}