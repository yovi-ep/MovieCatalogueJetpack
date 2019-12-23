package yovi.putra.moviecatalogue.ui.movie

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.app_bar.*
import yovi.putra.moviecatalogue.R
import yovi.putra.moviecatalogue.core.base.BaseToolbarActivity
import yovi.putra.moviecatalogue.core.common.Constant.IMAGE_URL
import yovi.putra.moviecatalogue.core.utils.load
import yovi.putra.moviecatalogue.data.entity.Movie

class DetailMovieActivity : BaseToolbarActivity() {
    companion object {
        private const val MOVIE_ID = "id"

        fun navigate(context: Context, id: Int) {
            val intent = Intent(context, DetailMovieActivity::class.java).apply {
                putExtra(MOVIE_ID, id)
            }
            context.startActivity(intent)
        }
    }

    private var movie: Movie? = null

    override fun setupLayoutId(): Int = R.layout.activity_detail_movie

    override fun setButtonBack(): Boolean = true

    override fun setupData() {
        val id = intent.getIntExtra(MOVIE_ID, -1)
        val vm = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movie = vm.getMovieById(id)
    }

    override fun setupUI() {
        setToolbar(R.id.toolbar)
        movie?.apply {
            toolbar_title.text = title
            tv_title.text = release_date
            tv_rating.text = vote_average
            tv_overview.text = overview
            img_poster.load(IMAGE_URL + poster_path)
        }
    }
}