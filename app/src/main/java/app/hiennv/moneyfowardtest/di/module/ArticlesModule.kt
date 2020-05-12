package app.hiennv.moneyfowardtest.di.module

import app.hiennv.moneyfowardtest.di.scope.PerActivity
import app.hiennv.moneyfowardtest.domain.GetArticlesListUseCase
import app.hiennv.moneyfowardtest.presenter.ArticlesPresenter
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {
    @PerActivity
    @Provides
    internal fun provideArticlesPresenter(getArticlesListUseCase: GetArticlesListUseCase) = ArticlesPresenter(getArticlesListUseCase)
}