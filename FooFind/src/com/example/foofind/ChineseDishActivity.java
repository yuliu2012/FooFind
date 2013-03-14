package com.example.foofind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
 
public class ChineseDishActivity extends ListActivity {
	final Context context = this;
    // 图片数组
    static final int[] images = { R.drawable.a1, 
    	R.drawable.a2,
    	R.drawable.a3,
    	R.drawable.a4,
    	R.drawable.a5,
    	R.drawable.a6,
    	R.drawable.a7,
    	R.drawable.a8,
    	R.drawable.a9,
            };
    // 作者数组
   
    static final String[] author = { "Asian Chicken Salad",
    	"Sweet and Sour Chicken",
    	"Chinese Green Bean Stir-Fry",
    	"Chinese Spareribs",
    	"Crab Rangoon",
    	"Pineapple Fried Rice",
    	"Pork Wonton Soup",
    	"Winter Melon Meatball Soup",
    	"Wonton Soup"};


    static final String[] times = { "Cook time: 5 min",
    	"Cook time: 6 mins",
    	"Cook time: 4 mins" ,
    	"Cook time: 8 mins", 
    	"Cook time: 5 mins", 
    	"Cook time: 7 mins",
    	"Cook time: 8 mins",
    	"Cook time: 6 mins",
    	"Cook time: 7 mins"};


    static final String[] content = { "Level: primary school",
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
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_activity_list5);
        setListAdapter(new SimpleAdapter(this, getData(),
        		R.layout.activity_chinese_dish, new String[] { "image",
                        "author", "time", "content" }, new int[] { R.id.image,
                        R.id.author, R.id.time, R.id.content }));
        ListView listView=getListView();
        listView.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,
                    long id) {
            	Intent intent = new Intent(context,DishActivity.class);
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
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chinese_dish,menu);
        return true;
    }
}