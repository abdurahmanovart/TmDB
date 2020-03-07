package ai.arturxdroid.tmdb.ui

import ai.arturxdroid.tmdb.R
import ai.arturxdroid.tmdb.model.MovieData
import ai.arturxdroid.tmdb.ui.binding.MoviesBindingItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_favorites.*

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        val adapter = GroupAdapter<GroupieViewHolder>()

        val list =
            Realm.getDefaultInstance().where(MovieData::class.java).equalTo("isFavorite", true)
                .findAll()

        val itemsList = list.map { MoviesBindingItem(it) }
        adapter.addAll(itemsList)
        recycler_view.adapter = adapter

        adapter.setOnItemClickListener { item, view ->
            val intent = Intent(this, MoviesDetailActivity::class.java)
            val movie = (item as MoviesBindingItem).movie
            intent.putExtra(MoviesDetailActivity.EXTRA_MOVIE, (movie))
            startActivity(intent)
        }
    }
}