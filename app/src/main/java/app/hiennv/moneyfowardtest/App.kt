package app.hiennv.moneyfowardtest

import android.app.Application
import app.hiennv.moneyfowardtest.di.component.AppComponent
import app.hiennv.moneyfowardtest.di.component.DaggerAppComponent
import app.hiennv.moneyfowardtest.di.module.AppModule

class App : Application() {
    val applicationComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        applicationComponent.inject(this)
    }
}