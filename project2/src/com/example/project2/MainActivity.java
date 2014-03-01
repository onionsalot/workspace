package com.example.project2;



import android.os.Bundle;
import android.preference.PreferenceManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private static final int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences Prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        boolean theme1 = Prefs.getBoolean("page1", false);
        if (theme1 == true){
        	setTheme(R.style.alter);}
        else if (theme1 == false){
        	setTheme(R.style.original);}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showButtonText();
    }
    

    
    public void toNewActivity(View view){
    	Intent intent = new Intent(this,Activity2.class);
    	startActivity(intent);
    }



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "menu option selected", Toast.LENGTH_SHORT).show();
		if(item.getItemId() == R.id.action_settings){
            Intent i = new Intent(this, SettingsActivity.class);
            startActivityForResult(i, REQUESTCODE);

	
		}
		return true;
	}


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
        case REQUESTCODE:
        	Intent i = new Intent(this, MainActivity.class);
        	startActivity(i);
        	finish();
            break;
 
        }}
	
	
    private void showButtonText() {
        SharedPreferences Prefs = PreferenceManager
                .getDefaultSharedPreferences(this);



        TextView vt = (TextView) findViewById(R.id.text1);
        Button bt = (Button) findViewById(R.id.button1);
        bt.setText("Go To Activity2");
        boolean theme1 = Prefs.getBoolean("page1", false);
        vt.setText("\n Alternate Skin Selected:"
                + Prefs.getBoolean("page1", false));
        if (theme1 == true){
        	bt.setTextColor(Color.parseColor("#00A875"));
        	setTheme(R.style.alter);}
        else if (theme1 == false){
        	bt.setTextColor(Color.parseColor("#CE0071"));
        	setTheme(R.style.original);}
    }
	


}
