package ai.arturxdroid.tmdb.ui

import ai.arturxdroid.tmdb.R
import ai.arturxdroid.tmdb.databinding.ActivityMoviesDetailBinding
import ai.arturxdroid.tmdb.model.MovieData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_movies_detail.*

class MoviesDetailActivity : AppCompatActivity() {

    var movie: MovieData? = null

    companion object {
        public const val EXTRA_MOVIE = "extra_movie"
    }

    private val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMoviesDetailBinding? =
            DataBindingUtil.setContentView(this, R.layout.activity_movies_detail)
        movie = intent?.getParcelableExtra<MovieData>("extra_movie")
        binding?.movie = movie
        binding?.executePendingBindings()
        add_to_favorites_button.setOnClickListener {
            if (movie?.isFavorite!!) {
                Toast.makeText(this, R.string.removed_from_favorites, Toast.LENGTH_LONG).show()
                movie?.isFavorite = false
                add_to_favorites_button.setImageResource(R.drawable.ic_add_24dp)
            } else {
                Toast.makeText(this, R.string.added_to_favorite, Toast.LENGTH_LONG).show()
                movie?.isFavorite = true
                add_to_favorites_button.setImageResource(R.drawable.ic_remove_black_24dp)
            }
            realm.executeTransaction {
                it.insertOrUpdate(movie)
            }
        }
    }
}