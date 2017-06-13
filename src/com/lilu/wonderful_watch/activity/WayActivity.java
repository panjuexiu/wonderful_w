package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class WayActivity extends Activity {
	
	private RelativeLayout weixinLayot;
	private RelativeLayout zhifubaoLayout;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.way);
		initData();
		setListener();
		
	}
	
	private void setListener() {
		weixinLayot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), MineActivity.class);
				startActivity(intent);
				Toast.makeText(v.getContext(), "支付成功", Toast.LENGTH_LONG).show();
			}
		});
		zhifubaoLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), MineActivity.class);
				startActivity(intent);
				Toast.makeText(v.getContext(), "支付成功", Toast.LENGTH_LONG).show();
			}
		});
		
	}

	public void initData() {
		weixinLayot = (RelativeLayout) findViewById(R.id.way_rl_wei);
		zhifubaoLayout = (RelativeLayout) findViewById(R.id.way_rl_zhi);
	}
}
