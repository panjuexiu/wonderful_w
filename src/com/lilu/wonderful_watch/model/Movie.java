package com.lilu.wonderful_watch.model;

import java.util.List;

import org.litepal.crud.DataSupport;

public class Movie extends DataSupport {

    private int id;
    private String name;
    private String englishName;
    private String post;
    private String directors;
    private String actorsDescription;
    private String type;
    private String publishTime;
    private String country;
    private String duration;
    private String description;
    //boxOffice
    private String rank;
    private String weekly;
    private String total;
    
    private List<Actor> actors;
    private List<Cinema> cinemas;
    private List<Comment> comments;
    
    
    public Movie() {
	}
	public Movie(String name, String post, String directors, String type,
			String publishTime, String country, String duration, String rank,
			String weekly, String total) {
		this.name = name;
		this.post = post;
		this.directors = directors;
		this.type = type;
		this.publishTime = publishTime;
		this.country = country;
		this.duration = duration;
		this.rank = rank;
		this.weekly = weekly;
		this.total = total;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
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
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getDirectors() {
		return directors;
	}
	public void setDirectors(String directors) {
		this.directors = directors;
	}
	public String getActorsDescription() {
		return actorsDescription;
	}
	public void setActorsDescription(String actorsDescription) {
		this.actorsDescription = actorsDescription;
	}
	public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public List<Actor> getActors() {
        return actors;
    }
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    public List<Cinema> getCinemas() {
        return cinemas;
    }
    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getWeekly() {
		return weekly;
	}
	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
