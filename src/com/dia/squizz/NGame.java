package com.dia.squizz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.google.ads.*;

public class NGame extends Activity implements OnCheckedChangeListener, 
												OnClickListener{
	Button start;
	RadioGroup subjects;
	Global glob;
	//private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ngame);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialize();
        
        AdView ad = (AdView) findViewById(R.id.ad);
        ad.loadAd(new AdRequest());


     // Create the adView
        //adView = new AdView(this, AdSize.BANNER,  "a150031260ef3a9");

        // Lookup your LinearLayout assuming it’s been given
        // the attribute android:id="@+id/mainLayout"
        //LinearLayout layout = (LinearLayout)findViewById(R.id.ad);

        // Add the adView to it
        //layout.addView(adView);

        // Initiate a generic request to load it with an ad
        //adView.loadAd(new AdRequest());

	}

	private void initialize() {
		// TODO Auto-generated method stub
		start = (Button) findViewById(R.id.bStart);
		start.setOnClickListener(this);
		subjects = (RadioGroup) findViewById(R.id.radioGroup1);
		subjects.setOnCheckedChangeListener(this);
		glob = ((Global)getApplicationContext());
		glob.setMin(1);
		glob.setMax(150);
	}

	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbMovie:
			glob.setMin(1);
			glob.setMax(150);
			break;
		case R.id.rbMusic:
			glob.setMin(151);
			glob.setMax(300);
			break;
		case R.id.rbSport:
			glob.setMin(301);
			glob.setMax(400);
			break;
		case R.id.rbScience:
			glob.setMin(401);
			glob.setMax(550);
			break;
		case R.id.rbHistory:
			glob.setMin(551);
			glob.setMax(700);
			break;
		case R.id.rbAll:
			glob.setMin(1);
			glob.setMax(700);
			break;
		}
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bStart:
			try {
				Class ourclass = Class.forName("com.dia.squizz.Game");
				Intent ourIntent = new Intent(NGame.this,ourclass);
				startActivity(ourIntent);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}

}
