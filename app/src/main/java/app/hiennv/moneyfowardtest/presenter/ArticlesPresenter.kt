package app.hiennv.moneyfowardtest.presenter

import app.hiennv.moneyfowardtest.domain.GetArticlesListUseCase
import app.hiennv.moneyfowardtest.model.Article
import app.hiennv.moneyfowardtest.ui.article_list.ArticlesListObserver
import app.hiennv.moneyfowardtest.ui.article_list.ArticlesView
import javax.inject.Inject

class ArticlesPresenter
@Inject
constructor(private val getArticlesListUseCase: GetArticlesListUseCase) : BasePresenter<ArticlesView>() {

    override fun initialise() {
        getView()?.initialiseView()
        getArticlesListUseCase.execute(ArticlesListObserver(this))
    }

    override fun disposeSubscriptions() {
        getArticlesListUseCase.dispose()
    }

    fun showArticleList(articlesList: List<Article>) {
        getView()?.showArticleList(articlesList)
    }

    fun openDetailActivity(article: Article){
        getView()?.openDetailActivity(article)
    }
}