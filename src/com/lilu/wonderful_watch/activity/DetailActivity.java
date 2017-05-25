package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class DetailActivity extends Activity {
	private Button buyBtn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.detail);
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
	}
}
