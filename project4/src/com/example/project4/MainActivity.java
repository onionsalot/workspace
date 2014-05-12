package com.example.project4;

import java.util.List;

import helpers.FeedListAdapter;
import helpers.MyCustomFeedParser;
import android.os.Bundle;
import android.os.Message;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     MyCustomFeedParser parser = new MyCustomFeedParser("http://rss.nytimes.com/services/xml/rss/nyt/HomePage.xml");
     List<helpers.Message> messages = parser.parse();
     setListAdapter(new FeedListAdapter(this, messages));
    }
}




