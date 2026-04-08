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
        return movieService.getMovie(id);
    }

    @GetMapping("/trending")
    public List<Map<String, Object>> trending() {
        return tmdb.getTrendingMovies();
    }
}

