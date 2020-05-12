package app.hiennv.moneyfowardtest.ui.article_list

import app.hiennv.moneyfowardtest.model.Article

interface ArticlesView {
    fun initialiseView()
    fun showArticleList(articles: List<Article>)
    fun openDetailActivity(article: Article)
}