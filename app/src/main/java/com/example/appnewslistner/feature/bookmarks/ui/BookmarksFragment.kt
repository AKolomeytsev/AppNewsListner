package com.example.appnewslistner.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.appnewslistner.R
import com.example.appnewslistner.feature.bookmarks.ui.data.local.mapper.toEntity
import com.example.appnewslistner.feature.news_screen.ArticlesAdapter
import com.example.appnewslistner.feature.news_screen.MainScreenViewModel
import com.example.appnewslistner.feature.news_screen.UiEvent
import com.example.appnewslistner.feature.news_screen.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment:Fragment(R.layout.fragment_bookmarks) {
    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val recyclerView:RecyclerView by lazy { requireActivity().findViewById(R.id.listViewBookmarksArticles) }
    private val adapter:BookmarksAdapter by lazy { BookmarksAdapter{index -> viewModel.processUiEvent(UiEvent.OnArticleCliked(index))} }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner,::render)
        recyclerView.adapter = adapter
    }

    private fun render(viewState:ViewState){
        adapter.setDate(viewState.articles)

    }
}