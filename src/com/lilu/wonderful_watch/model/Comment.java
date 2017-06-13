package com.lilu.wonderful_watch.model;

import org.litepal.crud.DataSupport;

public class Comment extends DataSupport {

    private int id;
    private String userName;
    private String content;
    private String publishTime;
    
    private Movie movie;

    public Comment() {
	}

	public Comment(String userName, String content, String publishTime) {
		this.userName = userName;
		this.content = content;
		this.publishTime = publishTime;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
