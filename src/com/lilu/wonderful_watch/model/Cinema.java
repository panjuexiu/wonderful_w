package com.lilu.wonderful_watch.model;

import java.util.List;

import org.litepal.crud.DataSupport;

public class Cinema extends DataSupport {

    private int id;
    private String name;
    private String location;
    
    private List<Movie> movies;
    
    public Cinema() {
	}
	public Cinema(String name, String location) {
		this.name = name;
		this.location = location;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
