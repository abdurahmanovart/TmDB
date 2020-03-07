package ai.arturxdroid.tmdb.ui

import ai.arturxdroid.tmdb.R
import ai.arturxdroid.tmdb.ui.binding.MoviesBindingItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GroupAdapter<GroupieViewHolder>()

        adapter.setOnItemClickListener { item, view ->
            val intent = Intent(this.application, MoviesDetailActivity::class.java)
            val movie = (item as MoviesBindingItem).movie
            intent.putExtra(MoviesDetailActivity.EXTRA_MOVIE, (movie))
            startActivity(intent)
        }

        viewModel.movies.observe(this, Observer { list ->
            adapter.clear()
            adapter.addAll(list.map { MoviesBindingItem(it) })
        })

        recycler_view.adapter = adapter
        viewModel.fetchMovies()
    }
}
