package de.htw_berlin.multfilm.tmdb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tmdb")
public class TmdbController {

    private final TmdbService tmdbService;

    public TmdbController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/movies/popular")
    public Object getPopularMovies(@RequestParam(defaultValue = "1") int page) {
        return tmdbService.getPopularMovies(page);
    }

    @GetMapping("/movies/search")
    public Object searchMovies(@RequestParam String query,
                               @RequestParam(defaultValue = "1") int page) {
        return tmdbService.searchMovies(query, page);
    }

    @GetMapping("/movies/{id}")
    public Object getMovieDetails(@PathVariable int id) {
        return tmdbService.getMovieDetails(id);
    }
}
