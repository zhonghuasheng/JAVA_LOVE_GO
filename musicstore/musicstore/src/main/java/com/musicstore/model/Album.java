package com.musicstore.model;

public class Album {
    private long albumId;
    private long genreId;
    private long artistId;
    private String title;
    private double price;
    private String albumArtUrl;

    public long getAlbumId() {
        return albumId;
    }
    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }
    public long getGenreId() {
        return genreId;
    }
    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }
    public long getArtistId() {
        return artistId;
    }
    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getAlbumArtUrl() {
        return albumArtUrl;
    }
    public void setAlbumArtUrl(String albumArtUrl) {
        this.albumArtUrl = albumArtUrl;
    }
}
