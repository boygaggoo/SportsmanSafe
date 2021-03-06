package com.example.sportsmansafe;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutActivity extends Activity implements OnClickListener{

	private TextView aboutCloseButton;
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		 setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		aboutCloseButton = (TextView)findViewById(R.id.aboutCloseButton);
	    	
		aboutCloseButton.setOnClickListener(this);
		webView = (WebView)findViewById(R.id.aboutUsHtml);
		webView.loadUrl("file:///android_asset/AboutUsText.html");
		webView.setScrollContainer(true);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		startActivity(new Intent(this,InfoActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

	

}
