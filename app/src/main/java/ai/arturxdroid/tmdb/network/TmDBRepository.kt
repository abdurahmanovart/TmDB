package ai.arturxdroid.tmdb.network

import ai.arturxdroid.tmdb.di.NetworkModule
import ai.arturxdroid.tmdb.model.MoviesResponse

class TmDBRepository(private val api: TmDBApi) : BaseRepository() {

    val KEY = "f41ede1b788f1576fbe02e8868751271"
    val lang = "en-US"

    suspend fun getMovies(): MoviesResponse? {
        return safeApiCall(
            call = { api.getPopularMovies(KEY, "popularity.desc", lang) },
            errorMessage = "Error getting popular movies"
        )
    }
}