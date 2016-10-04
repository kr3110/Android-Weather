package com.example.weather;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.weather.*;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
	private static final String TAG ="Weather";
	
	private TextView inputMessage_TextView;
	private Button goButton;
	private EditText zip_EditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inputMessage_TextView = (TextView)findViewById(R.id.textView1);
		inputMessage_TextView.setHighlightColor(color.holo_blue_dark);
		
		zip_EditText = (EditText)findViewById(R.id.editText1);
		zip_EditText.setText("11372");
		
		goButton =(Button)findViewById(R.id.button1);
		goButton.setOnClickListener(this);
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
		
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public void onClick(View v) {
		{
			if(v==goButton)
			{
				Log.e(TAG, "Button just clicked");
	    		String urlString = "http://www.weather.com/weather/today/l/";
				  urlString = urlString + zip_EditText.getText().toString() + ":4:US";	//e.g. "http://www.weather.com/weather/today/l/11367:4:US"
				  URL url;
				  try {

					url = new URL(urlString);
				
				WebView myWebView = (WebView) findViewById(R.id.webView1);   
				myWebView.getSettings().setJavaScriptEnabled(true); 
				myWebView.clearCache(true);
				myWebView.loadUrl(url.toString());	
				}
				catch(MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
