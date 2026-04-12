package de.htw_berlin.multfilm;


import java.util.List;

public record User(
        String name,
        int age,
        String favoriteGenres,
        List <MovieDto> watchedMovies,
        List<MovieDto> favoriteMovies,
        List<MovieDto> toWatchMovies
) {}
