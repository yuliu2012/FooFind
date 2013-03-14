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
          
        //ȡ��TabHost����     
          tabhost = getTabHost();     
          
        //ΪTabHost��ӱ�ǩ     
         //�½�һ��newTabSpec(newTabSpec)     
        //�������ǩ��ͼ�꣨setIndicator��     
         //�������ݣ�setContent��   
         Intent intent = new Intent(context, SearchActivity.class);
         Intent intent2 = new Intent(context, RecommendationActivity.class);
         tabhost.addTab(tabhost.newTabSpec("Home")     
                .setIndicator("Home")    
                .setContent(intent));     
         tabhost.addTab(tabhost.newTabSpec("Recommendation")     
                .setIndicator("Recommendation")    
                .setContent(intent2));      
         //����TabHost�ı�����ɫ     
           tabhost.setBackgroundColor(Color.argb(150,22,70,150));     
         //����TabHost�ı���ͼƬ��Դ     
           tabhost.setBackgroundResource(R.drawable.touming);     
        //���õ�ǰ��ʾ�ĸ���ǩ     
           tabhost.setCurrentTab(0);     
          
        //��ǩ�л��¼�����setOnTabChangedListener     
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
