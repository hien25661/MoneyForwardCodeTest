package app.hiennv.moneyfowardtest.domain
import app.hiennv.moneyfowardtest.model.Article
import app.hiennv.moneyfowardtest.repository.ArticlesRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class GetArticlesListUseCase
@Inject
constructor(private val articlesRepository: ArticlesRepository,
                        subscribeScheduler: Scheduler,
                        postExecutionScheduler: Scheduler)
                        : UseCase<List<Article>, Unit>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(params: Unit?): Single<List<Article>> = articlesRepository.articles()
            .map {
                it.map { Article(it.title, it.pubDate, it.creator, it.categories, it.description, it.image, it.detail) }
            }
}