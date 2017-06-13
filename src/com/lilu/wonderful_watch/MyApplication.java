package com.lilu.wonderful_watch;

import java.util.ArrayList;
import java.util.List;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import com.lilu.wonderful_watch.model.Actor;
import com.lilu.wonderful_watch.model.Cinema;
import com.lilu.wonderful_watch.model.Comment;
import com.lilu.wonderful_watch.model.Movie;
import com.lilu.wonderful_watch.model.User;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(mContext);
        initDatabase();
    }
    
    public static Context getContext() {
        return mContext;
    }
    
    public void initDatabase() {
    	SQLiteDatabase db = LitePal.getDatabase();
    	//��ʼ����Ӱ����
    	Movie tempMovie= DataSupport.findFirst(Movie.class);
    	//������ݿ���û�����ݾ�������������
    	if (tempMovie == null) {
//    		Movie movie = new Movie("����Ů��", "http://www.baidu.com", "����", "�й�", "2016-02-04", "�й�", "120����", "100��", "500��", "1��");
//    		Actor actor = new  Actor("����", "����", "http://baidu.com");
//    		List<Actor> actors = new ArrayList<Actor>();
//    		actors.add(actor);
//    		List<Cinema> cinemas = new ArrayList<Cinema>();
//    		Cinema cinema = new Cinema("CGV��ӰԺ", "֣���п�ѧ������·");
//    		cinemas.add(cinema);
//    		List<Comment> comments = new ArrayList<Comment>();
//    		Comment comment = new Comment("����", "�����Ӱ����Ŷ~~~~", "2017-05-04");
//    		comments.add(comment);
//    		DataSupport.saveAll(actors);
//    		DataSupport.saveAll(comments);
//    		DataSupport.saveAll(cinemas);
//    		movie.setActors(actors);
//    		movie.setCinemas(cinemas);
//    		movie.setComments(comments);
//    		movie.save();
		}
    	
    }
}
