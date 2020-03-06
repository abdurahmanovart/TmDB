package ai.arturxdroid.tmdb.di

import ai.arturxdroid.tmdb.ui.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])

@Singleton
interface AppComponent {

    fun inject(viewModel: MainViewModel)

}