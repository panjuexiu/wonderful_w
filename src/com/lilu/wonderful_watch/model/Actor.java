package com.lilu.wonderful_watch.model;

import org.litepal.crud.DataSupport;

public class Actor extends DataSupport {

    private int id;
    private String name;
    private String roleName;
    private String actorPic;
    
    private Movie movie;

    public Actor() {
	}

	public Actor(String name, String roleName, String actorPic) {
		super();
		this.name = name;
		this.roleName = roleName;
		this.actorPic = actorPic;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getActorPic() {
        return actorPic;
    }

    public void setActorPic(String actorPic) {
        this.actorPic = actorPic;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
