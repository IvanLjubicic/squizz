package com.dia.squizz;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ActivityInfo;

public class SquizzActivity extends Activity{
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.squizzactivity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(3000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					Intent openStartingPoint = new Intent("com.dia.squizz.MAINMENU"); 
					startActivity(openStartingPoint);
					
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
		
	}
	
	

}