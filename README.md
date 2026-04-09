# MultFilm

## Projektbeschreibung

MultFilm ist eine Filmplattform mit API-Anbindung, die Nutzerinnen und Nutzern dabei helfen soll, Filme zu entdecken, zu organisieren und sich darüber mit anderen auszutauschen.

Im Zentrum des Projekts steht die Idee, persönliche Filmübersichten mit sozialen Funktionen zu verbinden. Nutzer sollen festhalten können, welche Filme sie bereits gesehen haben und welche sie noch ansehen möchten. Darüber hinaus sollen Profile anderer Personen aufrufbar sein, sodass sichtbar wird, welche Titel sich auf deren Watchlist befinden oder bereits gesehen wurden.

Dadurch entsteht eine Plattform, die nicht nur der individuellen Filmorganisation dient, sondern auch gemeinsames Entdecken, Anschauen und Besprechen von Filmen unterstützt.

## Ziel des Projekts

Ziel ist die Entwicklung einer Website, die Filmdaten über eine externe API bezieht und diese in einer übersichtlichen und interaktiven Form darstellt. Zusätzlich soll eine soziale Komponente geschaffen werden, durch die Nutzer Einblicke in die Filmaktivitäten anderer erhalten können.

Die Plattform soll dabei sowohl praktisch als auch kommunikativ funktionieren: Sie hilft bei der persönlichen Verwaltung von Filmen und schafft zugleich Anknüpfungspunkte für gemeinsame Filmabende oder Gespräche über bereits gesehene Titel.

## Geplante Funktionen

- Anzeige von Filmen über eine externe API
- Erstellung und Verwaltung einer persönlichen Watchlist
- Markierung bereits gesehener Filme
- Nutzerprofile mit einsehbaren Filmübersichten
- Einsicht in die Watchlists und gesehenen Filme anderer Nutzer
- Förderung gemeinsamer Filmplanung und des Austauschs über Filme

## Erweiterungsmöglichkeiten

Sofern es der zeitliche Rahmen zulässt, soll das Projekt um weitere API-Anbindungen ergänzt werden. Denkbar wäre beispielsweise die Integration externer Anbieter wie Amazon, um Filme direkt aufzurufen oder gegebenenfalls zu erwerben.

## Projektstruktur

Dieses Repository bildet die Grundlage für die technische Umsetzung des Projekts. Die genaue Struktur wird im Verlauf der Entwicklung weiter ausgebaut.

## Projektstatus

Milestone 1  
Aktuell befindet sich das Projekt in der konzeptionellen und strukturellen Aufbauphase.

## Erste fachliche Struktur

Für das Projekt denken wir aktuell über eine Datenstruktur mit folgenden zentralen Elementen nach:

- User
  repräsentiert eine Nutzerin oder einen Nutzer
- Movie
  repräsentiert einen Film mit grundlegenden Informationen
- MovieEntry
  verknüpft einen User mit einem Film und speichert den Status, zum Beispiel TO_WATCH oder SEEN

## Beispielhafte Endpunkte

- `/movie/{id}`  
  gibt alle verfügbaren Filmdetails als Objekt zurück

- `/movie/{id}/title`  
  gibt den Filmtitel zurück

- `/movie/{id}/overview`  
  gibt die Beschreibung des Films zurück

- `/movie/{id}/poster-url`  
  gibt die Poster URL zurück

- `/movie/{id}/release-date`  
  gibt das Veröffentlichungsdatum zurück

- `/movie/{id}/genres`  
  gibt die Genres als Liste zurück

- `/movie/{id}/cast`  
  gibt die Besetzung als Liste zurück

- `/movie/{id}/director`  
  gibt die Regie zurück

- `/trending`  
  gibt aktuelle Trending Filme zurück

## Start der Anwendung

Die Anwendung kann mit Gradle gestartet werden:

bash
- `./gradlew.bat bootRun`

## Technologien

Für das Projekt werden aktuell folgende Technologien verwendet:

- Java
- Spring Boot
- Gradle
- REST Schnittstellen
- TMDB API

## Projektstruktur

Die zentrale Struktur des Backends umfasst aktuell:

- `TmdbController`  
  stellt die REST Endpunkte bereit

- `MovieService`  
  verarbeitet und strukturiert die Filmdaten

- `TmdbApiClient`  
  übernimmt die Kommunikation mit der externen TMDB API

- `MovieDto`  
  definiert die Datenstruktur für Filminformationen

## Perspektivische Erweiterungen

Im weiteren Verlauf soll das Projekt um zusätzliche Funktionen erweitert werden. Dazu gehören insbesondere:

- Nutzerprofile
- Watchlist Funktion
- Markierung bereits gesehener Filme
- soziale Einsicht in Filmprofile anderer Nutzer
- gegebenenfalls weitere API Anbindungen an externe Anbieter

## Team

- Viktoria Schauder
- Olesia Kryvosheieva

