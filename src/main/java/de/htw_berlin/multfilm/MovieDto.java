package de.htw_berlin.multfilm;

import java.util.List;

public record MovieDto(
        String title,
        String overview,
        String posterUrl,
        String releaseDate,
        List<String> genres,
        List<String> cast,
        String director
) {}

