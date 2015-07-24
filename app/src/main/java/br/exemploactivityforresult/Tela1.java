package br.exemploactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela1);
		
		Intent intent = getIntent();
		if(intent != null){
			Bundle params = intent.getExtras();
			if(params != null){
				String nome = params.getString("name"); // setting just the Key..
				String email = params.getString("email");
				String phone = params.getString("phone");
				
				TextView nomeTV = (TextView) findViewById(R.id.name_1);
				TextView emailTV = (TextView) findViewById(R.id.email_1);
				TextView phoneTV = (TextView) findViewById(R.id.phone1);
				
				nomeTV.setText("Name: "+nome);
				emailTV.setText("Email: "+email);
                phoneTV.setText("Phone: "+phone);
			}
		}
	}
	
	public void aceitou(View view){
		Intent intent = new Intent();
		intent.putExtra("msg", "Accept");
		
		setResult(1, intent); // 1 is the constant for screen-1
		finish();
	}
	
	public void rejeitou(View view){
		Intent intent = new Intent();
		intent.putExtra("msg", "Reject");
		
		setResult(2, intent);  // 2 is the constant for screen-2
		finish();
	}
}
