package com.example.foofind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class RecipeActivity extends Activity {
	final Context context = this;
	static final int[] images = {
		R.drawable.a0,
		R.drawable.b0,
		R.drawable.b1, 
    	R.drawable.b2,
    	R.drawable.b3,
    	R.drawable.b4,
            };
	    static final String[] author = { 
	    	"Kong Pao Chicken",
	    	"BBQ and Roasted Pork",
	    	"Cucumber Scrambled Eggs",
	    	"Fresh Cucumber in Soy Sauce",
	    	"Salt Cod Fried Rice",
	    	"Stir Fried Pork and Cucumber"};

	    static final String[] times = { 
	    	"Cook time: 18 min",
	    	"Cook time: 5 min",
	    	"Cook time: 6 mins",
	    	"Cook time: 4 mins",
	    	"Cook time: 12 mins",
	    	"Cook time: 9 mins",};


	    static final String[] content = {
	    	"Level: Undergraduate",
	    	"Level: Primary school",
	    	"Level: Secondary school",
	    	"Level: High school",
	    	"Level: Master",
	    	"Level:PHD",};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);
		ListView lv = (ListView) findViewById(R.id.listView1);  
		 lv.setAdapter(new SimpleAdapter(this, getData(),
      		R.layout.activity_chinese_dish, new String[] { "image","space",
          "author", "time", "content" }, new int[] {R.id.image,R.id.space,
          R.id.author, R.id.time, R.id.content }));
		 lv.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View view,int position,
	                    long id) {
	            	Intent intent = new Intent(context,OneDishActivity.class);
	    	    	startActivity(intent);
	            }
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recipe, menu);
		return true;
	}
	public void search(View view) {
    		Intent intent = new Intent(this, DishActivity.class);
        	startActivity(intent);
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

}
