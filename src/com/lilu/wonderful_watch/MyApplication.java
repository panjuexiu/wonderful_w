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
    	//初始化电影数据
    	Movie tempMovie= DataSupport.findFirst(Movie.class);
    	//如果数据库中没有数据就重新生成数据
    	if (tempMovie == null) {
//    		Movie movie = new Movie("神奇女侠", "http://www.baidu.com", "张三", "中国", "2016-02-04", "中国", "120分钟", "100万", "500万", "1亿");
//    		Actor actor = new  Actor("张三", "大叔", "http://baidu.com");
//    		List<Actor> actors = new ArrayList<Actor>();
//    		actors.add(actor);
//    		List<Cinema> cinemas = new ArrayList<Cinema>();
//    		Cinema cinema = new Cinema("CGV电影院", "郑州市科学大道瑞达路");
//    		cinemas.add(cinema);
//    		List<Comment> comments = new ArrayList<Comment>();
//    		Comment comment = new Comment("张三", "这个电影不错哦~~~~", "2017-05-04");
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
