package com.jlstudio.barcodesanningapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LandingActivity extends Activity implements OnClickListener{
	
	Button startScan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.landing_activity); 
	    
	    initialiseView();
	    
	}
	
	private void initialiseView()
	{
		startScan = (Button)findViewById(R.id.start_scan);
		startScan.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {	
		System.out.println("click detected...");
		if(view.getId() == R.id.start_scan)
		{
			System.out.println("starting now...");
			Intent intent = new Intent(LandingActivity.this, MainActivity.class);
			startActivity(intent);
		}
	}
	
	
}
