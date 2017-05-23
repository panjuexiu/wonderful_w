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
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.activity_main);
		//一定要在方法中添加--登录按钮
		login_btn=(Button) findViewById(R.id.log_btn_login);
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
				//加载目标activity
				startActivity(intent);
				//销毁当前activity--不能返回
				finish();
			}
		});
		//注册按钮
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
