package fr.zunkit.movie

import fr.zunkit.movie.data.datasources.MovieRemoteDataSource
import fr.zunkit.movie.data.repositories.MovieRepositoryImpl
import fr.zunkit.movie.datasources.remote.MovieApi
import fr.zunkit.movie.datasources.remote.MovieRemoteDataSourceImpl
import fr.zunkit.movie.domain.interactors.MovieInteractor
import fr.zunkit.movie.domain.repositories.MovieRepository
import fr.zunkit.movie.presentation.home.presenters.HomePresenter
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            presenterModule,
            interactorsModule,
            repositoriesModule,
            dataSourcesModule,
            networksModule,
            cachesModule
        )
    )
}

val presenterModule: Module = module {
    factory { (view: HomePresenter.HomeViewListener )-> HomePresenter(view = view, interactor = get()) }
}

val interactorsModule: Module = module {
    factory { MovieInteractor(movieRepository = get()) }
}

val repositoriesModule: Module = module {
    single { MovieRepositoryImpl(moveRemoteDataSource = get()) as MovieRepository }
}

val dataSourcesModule: Module = module {
    single { MovieRemoteDataSourceImpl(movieApi = get()) as MovieRemoteDataSource }
}

val networksModule: Module = module {
    single { movieApi }
}

val cachesModule: Module = module {
}

private const val BASE_URL = "https://api.themoviedb.org/"

private val retrofit: Retrofit = createNetworkClient(BASE_URL, BuildConfig.DEBUG)

private val movieApi: MovieApi = retrofit.create(MovieApi::class.java)
