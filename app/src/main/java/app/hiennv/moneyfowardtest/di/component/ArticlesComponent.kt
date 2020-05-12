package app.hiennv.moneyfowardtest.di.component

import app.hiennv.moneyfowardtest.ui.article_list.ArticlesActivity
import app.hiennv.moneyfowardtest.di.module.ArticlesModule
import app.hiennv.moneyfowardtest.di.scope.PerActivity
import app.hiennv.moneyfowardtest.ui.article_detail.ArticleDetailActivity
import dagger.Component


@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ArticlesModule::class])
interface ArticlesComponent {
    fun inject(articlesActivity: ArticlesActivity)
    fun injectDetail(articlesActivity: ArticleDetailActivity)

}