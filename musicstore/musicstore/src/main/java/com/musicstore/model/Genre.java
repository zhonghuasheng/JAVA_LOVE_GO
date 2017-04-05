package com.musicstore.model;

public class Genre {
    private int GenreId;
    private String name;
    private String description;

    public int getGenreId() {
        return GenreId;
    }
    public void setGenreId(int genreId) {
        GenreId = genreId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
