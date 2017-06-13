package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MineActivity extends Activity {
	private ImageButton back_btn;
	
	private TextView movieNameTextView,movieNameTitleTextView, cinemaNameTextView, ticketTextView, timeTextView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.mine);
		
		movieNameTextView = (TextView) findViewById(R.id.mine_tv_film);
		movieNameTitleTextView = (TextView) findViewById(R.id.mine_tv_film_title);
		cinemaNameTextView = (TextView) findViewById(R.id.mine_tv_cinema);
		ticketTextView = (TextView) findViewById(R.id.mine_tv_ticket);
		timeTextView = (TextView) findViewById(R.id.mine_tv_time);
		cinemaNameTextView.setText(MySeatActivity.cinemaName);
		movieNameTextView.setText(MySeatActivity.movieName);
		movieNameTitleTextView.setText(MySeatActivity.movieName);
		ticketTextView.setText(MySeatActivity.hs.size() + "张");
		timeTextView.setText(MySeatActivity.movieTime);
		back_btn=(ImageButton) findViewById(R.id.mine_ib_back);
		back_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
