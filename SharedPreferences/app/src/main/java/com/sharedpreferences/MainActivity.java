package com.sharedpreferences;

import android.content.Context;    
import android.content.SharedPreferences;    
import android.app.Activity;    
import android.os.Bundle;    
import android.view.View;    
import android.widget.EditText;    
import android.widget.TextView;    
import android.widget.Toast;    


public class MainActivity extends Activity {    
    EditText username;    
    EditText password;    
    TextView dataView;    

    @Override    
    protected void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.main);    

        username = (EditText) findViewById(R.id.userNameInput);    
        password = (EditText) findViewById(R.id.passwordInput);    
        dataView = (TextView) findViewById(R.id.dataTextView);    

    }    
   
    public void saveData(View view){    
        SharedPreferences loginData = getSharedPreferences("info", Context.MODE_PRIVATE);    
        SharedPreferences.Editor editor = loginData.edit();    
        editor.putString("username", username.getText().toString());  
        editor.putString("password", password.getText().toString());
		username.setText("");
		password.setText("");
        editor.apply();    
        Toast.makeText(this,"Inserted",Toast.LENGTH_LONG).show();  
		  
    }    

    public void getData(View view){    
        SharedPreferences loginData = getSharedPreferences("info", Context.MODE_PRIVATE);    
        String name = loginData.getString("username", "");    
        String password = loginData.getString("password","");    
        String msg = "Username: " + name + "\nPassword: " + password;    
        dataView.setText(msg); 
		Toast.makeText(this,"Result",Toast.LENGTH_LONG).show();
    }    
}   
