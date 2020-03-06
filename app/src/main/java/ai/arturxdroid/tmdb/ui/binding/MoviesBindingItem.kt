package ai.arturxdroid.tmdb.ui.binding

import ai.arturxdroid.tmdb.R
import ai.arturxdroid.tmdb.databinding.MoviePosterBinding
import ai.arturxdroid.tmdb.model.MovieData
import com.xwray.groupie.databinding.BindableItem

class MoviesBindingItem(val movie: MovieData) : BindableItem<MoviePosterBinding>() {
    override fun getLayout(): Int = R.layout.movies_recycler_item

    override fun bind(viewBinding: MoviePosterBinding, position: Int) {
        viewBinding.movie = movie
    }
}