package yovi.putra.moviecatalogue.ui.movie

import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import yovi.putra.moviecatalogue.data.entity.Movie


class MovieViewModelTest {
    private lateinit var movieVM: MovieViewModel
    private lateinit var movie: Movie
    @Before
    fun setUp() {
        movieVM = MovieViewModel()
        movie = Gson().fromJson(""+
                "  {\n" +
                "    \"id\": 290859,\n" +
                "    \"title\": \"Terminator: Dark Fate\",\n" +
                "    \"poster_path\": \"/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg\",\n" +
                "    \"original_language\": \"en\",\n" +
                "    \"original_title\": \"Terminator: Dark Fate\",\n" +
                "    \"vote_average\": 6.6,\n" +
                "    \"overview\": \"More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.\",\n" +
                "    \"release_date\": \"2019-11-01\"\n" +
                "  }", Movie::class.java)
    }

    @Test
    fun getMovie() {
        val data = movieVM.getMovie()
        assertNotNull(data)
        assertNotEquals(emptyList<Movie>(), data)
        assertEquals(14, data.size)
    }

    @Test
    fun getMovieById() {
        val data = movieVM.getMovieById(movie.id)
        assertNotNull(data)
        assertEquals(movie.id, data?.id)
        assertEquals(movie.poster_path, data?.poster_path)
        assertEquals(movie.original_language, data?.original_language)
        assertEquals(movie.original_title, data?.original_title)
        assertEquals(movie.overview, data?.overview)
        assertEquals(movie.release_date, data?.release_date)
        assertEquals(movie.title, data?.title)
        assertEquals(movie.vote_average, data?.vote_average)
    }
}