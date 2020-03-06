package ai.arturxdroid.tmdb.model

data class MoviesResponse(
    val page: Int?,
    val total_results: Long?,
    val pages: Int?,
    val results: List<MovieData>
)

data class MovieData(
    val id: Long,
    val vote_average: String,
    val title: String,
    val description: String,
    val poster_path: String,
    val isFavorite: Boolean
)