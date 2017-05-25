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
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MySimpleAdapter extends SimpleAdapter {

	public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, 
			int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		Button button = (Button) view.findViewById(R.id.home_btn_buy);
		if (button != null) {
			//¸ø¹ºÆ±buttonÉèÖÃ¼àÌýÆ÷
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(v.getContext(),CinemaActivity.class);
					HomeActivity.homeActivity.startActivity(intent);
				}
			});
		}
		return view;
	}
}
