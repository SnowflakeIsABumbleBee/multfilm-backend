package de.htw_berlin.multfilm;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//der Controller TmdbController stellt Endpunkte fuer Filmdaten aus der TMDB-API bereit
//enthaelt Endpunkte fuer Filmdetails wie Titel, Beschreibung, Poster, Erscheinungsdatum, Genres, Cast und Regisseur
@RestController
@RequestMapping("/api/tmdb")
public class TmdbController {

    private final MovieService movieService;
    private final TmdbApiClient tmdb;

    public TmdbController(MovieService movieService, TmdbApiClient tmdb) {
        this.movieService = movieService;
        this.tmdb = tmdb;
    }

    //liefert alle verfuegbaren Filmdaten zu einer TMDB-Film-ID
    @GetMapping("/movie/{id}")
    public MovieDto getMovie(@PathVariable int id) {
        return getMovieData(id);
    }

    //liefert den Titel eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/title")
    public String getMovieTitle(@PathVariable int id) {
        return getMovieData(id).title();
    }

    //liefert die Kurzbeschreibung eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/overview")
    public String getMovieOverview(@PathVariable int id) {
        return getMovieData(id).overview();
    }

    //liefert die Poster-URL eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/poster-url")
    public String getMoviePosterUrl(@PathVariable int id) {
        return getMovieData(id).posterUrl();
    }

    //liefert das Erscheinungsdatum eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/release-date")
    public String getMovieReleaseDate(@PathVariable int id) {
        return getMovieData(id).releaseDate();
    }

    //liefert die Genres eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/genres")
    public List<String> getMovieGenres(@PathVariable int id) {
        return getMovieData(id).genres();
    }

    //liefert die wichtigsten Schauspieler eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/cast")
    public List<String> getMovieCast(@PathVariable int id) {
        return getMovieData(id).cast();
    }

    //liefert den Regisseur eines Films anhand der TMDB-Film-ID
    @GetMapping("/movie/{id}/director")
    public String getMovieDirector(@PathVariable int id) {
        return getMovieData(id).director();
    }

    //liefert eine Liste aktuell trendender Filme aus der TMDB-API
    @GetMapping("/trending")
    public List<Map<String, Object>> trending() {
        return tmdb.getTrendingMovies();
    }

    //holt die Filmdaten ueber den MovieService
    private MovieDto getMovieData(int id) {
        return movieService.getMovie(id);
    }
}

