package ai.arturxdroid.tmdb.network

import ai.arturxdroid.tmdb.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmDBApi {

    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("sort_by") sort: String,
        @Query("language") lang: String
    ):Response<MoviesResponse>


}