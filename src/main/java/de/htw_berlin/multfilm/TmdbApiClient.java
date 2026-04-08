package de.htw_berlin.multfilm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbApiClient {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getMovieDetails(int tmdbId) {
        String url = baseUrl + "/movie/" + tmdbId +
                "?api_key=" + apiKey +
                "&language=de-DE";

        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getMovieCredits(int tmdbId) {
        String url = baseUrl + "/movie/" + tmdbId + "/credits" +
                "?api_key=" + apiKey +
                "&language=de-DE";

        return restTemplate.getForObject(url, Map.class);
    }

    public List<Map<String, Object>> getTrendingMovies() {
        String url = baseUrl + "/trending/movie/week" +
                "?api_key=" + apiKey +
                "&language=de-DE";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<Map<String, Object>>) response.get("results");
    }
}

