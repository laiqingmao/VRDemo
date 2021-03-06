package com.demo.myvr.vrmodule.presenter.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.vr.sdk.widgets.video.VrVideoEventListener;
import com.google.vr.sdk.widgets.video.VrVideoView;
import com.demo.myvr.R;

import java.io.IOException;

public class VideoPlayerActivity extends AppCompatActivity{
	private VrVideoView vr_video;
	private SeekBar seekBar;
	private TextView tv_progress;
	private VideoLoaderTask mVideoLoaderTask;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_player);
		Intent intent = getIntent();
		String play = intent.getStringExtra("play");
		vr_video = (VrVideoView) findViewById(R.id.vr_video);
		tv_progress = (TextView) findViewById(R.id.tv_progress);
		vr_video.setEventListener(new VrVideoEventListener(){
			@Override
			public void onLoadSuccess() {
				super.onLoadSuccess();
				seekBar.setMax((int) vr_video.getDuration());
			}

			@Override
			public void onNewFrame() {
				super.onNewFrame();
				seekBar.setProgress((int) vr_video.getCurrentPosition());
				tv_progress.setText("当前进度:"+String.format("%.2f",vr_video.getCurrentPosition()/1000f));
			}
		});
		mVideoLoaderTask = new VideoLoaderTask();
		mVideoLoaderTask.execute(play);

		seekBar = (SeekBar) findViewById(R.id.seek_bar);


	}
	private class VideoLoaderTask extends AsyncTask<String,Void,Void>{

		@Override
		protected Void doInBackground(String... params) {
			String play = params[0];
			VrVideoView.Options options=new VrVideoView.Options();
			options.inputType=VrVideoView.Options.TYPE_STEREO_OVER_UNDER;
			options.inputFormat=VrVideoView.Options.FORMAT_DEFAULT;
			try {
				vr_video.loadVideo(Uri.parse(play),options);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		vr_video.resumeRendering();
	}

	@Override
	protected void onPause() {
		super.onPause();
		vr_video.pauseRendering();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		vr_video.shutdown();
		mVideoLoaderTask.cancel(true);
	}
}
