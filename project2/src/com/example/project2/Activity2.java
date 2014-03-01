package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences Prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean theme2 = Prefs.getBoolean("page2", false);
        if (theme2 == true){
        	setTheme(R.style.alter);}
        else if (theme2 == false){
        	setTheme(R.style.original);}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		showButtonText2();

	}
	
    public void toNewActivity2(View view){
    	Intent intent = new Intent(this,Activity3.class);
    	startActivity(intent);
    }
    
    private void showButtonText2() {
        SharedPreferences Prefs = PreferenceManager
                .getDefaultSharedPreferences(this);



        TextView vt = (TextView) findViewById(R.id.text2);
        Button bt = (Button) findViewById(R.id.button2);
        bt.setText("Go To Activity3");
        boolean theme2 = Prefs.getBoolean("page2", false);
        vt.setText("\n Alternate Skin Selected:"
                + Prefs.getBoolean("page2", false));
        if (theme2 == true){
        	bt.setTextColor(Color.parseColor("#00A875"));
        	setTheme(R.style.alter);}
        else if (theme2 == false){
        	bt.setTextColor(Color.parseColor("#CE0071"));
        	setTheme(R.style.original);}
    }
}


