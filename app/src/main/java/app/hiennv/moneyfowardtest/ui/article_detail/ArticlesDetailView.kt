package app.hiennv.moneyfowardtest.ui.article_detail

import app.hiennv.moneyfowardtest.model.Article

interface ArticlesDetailView {
    fun initialiseView()
    fun showDetailArticle(article: Article)
    fun getArticleDetail()
}