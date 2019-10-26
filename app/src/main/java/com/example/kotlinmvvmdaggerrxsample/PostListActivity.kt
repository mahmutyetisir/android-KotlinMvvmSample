package com.example.kotlinmvvmdaggerrxsample

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmdaggerrxsample.databinding.ActivityPostListBinding
import com.example.kotlinmvvmdaggerrxsample.di.ViewModelFactory
import com.example.kotlinmvvmdaggerrxsample.ui.post.PostListViewModel
import com.google.android.material.snackbar.Snackbar

class PostListActivity : BaseActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.rcyclerViewPostList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)
        viewModel.errorMessage.observe(
            this,
            Observer { errorMessage -> if (errorMessage != null) showError(errorMessage) else hideError() })
        binding.postListViewModel = viewModel
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
