package com.example.appnewslistner.feature.news_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appnewslistner.R
import com.example.appnewslistner.feature.domain.ArticleModel

class ArticlesAdapter(val onItemCliced:(Int)->Unit):RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private var articlesData:List<ArticleModel> = emptyList()
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView =  view.findViewById(R.id.heaerArticle)
        val dateNews: TextView = view.findViewById(R.id.dateNews)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_article, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemView.setOnClickListener{
            onItemCliced.invoke(position)
        }
        viewHolder.textView.text = articlesData[position].title
        viewHolder.dateNews.text = articlesData[position].publishedAt
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articlesData.size

    fun setDate(articles:List<ArticleModel>){
        articlesData = articles
        notifyDataSetChanged()
    }

}