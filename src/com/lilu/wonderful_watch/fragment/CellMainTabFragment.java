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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CellMainTabFragment extends Fragment {
	private Button cellSignBtn;
	private Button cellLoginBtn;
	
	private EditText userPhone;
	private EditText userPassword;
	private EditText userConfirmPassword;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cell, container, false);
		userPhone = (EditText) view.findViewById(R.id.cell_et_name);
		userPassword = (EditText) view.findViewById(R.id.cell_et_pss);
		userConfirmPassword = (EditText) view.findViewById(R.id.cell_et_again);
		//cellע��
		cellSignBtn = (Button) view.findViewById(R.id.cell_btn_register);
		cellSignBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (StringUtil.isEmpty(userPhone.getText().toString())) {
					Toast.makeText(v.getContext(), "�ֻ��Ų�Ϊ��", Toast.LENGTH_SHORT).show();
					return;
				} else if (userPhone.getText().toString().length() != 11) {
					Toast.makeText(v.getContext(), "�ֻ��Ÿ�ʽ����ȷ", Toast.LENGTH_SHORT).show();
					return;
				} else if (StringUtil.isEmpty(userPassword.getText().toString())) {
					Toast.makeText(v.getContext(), "���벻Ϊ��", Toast.LENGTH_SHORT).show();
					return;
				} else if (!(userPassword.getText().toString().length() >= 6 && userPassword.getText().toString().length() <= 6)) {
					Toast.makeText(v.getContext(), "������Ҫ��6-20λ֮��", Toast.LENGTH_SHORT).show();
					return;
				} else if (StringUtil.isEmpty(userConfirmPassword.getText().toString())) {
					Toast.makeText(v.getContext(), "ȷ�����벻Ϊ��", Toast.LENGTH_SHORT).show();
					return;
				} else if (!(userPassword.getText().toString().equals(userConfirmPassword.getText().toString()))) {
					Toast.makeText(v.getContext(), "�����ȷ��������Ҫһ��", Toast.LENGTH_SHORT).show();
					return;
				}
				//�ж��ֻ����Ƿ����
				List<User> users = DataSupport.select("phonenumber").where("phonenumber == " + userPhone.getText().toString()).find(User.class);
				if (users.size() != 0) {
					Toast.makeText(v.getContext(), "���ֻ����Ѵ���", Toast.LENGTH_SHORT).show();
					return;
				}
				User user = new User("", "", userPassword.getText().toString(), userPhone.getText().toString());
				user.save();
				Toast.makeText(v.getContext(), "ע��ɹ�", Toast.LENGTH_LONG).show();
				
				// TODO Auto-generated method stub
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		//cell��¼
		cellLoginBtn=(Button) view.findViewById(R.id.cell_btn_login);
		cellLoginBtn.setOnClickListener(new OnClickListener() {
			
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
