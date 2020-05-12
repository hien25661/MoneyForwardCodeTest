package app.hiennv.moneyfowardtest.ui.article_detail

import android.view.MenuItem
import app.hiennv.moneyfowardtest.App
import app.hiennv.moneyfowardtest.BaseActivity
import app.hiennv.moneyfowardtest.R
import app.hiennv.moneyfowardtest.di.component.DaggerArticlesComponent
import app.hiennv.moneyfowardtest.model.Article
import app.hiennv.moneyfowardtest.presenter.ArticlesDetailPresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_article_detail.*

class ArticleDetailActivity : BaseActivity<ArticlesDetailPresenter>(), ArticlesDetailView {
    override fun getLayout(): Int = R.layout.activity_article_detail

    override fun initInjector() {
        DaggerArticlesComponent.builder()
                .appComponent((application as App).applicationComponent)
                .build()
                .injectDetail(this)
    }

    override fun initialiseView() {
    }

    override fun showDetailArticle(article: Article) {
        var actionBar = supportActionBar
        actionBar?.title = article.title
        actionBar?.setDisplayHomeAsUpEnabled(true)
        tvDetail.text = article.detail
        Glide.with(this).load(article.image).into(imvBigThumb)
    }

    override fun getArticleDetail() {
        val article = intent.getParcelableExtra<Article>("Article")
        showDetailArticle(article)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}