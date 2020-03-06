package ai.arturxdroid.tmdb.ui

import ai.arturxdroid.tmdb.TmDBApplication
import ai.arturxdroid.tmdb.model.MovieData
import ai.arturxdroid.tmdb.network.BaseRepository
import ai.arturxdroid.tmdb.network.TmDBRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel : ViewModel() {

    val movies = MutableLiveData<List<MovieData>>()

    @Inject
    lateinit var repository: TmDBRepository

    init {
        TmDBApplication.appComponent.inject(this)
    }

    fun fetchMovies() {
        viewModelScope.launch {
            movies.value = repository.getMovies()?.results
        }
    }
}