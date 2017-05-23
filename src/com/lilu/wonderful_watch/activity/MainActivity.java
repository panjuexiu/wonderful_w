package com.lilu.wonderful_watch.activity;


import com.lilu.wonderful_watch.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button login_btn = null;
	private Button signup_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.activity_main);
		//һ��Ҫ�ڷ��������--��¼��ť
		login_btn=(Button) findViewById(R.id.log_btn_login);
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
				//����Ŀ��activity
				startActivity(intent);
				//���ٵ�ǰactivity--���ܷ���
				finish();
			}
		});
		//ע�ᰴť
		signup_btn=(Button) findViewById(R.id.log_btn_register);
		signup_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
}
