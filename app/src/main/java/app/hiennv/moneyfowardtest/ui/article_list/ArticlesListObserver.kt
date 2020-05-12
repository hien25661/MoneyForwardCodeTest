package app.hiennv.moneyfowardtest.ui.article_list

import app.hiennv.moneyfowardtest.model.Article
import app.hiennv.moneyfowardtest.presenter.ArticlesPresenter
import io.reactivex.observers.DisposableSingleObserver

class ArticlesListObserver(private val presenter: ArticlesPresenter): DisposableSingleObserver<List<Article>>() {
    override fun onSuccess(articlesList: List<Article>) {
        presenter.showArticleList(articlesList)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}