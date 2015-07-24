package br.exemploactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static final int CONSTANT_SCREEN_1 = 1;
	public static final int CONSTANT_SCREEN_2 = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void sendScreenData1(View view){
        EditText nome = (EditText) findViewById(R.id.edtNome);
        EditText email = (EditText) findViewById(R.id.edtEmail);
        EditText phone = (EditText) findViewById(R.id.edtfone);

        Bundle params = new Bundle();
        params.putString("name", nome.getText().toString());
        params.putString("email", email.getText().toString());
        params.putString("phone", phone.getText().toString());

		Intent intent = new Intent(this, Tela1.class);
		intent.putExtras(params);

		startActivityForResult(intent, CONSTANT_SCREEN_1);
	}
	
	public void sendScreenData2(View view){
		EditText nome = (EditText) findViewById(R.id.edtNome);
		EditText email = (EditText) findViewById(R.id.edtEmail);
        EditText phone = (EditText) findViewById(R.id.edtfone);
		
		Bundle params = new Bundle();
		params.putString("name", nome.getText().toString());
		params.putString("email", email.getText().toString());
        params.putString("phone", phone.getText().toString());
		
		Intent intent = new Intent(this, Tela2.class);
		intent.putExtras(params);
		
		startActivityForResult(intent, CONSTANT_SCREEN_2);
	}

    @Override                        // screen code      result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CONSTANT_SCREEN_1){
            Bundle params = data.getExtras();
            if(params != null){
                String msg = params.getString("msg");
                Toast.makeText(this, "Screen 1 -> Result: "+ resultCode +" | Msg: " + msg, Toast.LENGTH_LONG).show();
                Log.d("SCREEN 1: ", "Screen 1 -> RequestCode: " + requestCode +  " Result: " + resultCode + " | Msg: " + msg);
            }
        }
        else if(requestCode == CONSTANT_SCREEN_2){
            Bundle params = data.getExtras();
            if(params != null){
                String msg = params.getString("msg");
                Toast.makeText(this, "Screen 2 -> Result: "+ resultCode +" | Msg: " + msg, Toast.LENGTH_LONG).show();
                Log.d("SCREEN 1: ", "Screen 2 -> RequestCode: " + requestCode +  " Result: " + resultCode + " | Msg: " + msg);
            }
        }

    }

}
