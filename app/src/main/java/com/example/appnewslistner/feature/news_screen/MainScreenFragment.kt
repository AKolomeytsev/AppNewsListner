package com.example.appnewslistner.feature.news_screen

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.appnewslistner.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment:Fragment(R.layout.fragment_main_screen) {
    private val viewModel:MainScreenViewModel by viewModel()
    private val recyclerView:RecyclerView by lazy { requireActivity().findViewById(R.id.listView) }
    private val adapter:ArticlesAdapter by lazy { ArticlesAdapter{index -> viewModel.processUiEvent(UiEvent.OnArticleCliked(index))} }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner,::render)
        recyclerView.adapter = adapter
    }
    private fun render(viewState:ViewState){
        adapter.setDate(viewState.articles)

    }
}