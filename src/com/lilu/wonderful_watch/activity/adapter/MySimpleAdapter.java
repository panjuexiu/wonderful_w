package com.lilu.wonderful_watch.activity.adapter;

import java.util.List;
import java.util.Map;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.CinemaActivity;
import com.lilu.wonderful_watch.activity.HomeActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MySimpleAdapter extends SimpleAdapter implements OnClickListener {

	public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, 
			int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
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
					HomeActivity.homeActivity.startActivity(intent);
				}
			});
		}
		if(button1 != null && button2 != null && button3 != null 
				&& button4 != null && button5 != null && button6 != null){
			button1.setOnClickListener(this);
			button2.setOnClickListener(this);
			button3.setOnClickListener(this);
			button4.setOnClickListener(this);
			button5.setOnClickListener(this);
			button6.setOnClickListener(this);
		}
		return view;
	}
	@Override
	public void onClick(View v) {
		// 上下文不能写this---
		Toast.makeText(v.getContext(), "跳转到选座界面", Toast.LENGTH_LONG).show();
	}
}
