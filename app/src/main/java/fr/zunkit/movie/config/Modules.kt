package fr.zunkit.movie.config

import fr.zunkit.movie.BuildConfig
import fr.zunkit.movie.data.common.createNetworkClient
import fr.zunkit.movie.data.movie.datasources.MovieRemoteDataSource
import fr.zunkit.movie.data.movie.datasources.remote.MovieRemoteDataSourceImpl
import fr.zunkit.movie.data.movie.repositories.MovieRepositoryImpl
import fr.zunkit.movie.data.movie.services.MovieApi
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import fr.zunkit.movie.presentation.details.DetailsViewModel
import fr.zunkit.movie.presentation.home.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

fun injectFeature() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            vmModule,
            interactorsModule,
            repositoriesModule,
            dataSourcesModule,
            networksModule,
            cachesModule
        )
    )
}

val vmModule: Module = module {
    viewModel { HomeViewModel(interactor = get()) }
    viewModel { DetailsViewModel(interactor = get()) }
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

private val retrofit: Retrofit = createNetworkClient(
    BASE_URL,
    BuildConfig.DEBUG
)

private val movieApi: MovieApi = retrofit.create(MovieApi::class.java)
