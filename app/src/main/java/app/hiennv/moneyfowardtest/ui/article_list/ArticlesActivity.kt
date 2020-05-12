package app.hiennv.moneyfowardtest.ui.article_list

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import app.hiennv.moneyfowardtest.App
import app.hiennv.moneyfowardtest.BaseActivity
import app.hiennv.moneyfowardtest.R
import app.hiennv.moneyfowardtest.di.component.DaggerArticlesComponent
import app.hiennv.moneyfowardtest.model.Article
import app.hiennv.moneyfowardtest.presenter.ArticlesPresenter
import app.hiennv.moneyfowardtest.ui.article_detail.ArticleDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class ArticlesActivity : BaseActivity<ArticlesPresenter>(), ArticlesView {
    override fun getLayout(): Int  = R.layout.activity_main

    override fun initInjector() {
        DaggerArticlesComponent.builder()
                .appComponent((application as App).applicationComponent)
                .build()
                .inject(this)
    }

    override fun initialiseView() {
        articles_list_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ArticlesActivity)
        }
    }

    override fun showArticleList(articles: List<Article>) {
        articles_list_recycler_view.adapter = ArticlesListAdapter(this, articles, this)
    }

    override fun openDetailActivity(article: Article) {
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra("Article",article)
        startActivity(intent)
    }

}
