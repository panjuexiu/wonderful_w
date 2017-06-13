package com.lilu.wonderful_watch.activity;


import java.util.List;

import org.litepal.crud.DataSupport;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.model.User;
import com.lilu.wonderful_watch.util.StringUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button login_btn = null;
	private Button signup_btn;
	private Button forget_btn;
	private EditText userPhoneOrEmail, userPassword;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.activity_main);
		
		userPhoneOrEmail = (EditText) findViewById(R.id.log_et_name);
		userPassword = (EditText) findViewById(R.id.log_et_pass);
		//一定要在方法中添加--登录按钮
		login_btn=(Button) findViewById(R.id.log_btn_login);
		login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (StringUtil.isEmpty(userPhoneOrEmail.getText().toString())) {
					Toast.makeText(v.getContext(), "手机号或邮箱不为空", Toast.LENGTH_SHORT).show();
					return;
				} else if (StringUtil.isEmpty(userPassword.getText().toString())) {
					Toast.makeText(v.getContext(), "密码不为空", Toast.LENGTH_SHORT).show();
					return;
				}
				
				//如果是邮箱
				if (userPhoneOrEmail.getText().toString().contains("@")) {
					List<User> users = DataSupport.select("email", "phonenumber", "name")
					           .where("email == '"+ userPhoneOrEmail.getText().toString() + "' and password == '" + userPassword.getText().toString() + "'")
					           .find(User.class);
					if (users.size() != 0) {
						Toast.makeText(v.getContext(), "登录成功", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(v.getContext(), "邮箱或密码错误", Toast.LENGTH_SHORT).show();
						return;
					}
					
				} else {
					List<User> users = DataSupport.select("email", "phonenumber", "name")
					           .where("phonenumber == '"+ userPhoneOrEmail.getText().toString() + "' and password == '" + userPassword.getText().toString() + "'")
					           .find(User.class);
					if (users.size() != 0) {
						Toast.makeText(v.getContext(), "登录成功", Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(v.getContext(), "手机号或密码错误", Toast.LENGTH_SHORT).show();
						return;
					}
				}
				
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
		//忘记密码按钮
		forget_btn=(Button) findViewById(R.id.log_btn_forget);
		forget_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(),PassActivity.class);
				startActivity(intent);
				//设置可以返回
				//finish();
			}
		});
	}
}
