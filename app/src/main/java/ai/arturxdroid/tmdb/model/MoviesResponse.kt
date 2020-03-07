package ai.arturxdroid.tmdb.model

import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.android.parcel.Parcelize

data class MoviesResponse(
    val page: Int?,
    val total_results: Long?,
    val pages: Int?,
    val results: List<MovieData>
)

@Parcelize
public open class MovieData(
    var id: Long = 0,
    var vote_average: String? = "",
    var title: String? = "",
    var overview: String? = "",
    var poster_path: String? = "",
    var isFavorite: Boolean? = false
) : Parcelable, RealmObject()