package com.lilu.wonderful_watch.activity;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.bumptech.glide.Glide;
import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.model.Actor;
import com.lilu.wonderful_watch.model.Movie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {
	private Button buyBtn;
	private ImageView moviePost, actor1, actor2, actor3, actor4, actor5, backImage;
	private TextView movieName, englishMovieName, MovieType,
					 movieCountryAndDuration, moviePublishTime, movieDescription,
					 movieRank, movieWeek, movieTotal, movieTitle;
	
	private TextView actorName1, actorName2, actorName3, actorName4, actorName5;
	private TextView roleName1, roleName2, roleName3, roleName4, roleName5;    
	
	private int movieId;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.detail);
		
		movieId = getIntent().getIntExtra("movieId", 0);
		initData();
		buyBtn=(Button) findViewById(R.id.detail_btn_buy);
		buyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 跳转到cinema界面
				//Toast.makeText(v.getContext(), "点击进入场次选择", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getApplicationContext(),CinemaActivity.class);
				startActivity(intent);
			}
		});
		backImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				DetailActivity.this.finish();
			}
		});
	}
	
	public void initData() {
		moviePost = (ImageView) findViewById(R.id.detail_iv_post);
		backImage = (ImageView) findViewById(R.id.home_ib_back);
		movieName = (TextView) findViewById(R.id.detail_tv_film);
		englishMovieName = (TextView) findViewById(R.id.detail_tv_eng);
		MovieType = (TextView) findViewById(R.id.detail_tv_class);
		movieCountryAndDuration = (TextView) findViewById(R.id.detail_tv_country);
		moviePublishTime = (TextView) findViewById(R.id.detail_tv_date);
		movieDescription = (TextView) findViewById(R.id.detail_tv_fold);
		movieRank = (TextView) findViewById(R.id.detail_tv_num_1);
		movieWeek = (TextView) findViewById(R.id.detail_tv_num_2);
		movieTotal = (TextView) findViewById(R.id.detail_tv_num_3);
		movieTitle = (TextView) findViewById(R.id.home_tv_film);
		actor1 = (ImageView) findViewById(R.id.detail_iv_act1);
		actor2 = (ImageView) findViewById(R.id.detail_iv_act2);
		actor3 = (ImageView) findViewById(R.id.detail_iv_act3);
		actor4 = (ImageView) findViewById(R.id.detail_iv_act4);
		actor5 = (ImageView) findViewById(R.id.detail_iv_act5);
		actorName1 = (TextView) findViewById(R.id.detail_tv_actor1);
		actorName2 = (TextView) findViewById(R.id.detail_tv_actor2);
		actorName3 = (TextView) findViewById(R.id.detail_tv_actor3);
		actorName4 = (TextView) findViewById(R.id.detail_tv_actor4);
		actorName5 = (TextView) findViewById(R.id.detail_tv_actor5);
		roleName1 = (TextView) findViewById(R.id.detail_tv_role1);
		roleName2 = (TextView) findViewById(R.id.detail_tv_role2);
		roleName3 = (TextView) findViewById(R.id.detail_tv_role3);
		roleName4 = (TextView) findViewById(R.id.detail_tv_role4);
		roleName5 = (TextView) findViewById(R.id.detail_tv_role5);
		
		//查询数据
		//从数据库查询数据
		Movie movie = DataSupport.where("id == " + movieId).findFirst(Movie.class);

		Glide
        .with(this)
        .load(movie.getPost())
        .override(200, 280)
		.centerCrop()
        .into(moviePost);
		movieTitle.setText(movie.getName());
		movieName.setText(movie.getName());
		englishMovieName.setText(movie.getEnglishName());
		MovieType.setText(movie.getType());
		moviePublishTime.setText(movie.getPublishTime());
		movieCountryAndDuration.setText(movie.getCountry() + " | " + movie.getDuration());
		movieDescription.setText(movie.getDescription());
		movieRank.setText(movie.getRank());
		movieWeek.setText(movie.getWeekly());
		movieTotal.setText(movie.getTotal());
		List<Actor> actors = DataSupport.where("movie_id == " + movieId).find(Actor.class);
		
		Glide
	        .with(this)
	        .load(actors.get(0).getActorPic())
	        .override(110, 154)
			.centerCrop()
	        .into(actor1);
		Glide
	        .with(this)
	        .load(actors.get(1).getActorPic())
	        .override(110, 154)
			.centerCrop()
	        .into(actor2);
		Glide
	        .with(this)
	        .load(actors.get(2).getActorPic())
	        .override(110, 154)
			.centerCrop()
	        .into(actor3);
		Glide
	        .with(this)
	        .load(actors.get(3).getActorPic())
	        .override(110, 154)
			.centerCrop()
	        .into(actor4);
		Glide
	        .with(this)
	        .load(actors.get(4).getActorPic())
	        .override(110, 154)
			.centerCrop()
        .into(actor5);
		actorName1.setText(actors.get(0).getName());
		actorName2.setText(actors.get(1).getName());
		actorName3.setText(actors.get(2).getName());
		actorName4.setText(actors.get(3).getName());
		actorName5.setText(actors.get(4).getName());
		
		roleName1.setText(actors.get(0).getRoleName());
		roleName2.setText(actors.get(1).getRoleName());
		roleName3.setText(actors.get(2).getRoleName());
		roleName4.setText(actors.get(3).getRoleName());
		roleName5.setText(actors.get(4).getRoleName());
	}
	
}
