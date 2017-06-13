package com.lilu.wonderful_watch.activity.adapter;

import java.util.List;
import java.util.Map;

import com.bumptech.glide.Glide;
import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.CinemaActivity;
import com.lilu.wonderful_watch.activity.HomeActivity;
import com.lilu.wonderful_watch.activity.MySeatActivity;
import com.lilu.wonderful_watch.activity.PayActivity;
import com.lilu.wonderful_watch.activity.SeatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MySimpleAdapter extends SimpleAdapter implements OnClickListener {

	private List<Map<String,Object>> dataList;
	
	public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, 
			int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
		dataList = (List<Map<String, Object>>) data;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		ImageView filmImage = (ImageView) view.findViewById(R.id.home_iv_film);
		if (filmImage != null) {
			Glide
            .with(view.getContext())
            .load(dataList.get(position).get("post"))
            .override(150, 195)
			.centerCrop()
            //.fitCenter() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
            .into(filmImage);
		}
		Button button = (Button) view.findViewById(R.id.home_btn_buy);
		LinearLayout button1=(LinearLayout) view.findViewById(R.id.cinema_ll_time1);
		LinearLayout button2=(LinearLayout) view.findViewById(R.id.cinema_ll_time2);
		LinearLayout button3=(LinearLayout) view.findViewById(R.id.cinema_ll_time3);
		LinearLayout button4=(LinearLayout) view.findViewById(R.id.cinema_ll_time4);
		LinearLayout button5=(LinearLayout) view.findViewById(R.id.cinema_ll_time5);
		LinearLayout button6=(LinearLayout) view.findViewById(R.id.cinema_ll_time6);
		if (button != null) {
			//给购票button设置监听器
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),CinemaActivity.class);
					intent.putExtra("movieName", (String)dataList.get(position).get("film"));
					intent.putExtra("movieId", String.valueOf(dataList.get(position).get("id")));
					HomeActivity.homeActivity.startActivity(intent);
				}
			});
		}
		if(button1 != null && button2 != null && button3 != null 
				&& button4 != null && button5 != null && button6 != null){
			button1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 10:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language1")));
					
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
			button2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 12:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language2")));
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
			button3.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 14:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language3")));
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
			button4.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 16:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language4")));
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
			button5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 18:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language5")));
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
			button6.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),MySeatActivity.class);
					intent.putExtra("time", "05-05 20:00");
					intent.putExtra("movieName", CinemaActivity.movieName);
					intent.putExtra("cinemaName", String.valueOf(dataList.get(position).get("cinema")));
					intent.putExtra("movieLanguage", String.valueOf(dataList.get(position).get("language6")));
					CinemaActivity.cinemaActivity.startActivity(intent);
					
				}
			});
		}
		return view;
	}
	@Override
	public void onClick(View v) {
		// 上下文不能写this---设置跳转为什么不对
		//Toast.makeText(v.getContext(), "跳转到选座界面", Toast.LENGTH_LONG).show();
		String time = "";
		switch (v.getId()) {
			case R.id.cinema_ll_time1:
				time = "10:00";
				break;
			case R.id.cinema_ll_time2:
				time = "12:00";
				break;
			case R.id.cinema_ll_time3:
				time = "14:00";
				break;
			case R.id.cinema_ll_time4:
				time = "16:00";
				break;
			case R.id.cinema_ll_time5:
				time = "18:00";
				break;
			case R.id.cinema_ll_time6:
				time = "20:00";
				break;
			default:
				break;
		}
		Intent intent = new Intent(v.getContext(),MySeatActivity.class);
		intent.putExtra("time", time);
		intent.putExtra("movieName", CinemaActivity.movieName);
		CinemaActivity.cinemaActivity.startActivity(intent);
		//直接跳转到支付界面---其实应该跳转到选座界面
		
	}
}
