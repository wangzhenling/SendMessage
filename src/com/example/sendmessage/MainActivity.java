package com.example.sendmessage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText etPhone,etMessage;
	Button btnSendMessage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSendMessage=(Button) this.findViewById(R.id.btnSendMessage);
		etPhone=(EditText) this.findViewById(R.id.etPhone);
		etMessage=(EditText) this.findViewById(R.id.etMessage);
		btnSendMessage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String mobile=etPhone.getText().toString();
				String content=etMessage.getText().toString();
				Intent intent=new Intent();
				intent.setData(Uri.parse("smsto:"+mobile));
				intent.putExtra("sms_body", content);
				startActivity(intent);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
