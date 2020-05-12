package app.hiennv.moneyfowardtest.repository

import app.hiennv.moneyfowardtest.model.Article
import io.reactivex.Single
import javax.inject.Inject

class ArticlesRepository
@Inject
constructor(private val endpoint: Endpoint){
    fun articles(): Single<List<Article>> = endpoint.getArticlesList()
            .map { it.articles }
}
