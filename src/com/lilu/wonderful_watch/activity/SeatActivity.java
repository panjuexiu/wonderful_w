package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class SeatActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 还没有写动态
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.seat);
	}
}
