package com.example.foofind;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class RecommendationActivity extends ListActivity {
	final Context context = this;

	static final String[] Country = new String[] { "Popular", "Arabian","American", "African",
		"Australian",
		"Brazilian","Caribbean","Chinese","Danish",
		"French", "Germany","Hawaiian","Indian", "Italian", "Japanese","Korean",
		"Laotian",
		"Mexican","Mediterranean","Thai",
		"Russian",
		};
//	protected static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// no more this
	// setContentView(R.layout.list_fruit);

	setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_recommendation,Country));

	ListView listView = getListView();
	listView.setTextFilterEnabled(true);

	listView.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
		    // When clicked, show a new window about the dishes of this country
			Intent intent = new Intent(context,DishActivity.class);

	    	startActivity(intent);
		 //   Toast.makeText(getApplicationContext(),
			//((TextView) view).getText(), Toast.LENGTH_SHORT).show();
		}
	});

}

}
