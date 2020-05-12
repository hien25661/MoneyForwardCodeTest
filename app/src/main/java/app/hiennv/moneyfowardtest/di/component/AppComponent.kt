package app.hiennv.moneyfowardtest.di.component

import android.content.Context
import app.hiennv.moneyfowardtest.App
import app.hiennv.moneyfowardtest.di.module.AppModule
import app.hiennv.moneyfowardtest.di.module.IOModule
import app.hiennv.moneyfowardtest.di.module.RepositoryModule
import app.hiennv.moneyfowardtest.di.module.UseCaseModule
import app.hiennv.moneyfowardtest.domain.GetArticlesListUseCase
import app.hiennv.moneyfowardtest.repository.Endpoint
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, IOModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent {
    fun inject(app: App)
    fun getApplicationContext(): Context
    fun getEndpoint(): Endpoint

    fun getArticlesListUseCase(): GetArticlesListUseCase
}