package de.htw_berlin.multfilm;


import java.util.List;

//die Klasse User
//enthält Name, Alter, eine Liste der Lieblingsgenres, eine Liste der bereits gesehenen Filmen, noch nicht gesehenen Filmen und eine Liste der Lieblingsfilme
//record ist eine spezielle Klasse in Java, die hauptsächlich Daten enthält
//und automatisch Getter, equals, hashCode und toString generiert
public record User(
        String name,
        int age,
        List<String> favoriteGenres,
        List <MovieDto> watchedMovies,
        List<MovieDto> favoriteMovies,
        List<MovieDto> toWatchMovies
) {}
