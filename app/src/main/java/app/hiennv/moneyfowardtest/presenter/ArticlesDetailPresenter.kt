package app.hiennv.moneyfowardtest.presenter

import app.hiennv.moneyfowardtest.ui.article_detail.ArticlesDetailView
import javax.inject.Inject

class ArticlesDetailPresenter
@Inject
constructor() : BasePresenter<ArticlesDetailView>() {

    override fun initialise() {
        getView()?.initialiseView()
        getView()?.getArticleDetail()
    }

    override fun disposeSubscriptions() {
    }
}