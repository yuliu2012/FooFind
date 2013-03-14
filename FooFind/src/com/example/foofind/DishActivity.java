package com.example.foofind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DishActivity extends FragmentActivity implements

		ActionBar.OnNavigationListener {
	final Context context = this;
	static final int[] images = { 
		R.drawable.a0,
		R.drawable.a1, 
    	R.drawable.a2,
    	R.drawable.a3,
    	R.drawable.a4,
    	R.drawable.a5,
    	R.drawable.a6,
    	R.drawable.a7,
    	R.drawable.a8,
    	R.drawable.a9,
            };
	 
	   
	    static final String[] author = { 
	    	"Kong Pao Chicken",
	    	"Asian Chicken Salad",
	    	"Sweet and Sour Chicken",
	    	"Chinese Green Bean Stir-Fry",
	    	"Chinese Spareribs",
	    	"Crab Rangoon",
	    	"Pineapple Fried Rice",
	    	"Pork Wonton Soup",
	    	"Winter Melon Meatball Soup",
	    	"Wonton Soup"};


	    static final String[] times = { 
	    	"Cook time: 18 min",
	    	"Cook time: 5 min",
	    	"Cook time: 6 mins",
	    	"Cook time: 4 mins" ,
	    	"Cook time: 8 mins", 
	    	"Cook time: 5 mins", 
	    	"Cook time: 7 mins",
	    	"Cook time: 8 mins",
	    	"Cook time: 6 mins",
	    	"Cook time: 7 mins"};


	    static final String[] content = {
	    	"Level: undergraduate",
	    	"Level: primary school",
	    	"Level: middle school",
	    	"Level: high school", 
	    	"Level: primary school",
	    	"Level: graduate school",
	    	"Level: middle school",
	    	"Level: high school",
	    	"Level: university",
	    	"Level: PHD"};


	    static final String[] taste = {"BBQ",
	    	"Sweet and Sour",
	    	"Spicy",
	    	"BBQ",
	    	"light",
	    	"warm",
	    	"Sweet",
	    	"light",
	    	"light" };
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dish);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(getActionBarThemedContextCompat(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3),
								getString(R.string.title_section4),
								getString(R.string.title_section5),}), this);
		
		 /*  ListView lv = (ListView) findViewById(R.id.lv);  
	        List<String> items = getData();  
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  
	                android.R.layout.simple_list_item_1, items);  
	  
	        lv.setAdapter(adapter);  */
		ListView lv = (ListView) findViewById(R.id.lv);  
		 lv.setAdapter(new SimpleAdapter(this, getData(),
        		R.layout.activity_chinese_dish, new String[] { "image",
            "author", "time", "content" }, new int[] {R.id.image,
            R.id.author, R.id.time, R.id.content }));
	  
	        OnItemClickListener listener = new OnItemClickListener() {  
	            public void onItemClick(AdapterView<?> parent, View view,  
	                    int position, long id) {  
	                setTitle(parent.getItemAtPosition(position).toString());  
	            }  
	        };  
	          
	        lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view,int position,
	                    long id) {
	            	Intent intent = new Intent(context,OneDishActivity.class);
	    	    	startActivity(intent);
	            }
	        });
	}
	private List<? extends Map<String, ?>> getData() {
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        for (int i = 0; i < images.length; i++) {
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("image",images[i]);
            map.put("author",author[i]);
            map.put("time",times[i]);
            map.put("content",content[i]);
            list.add(map);
        }
        return list;
    }

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dish, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
	/*	Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();*/
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "Select Category";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_dish_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			String temp="hello";
			dummyTextView.setText(temp);
		//	dummyTextView.setText(Integer.toString(getArguments().getInt(
				//	ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
