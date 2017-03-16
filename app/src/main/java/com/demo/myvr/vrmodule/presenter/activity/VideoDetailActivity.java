package com.demo.myvr.vrmodule.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.myvr.R;

public class VideoDetailActivity extends AppCompatActivity{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_detail);
		init();
	}

	private void init() {
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		String img = intent.getStringExtra("img");
		String text = intent.getStringExtra("text");
		final String play = intent.getStringExtra("play");

		TextView tvTitle= (TextView) findViewById(R.id.title_text);
		tvTitle.setText(title);

		ImageView ivImg= (ImageView) findViewById(R.id.detail_img_view);
		Glide.with(this).load(img).into(ivImg);

		TextView tv_detail= (TextView) findViewById(R.id.detail_text);
		tv_detail.setText(text);

		findViewById(R.id.play_link).setOnClickListener(v -> {
			Intent intent1 =new Intent(VideoDetailActivity.this,VideoPlayerActivity.class);
			intent1.putExtra("play",play);
			startActivity(intent1);
		});

	}
}
