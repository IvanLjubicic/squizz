package com.dia.squizz;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends Activity implements OnClickListener {

	Button sngame, cgame, hscores, howto, about;
	Global glob;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		initialize();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		sngame = (Button) findViewById(R.id.bNgame);
		sngame.setOnClickListener(this);
		cgame = (Button) findViewById(R.id.bCgame);
		cgame.setOnClickListener(this);
		hscores = (Button) findViewById(R.id.bHscores);
		hscores.setOnClickListener(this);
		howto = (Button) findViewById(R.id.bHowto);
		howto.setOnClickListener(this);
		about = (Button) findViewById(R.id.bAbout);
		about.setOnClickListener(this);
		glob = ((Global) getApplicationContext());
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bNgame:
			try {
				Class ourclass = Class.forName("com.dia.squizz.NGame");
				Intent ourIntent = new Intent(MainMenu.this, ourclass);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case R.id.bCgame:
			// OVO JE TAJ DIO KODA
			String FILENAME = "hello_file";
		    File file = getBaseContext().getFileStreamPath(FILENAME);
			if (!file.exists()) {
				Toast.makeText(this, "There is no previous game", Toast.LENGTH_LONG).show();
				//Toast.makeText(this, "Ti mater", Toast.LENGTH_LONG).show();
			} else {
				try {
					Class ourclass = Class.forName("com.dia.squizz.ContinueGame");
					Intent ourIntent = new Intent(MainMenu.this, ourclass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			// DO OVDJE
			/*
			 * try { Class ourclass =
			 * Class.forName("com.dia.squizz.ContinueGame"); Intent ourIntent =
			 * new Intent(MainMenu.this, ourclass); startActivity(ourIntent); }
			 * catch (ClassNotFoundException e) { e.printStackTrace(); }
			 */
			break;
		case R.id.bHscores:
			try {
				Class support = Class.forName("com.dia.squizz.Website");
				Intent supp = new Intent(MainMenu.this, support);
				startActivity(supp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Toast.makeText(this, "Available in next version!",
			// Toast.LENGTH_LONG).show;
			break;
		case R.id.bHowto:
			try {
				Class howt = Class.forName("com.dia.squizz.HowToPlay");
				Intent how = new Intent(MainMenu.this, howt);
				startActivity(how);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bAbout:
			try {
				Class about = Class.forName("com.dia.squizz.AboutUs");
				Intent aboutus = new Intent(MainMenu.this, about);
				startActivity(aboutus);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}

	}

}
