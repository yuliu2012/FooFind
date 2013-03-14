package com.example.foofind;
import android.app.TabActivity;        
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;     
import android.widget.TabHost;     
import android.widget.Toast;     
import android.widget.TabHost.OnTabChangeListener;  
  
public class MainActivity extends TabActivity   
{  
	final Context context = this;
    TabHost tabhost;     
    @Override    
    public void onCreate(Bundle savedInstanceState)  
    {     
        super.onCreate(savedInstanceState);     
        setContentView(R.layout.activity_main);     
          
        //取得TabHost对象     
          tabhost = getTabHost();     
          
        //为TabHost添加标签     
         //新建一个newTabSpec(newTabSpec)     
        //设置其标签和图标（setIndicator）     
         //设置内容（setContent）   
         Intent intent = new Intent(context, SearchActivity.class);
         Intent intent2 = new Intent(context, RecommendationActivity.class);
         tabhost.addTab(tabhost.newTabSpec("Home")     
                .setIndicator("Home")    
                .setContent(intent));     
         tabhost.addTab(tabhost.newTabSpec("Recommendation")     
                .setIndicator("Recommendation")    
                .setContent(intent2));      
         //设置TabHost的背景颜色     
           tabhost.setBackgroundColor(Color.argb(150,22,70,150));     
         //设置TabHost的背景图片资源     
           tabhost.setBackgroundResource(R.drawable.touming);     
        //设置当前显示哪个标签     
           tabhost.setCurrentTab(0);     
          
        //标签切换事件处理，setOnTabChangedListener     
        tabhost.setOnTabChangedListener(new OnTabChangeListener()     
        {     
            public void onTabChanged(String tabId)     
            {               
                switch(tabhost.getCurrentTab())  
                {  
                case 0:  
                	 tabhost.setBackgroundResource(R.drawable.background2);  
                     Toast.makeText(getApplicationContext(), "You are in Home Page", Toast.LENGTH_SHORT).show();  
                     break;             	 
                 case 1: 
                	 tabhost.setBackgroundResource(R.drawable.recb1);  
                     Toast.makeText(getApplicationContext(), "You are in Recommendation Page", Toast.LENGTH_SHORT).show();      
                }                              
            }     
        });      
    }     
}
