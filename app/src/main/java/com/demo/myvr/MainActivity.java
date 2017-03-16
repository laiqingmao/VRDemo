package com.demo.myvr;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.demo.myvr.vrmodule.presenter.adapter.MyPagerAdapter;
import com.demo.myvr.vrmodule.presenter.fragment.VrPanoFragmment;
import com.demo.myvr.vrmodule.presenter.fragment.VrVideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle mToggle;
	private ViewPager mViewPager;
	private TabLayout tabLayout;
	private long lastBackPressMillis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		initView();
		initActionBar();
		initViewPager();
	}

	private void initViewPager() {

		List<Fragment> fragments = new ArrayList<>();
		fragments.add(new VrPanoFragmment());
		fragments.add(new VrVideoFragment());
		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		adapter.setFragments(fragments);
		mViewPager.setAdapter(adapter);

		tabLayout.setupWithViewPager(mViewPager);
	}

	private void initView() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mViewPager = (ViewPager) findViewById(R.id.vp);
		tabLayout = (TabLayout) findViewById(R.id.tab_layout);
	}

	private void initActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
		mToggle.syncState();
		drawerLayout.addDrawerListener(mToggle);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		long currentTimeMillis = System.currentTimeMillis();
		if (currentTimeMillis - lastBackPressMillis < 2000) {
			super.onBackPressed();
		} else {
			Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
			lastBackPressMillis = currentTimeMillis;
		}
	}
}
