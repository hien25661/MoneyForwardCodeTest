package app.hiennv.moneyfowardtest.repository

import app.hiennv.moneyfowardtest.model.Articles
import io.reactivex.Single
import retrofit2.http.GET

interface Endpoint{
    @GET("example-feed/feed.json")
    fun getArticlesList():Single<Articles>
}