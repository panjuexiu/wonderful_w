package com.lilu.wonderful_watch.fragment;

import java.util.List;

import org.litepal.crud.DataSupport;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.MainActivity;
import com.lilu.wonderful_watch.model.User;
import com.lilu.wonderful_watch.util.StringUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailMainTabFragment extends Fragment {
	private Button mailSignBtn;
	private Button mailLoginBtn;
	
	private EditText userEmail;
	private EditText userPassword;
	private EditText userConfirmPassword;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mail, container, false);
		
		userEmail = (EditText) view.findViewById(R.id.mail_et_name);
		userPassword = (EditText) view.findViewById(R.id.mail_et_pss);
		userConfirmPassword = (EditText) view.findViewById(R.id.mail_et_again);
		
		//mail注册
		mailSignBtn=(Button) view.findViewById(R.id.mail_btn_register);
		mailSignBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (StringUtil.isEmpty(userEmail.getText().toString())) {
					Toast.makeText(v.getContext(), "邮箱不为空", Toast.LENGTH_SHORT).show();
					return;
				} else if (!(userEmail.getText().toString().contains("@"))) {
					Toast.makeText(v.getContext(), "邮箱格式不正确", Toast.LENGTH_SHORT).show();
					return;
				} else if (StringUtil.isEmpty(userPassword.getText().toString())) {
					Toast.makeText(v.getContext(), "密码不为空", Toast.LENGTH_SHORT).show();
					return;
				} else if (!(userPassword.getText().toString().length() >= 6 && userPassword.getText().toString().length() <= 6)) {
					Toast.makeText(v.getContext(), "密码需要在6-20位之间", Toast.LENGTH_SHORT).show();
					return;
				} else if (StringUtil.isEmpty(userConfirmPassword.getText().toString())) {
					Toast.makeText(v.getContext(), "确认密码不为空", Toast.LENGTH_SHORT).show();
					return;
				} else if (!(userPassword.getText().toString().equals(userConfirmPassword.getText().toString()))) {
					Toast.makeText(v.getContext(), "密码和确认密码需要一致", Toast.LENGTH_SHORT).show();
					return;
				}
				//判断邮箱是否存在
				List<User> users = DataSupport.select("email").where("email == '" + userEmail.getText().toString() + "'").find(User.class);
				if (users.size() != 0) {
					Toast.makeText(v.getContext(), "该邮箱已存在", Toast.LENGTH_SHORT).show();
					return;
				}
				
				User user = new User("", userEmail.getText().toString(), userPassword.getText().toString(), "");
				user.save();
				Toast.makeText(v.getContext(), "注册成功", Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		//mail登录
		mailLoginBtn=(Button) view.findViewById(R.id.mail_btn_login);
		mailLoginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		return view;
	}
}
