package de.htw_berlin.multfilm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TmdbApiClient {

    @Value("${tmdb.api.key:}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String baseUrl;

    @Value("${tmdb.api.read-access-token:}")
    private String readAccessToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getMovieDetails(int tmdbId) {
        return get("/movie/" + tmdbId, Map.of("language", "de-DE"));
    }

    public Map<String, Object> getMovieCredits(int tmdbId) {
        return get("/movie/" + tmdbId + "/credits", Map.of("language", "de-DE"));
    }

    public List<Map<String, Object>> getTrendingMovies() {
        Map<String, Object> response = get("/trending/movie/week", Map.of("language", "de-DE"));
        return (List<Map<String, Object>>) response.get("results");
    }

    private Map<String, Object> get(String path, Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl + path);
        queryParams.forEach(builder::queryParam);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        if (hasText(readAccessToken)) {
            headers.setBearerAuth(readAccessToken);
        } else if (hasText(apiKey)) {
            builder.queryParam("api_key", apiKey);
        } else {
            throw new IllegalStateException(
                    "TMDB authentication is missing. Set TMDB_READ_ACCESS_TOKEN or TMDB_API_KEY.");
        }

        ResponseEntity<Map> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Map.class
        );

        return response.getBody();
    }

    private boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}

