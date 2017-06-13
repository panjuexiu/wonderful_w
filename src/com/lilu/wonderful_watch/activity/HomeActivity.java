package com.lilu.wonderful_watch.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.litepal.crud.DataSupport;

import com.lilu.wonderful_watch.R;
import com.lilu.wonderful_watch.activity.adapter.MySimpleAdapter;
import com.lilu.wonderful_watch.model.Movie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;

public class HomeActivity extends Activity implements OnItemClickListener,OnScrollListener {
	//��ҳ��������
	private ListView mListView;
	//�Զ���������
	private MySimpleAdapter mSimpleAdapter;
	//to�ǰ�������ͼ�е�id
	private int[] dataTo=new int[]{R.id.home_iv_film,R.id.home_tv_film,R.id.home_tv_director,R.id.home_tv_cast};
	//from��map�е�key
	private String[] dataFrom=new String[]{"post","film","director","cast"};
	//���Ǹ����--����map���͵�list ��������
	private List<Map<String,Object>> dataList;
	//Ϊ���ڷ�Activity������ʹ��Activity��startActivity����
	public static HomeActivity homeActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ע��λ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//��ͼ��ʾ
		setContentView(R.layout.home);
		//��ʼ��
		homeActivity = this;
		//��ҳ--home
		initList();
		
	}
	//��ҳ--home
	private void initList() {
		mListView=(ListView) findViewById(R.id.home_lv_filmList);
		dataList=new ArrayList<Map<String,Object>>();
		mSimpleAdapter=new MySimpleAdapter(this,dataList,R.layout.home2,dataFrom,dataTo);
		
		
		//�����ݿ��ѯ����
		List<Movie> movies = DataSupport.select("id", "actorsdescription", "name", "post", "directors").order("publishtime desc").find(Movie.class);
		
		//��λ�ȡ��ֵ
		for (Movie movie : movies) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("post", R.drawable.film);
			map.put("id", movie.getId());
			map.put("film", movie.getName());
			map.put("director", movie.getDirectors());
			map.put("post", movie.getPost());
			map.put("cast", movie.getActorsDescription());
			dataList.add(map);
		}
		//���������������
		mListView.setAdapter(mSimpleAdapter);
		//���������������--Ϊʲô�󶨲���--��Ϊ��ť��ȡ�˽���
		mListView.setOnItemClickListener(HomeActivity.this);
		mListView.setOnScrollListener(HomeActivity.this);
	}
	
	//��ҳ--home
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// �ӿڵķ���
		
	}
	//��ҳ--home
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// �ӿڵķ���--�����ʵ�ò���߹߹߹
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			/*Log.i("tag--", "��ָ�Ѿ��뿪��Ļ����ͼ���ڻ���");
			//����ˢ��
			Map<String,Object> fresh=new HashMap<String,Object>();
			//ˢ�¼���--3.17
			fresh.put("post", R.drawable.film_1);
			fresh.put("film","������Ӱ");
			fresh.put("director", "��������");
			fresh.put("cast", "������ְԱ��");
			dataList.add(fresh);
			//ˢ��ui����
			mSimpleAdapter.notifyDataSetChanged();*/
			break;
		case SCROLL_STATE_IDLE:
			Log.i("tag--", "��ͼ�Ѿ�ֹͣ");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("tag--", "��ָû���뿪��Ļ��������ͼ�ڻ���");
			break;
		}
	}
	//��ҳ--home
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		int movieId = (int) dataList.get(position).get("id");
		//���item�����Ӱ����
		Intent  intent=new Intent(getApplicationContext(), DetailActivity.class);
		intent.putExtra("movieId", movieId);
		startActivity(intent);
		
		
		// �ӿڵķ���
//		String str=mListView.getItemAtPosition(position)+"";
//		Toast.makeText(this, "��������Ӱ����"+position, Toast.LENGTH_SHORT).show();
		//Log.i("tag--", str);
	}
}
