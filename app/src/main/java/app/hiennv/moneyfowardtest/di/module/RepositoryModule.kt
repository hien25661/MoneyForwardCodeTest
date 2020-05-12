package app.hiennv.moneyfowardtest.di.module

import app.hiennv.moneyfowardtest.repository.ArticlesRepository
import app.hiennv.moneyfowardtest.repository.Endpoint
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideArticleRepository(endpoint: Endpoint): ArticlesRepository = ArticlesRepository(endpoint)
}