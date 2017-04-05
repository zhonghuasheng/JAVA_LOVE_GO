package com.musicstore.model;

public class Genre {
    private long genreId;
    private String name;
    private String description;

    public long getGenreId() {
        return genreId;
    }
    public void setGenreId(long genreId) {
        this.genreId = genreId;
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
