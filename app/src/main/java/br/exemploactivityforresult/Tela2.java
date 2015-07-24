package br.exemploactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela2);
		
		Intent intent = getIntent();
		if(intent != null){
			Bundle params = intent.getExtras();
			if(params != null){
				String nome = params.getString("name"); // setting just the Key..
				String email = params.getString("email");
				String phone = params.getString("phone");
				
				TextView nomeTV = (TextView) findViewById(R.id.name2);
				TextView emailTV = (TextView) findViewById(R.id.email2);
				TextView phoneTV = (TextView) findViewById(R.id.phone2_1);

				nomeTV.setText("Name: "+nome);
				emailTV.setText("Email: "+email);
				phoneTV.setText("Phone: "+phone);
			}
		}
	}
	
	public void aceitou(View view){
		Intent intent = new Intent();
		intent.putExtra("msg", "Accept");
		
		setResult(1, intent);
		finish();
	}
	
	public void rejeitou(View view){
		Intent intent = new Intent();
		intent.putExtra("msg", "Reject");
		
		setResult(2, intent);
		finish();
	}
}
