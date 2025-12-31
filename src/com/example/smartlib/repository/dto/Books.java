package com.example.smartlib.repository.dto;

public class Books {
    private String id;
    private String name;
    private String genre;
    private byte volume;
    private Integer publishedYear;
    private String author;
    private byte noOfCopy;
    private byte availableCount;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public byte getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(byte availableCount) {
        this.availableCount = availableCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getNoOfCopy() {
        return noOfCopy;
    }

    public void setNoOfCopy(byte noOfCopy) {
        this.noOfCopy = noOfCopy;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public byte getVolume() {
        return volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }
}
