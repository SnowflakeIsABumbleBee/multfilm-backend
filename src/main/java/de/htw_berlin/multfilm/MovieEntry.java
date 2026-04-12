package de.htw_berlin.multfilm;

public class MovieEntry {
    String title;
    boolean seen;
    boolean toWatch;
    boolean favorite;




    public MovieEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSeen() {
        return seen;
    }

    public boolean isToWatch() {
        return toWatch;
    }

    public  boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setToWatch(boolean toWatch) {
        this.toWatch = toWatch;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
