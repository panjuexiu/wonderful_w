package com.lilu.wonderful_watch.activity;

import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class PassActivity extends Activity {
	private Button update_btn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.pass);
		update_btn=(Button) findViewById(R.id.update_btn_login);
		update_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
