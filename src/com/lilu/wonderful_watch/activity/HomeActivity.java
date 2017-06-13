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
	//主页变量声明
	private ListView mListView;
	//自定义适配器
	private MySimpleAdapter mSimpleAdapter;
	//to是绑定数据视图中的id
	private int[] dataTo=new int[]{R.id.home_iv_film,R.id.home_tv_film,R.id.home_tv_director,R.id.home_tv_cast};
	//from是map中的key
	private String[] dataFrom=new String[]{"post","film","director","cast"};
	//这是干嘛的--放了map类型的list 就是这样
	private List<Map<String,Object>> dataList;
	//为了在非Activity类里面使用Activity的startActivity方法
	public static HomeActivity homeActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//注意位置
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//视图显示
		setContentView(R.layout.home);
		//初始化
		homeActivity = this;
		//主页--home
		initList();
		
	}
	//主页--home
	private void initList() {
		mListView=(ListView) findViewById(R.id.home_lv_filmList);
		dataList=new ArrayList<Map<String,Object>>();
		mSimpleAdapter=new MySimpleAdapter(this,dataList,R.layout.home2,dataFrom,dataTo);
		
		
		//从数据库查询数据
		List<Movie> movies = DataSupport.select("id", "actorsdescription", "name", "post", "directors").order("publishtime desc").find(Movie.class);
		
		//如何获取到值
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
		//将适配器与组件绑定
		mListView.setAdapter(mSimpleAdapter);
		//将监听器与组件绑定--为什么绑定不上--因为按钮获取了焦点
		mListView.setOnItemClickListener(HomeActivity.this);
		mListView.setOnScrollListener(HomeActivity.this);
	}
	
	//主页--home
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// 接口的方法
		
	}
	//主页--home
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// 接口的方法--这个其实用不到吖吖吖
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			/*Log.i("tag--", "手指已经离开屏幕，视图还在滑动");
			//向下刷新
			Map<String,Object> fresh=new HashMap<String,Object>();
			//刷新加载--3.17
			fresh.put("post", R.drawable.film_1);
			fresh.put("film","新增电影");
			fresh.put("director", "新增导演");
			fresh.put("cast", "新增演职员表");
			dataList.add(fresh);
			//刷新ui界面
			mSimpleAdapter.notifyDataSetChanged();*/
			break;
		case SCROLL_STATE_IDLE:
			Log.i("tag--", "视图已经停止");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("tag--", "手指没有离开屏幕，而且视图在滑动");
			break;
		}
	}
	//主页--home
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		int movieId = (int) dataList.get(position).get("id");
		//点击item进入电影详情
		Intent  intent=new Intent(getApplicationContext(), DetailActivity.class);
		intent.putExtra("movieId", movieId);
		startActivity(intent);
		
		
		// 接口的方法
//		String str=mListView.getItemAtPosition(position)+"";
//		Toast.makeText(this, "点击进入电影详情"+position, Toast.LENGTH_SHORT).show();
		//Log.i("tag--", str);
	}
}
