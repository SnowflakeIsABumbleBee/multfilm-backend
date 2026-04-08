package de.htw_berlin.multfilm;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tmdb")
public class TmdbController {

    private final MovieService movieService;
    private final TmdbApiClient tmdb;

    public TmdbController(MovieService movieService, TmdbApiClient tmdb) {
        this.movieService = movieService;
        this.tmdb = tmdb;
    }

    @GetMapping("/movie/{id}")
    public MovieDto getMovie(@PathVariable int id) {
        return getMovieData(id);
    }

    @GetMapping("/movie/{id}/title")
    public String getMovieTitle(@PathVariable int id) {
        return getMovieData(id).title();
    }

    @GetMapping("/movie/{id}/overview")
    public String getMovieOverview(@PathVariable int id) {
        return getMovieData(id).overview();
    }

    @GetMapping("/movie/{id}/poster-url")
    public String getMoviePosterUrl(@PathVariable int id) {
        return getMovieData(id).posterUrl();
    }

    @GetMapping("/movie/{id}/release-date")
    public String getMovieReleaseDate(@PathVariable int id) {
        return getMovieData(id).releaseDate();
    }

    @GetMapping("/movie/{id}/genres")
    public List<String> getMovieGenres(@PathVariable int id) {
        return getMovieData(id).genres();
    }

    @GetMapping("/movie/{id}/cast")
    public List<String> getMovieCast(@PathVariable int id) {
        return getMovieData(id).cast();
    }

    @GetMapping("/movie/{id}/director")
    public String getMovieDirector(@PathVariable int id) {
        return getMovieData(id).director();
    }

    @GetMapping("/trending")
    public List<Map<String, Object>> trending() {
        return tmdb.getTrendingMovies();
    }

    private MovieDto getMovieData(int id) {
        return movieService.getMovie(id);
    }
}

