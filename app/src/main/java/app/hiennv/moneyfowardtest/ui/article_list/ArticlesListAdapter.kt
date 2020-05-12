package app.hiennv.moneyfowardtest.ui.article_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.hiennv.moneyfowardtest.R
import app.hiennv.moneyfowardtest.model.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_article.view.*

class ArticlesListAdapter(private val context: Context, private val articles: List<Article>, private val articlesView: ArticlesView) :
        RecyclerView.Adapter<ArticlesListAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val tvTitle = view.tvTitle
        val tvDescription = view.tvDecription
        val imvThumbnail = view.imvThumbnail
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_article, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvTitle.text = articles[position].title
        holder?.tvDescription.text = articles[position].description
        Glide.with(context).load(articles[position].image).into(holder?.imvThumbnail)

        holder?.view.setOnClickListener(View.OnClickListener {
            articlesView.openDetailActivity(articles[position])
        })

    }

    override fun getItemCount() = articles.size
}