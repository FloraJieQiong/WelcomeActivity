package com.example.welcomactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.welcomactivity.util.SharePreferencesUtils;

public class WelcomeActivity extends Activity {

//	private ImageView splash_iv;
	public static String IS_FIRST = "isFirst";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
//		splash_iv = (ImageView) findViewById(R.id.splash_iv);
		new Handler(){
			public void handleMessage(android.os.Message msg) {
				if(SharePreferencesUtils.getBoolean(WelcomeActivity.this, IS_FIRST, true)){
					startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
					SharePreferencesUtils.saveBoolean(WelcomeActivity.this, IS_FIRST, false);
					finish();
				}else{
					startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
					finish();
				}
			};
		}.sendEmptyMessageDelayed(0, 3000);
		
		
	}

	
}
