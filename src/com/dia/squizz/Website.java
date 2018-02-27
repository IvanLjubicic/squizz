package com.dia.squizz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Website extends Activity{
	
	WebView ourBrow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.website);
		
		ourBrow = (WebView) findViewById(R.id.wvBrowser);
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		ourBrow.setWebViewClient(new OurViewClient());
		
		try{
			ourBrow.loadUrl("http://www.squizz-quiz.blogspot.com");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

