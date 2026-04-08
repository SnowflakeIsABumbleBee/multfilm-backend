package de.htw_berlin.multfilm.tmdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TmdbService {

    private final RestClient restClient;

    public TmdbService(
            @Value("${tmdb.api.base-url}") String baseUrl,
            @Value("${tmdb.api.token}") String token) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer " + token)
                .defaultHeader("accept", "application/json")
                .build();
    }

    public Object getPopularMovies(int page) {
        return restClient.get()
                .uri("/movie/popular?language=de-DE&page={page}", page)
                .retrieve()
                .body(Object.class);
    }

    public Object searchMovies(String query, int page) {
        return restClient.get()
                .uri("/search/movie?query={query}&language=de-DE&page={page}", query, page)
                .retrieve()
                .body(Object.class);
    }

    public Object getMovieDetails(int movieId) {
        return restClient.get()
                .uri("/movie/{movieId}?language=de-DE", movieId)
                .retrieve()
                .body(Object.class);
    }
}
