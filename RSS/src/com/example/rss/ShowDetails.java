package com.example.rss;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
 // TODO Auto-generated method stub
 super.onCreate(savedInstanceState);
 setContentView(R.layout.details);
 TextView detailsTitle = (TextView)findViewById(R.id.detailstitle);
 TextView detailsDescription = (TextView)findViewById(R.id.detailsdescription);
 TextView detailsPubdate = (TextView)findViewById(R.id.detailspubdate);
 TextView detailsLink = (TextView)findViewById(R.id.detailslink);

 Bundle bundle = this.getIntent().getExtras();
    
      detailsTitle.setText(bundle.getString("keyTitle"));
      detailsDescription.setText(bundle.getString("keyDescription"));
      detailsPubdate.setText(bundle.getString("keyPubdate"));
      detailsLink.setText(bundle.getString("keyLink"));
    
}
}