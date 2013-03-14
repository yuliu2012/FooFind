package com.example.foofind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.Directory;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SearchActivity extends Activity {
	private static final int CAMERA = 100;
	private File mCurrentPhotoFile;
	private Bitmap cameraBitmap;
	private ImageView imageView;
	private ImageButton b;
	private static File mHeadFile;
	private static final File PHOTO_DIR=new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		b=(ImageButton) findViewById(R.id.imageButton1);
		b.getBackground().setAlpha(50);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	  public void search(View view) {
	    	EditText temp=(EditText)findViewById(R.id.editText1);
	    	if(temp.getText().toString().equals("cucumber") || 
	    			temp.getText().toString().isEmpty()){
	    		Intent intent = new Intent(this, RecipeActivity.class);
	        	startActivity(intent);
	    	}
	    	else{
	    		Intent intent = new Intent(this, OneDishActivity.class);
	        	startActivity(intent);
	    	}
	    }
	 /*   public void takePhoto(View view){
	    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        // start the image capture Intent
	        startActivityForResult(intent, 100);
	    }*/
	  public void takePhoto(View view){
		  Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		  startActivityForResult(intent,1);
		  }
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  super.onActivityResult(requestCode, resultCode, data);
		  if (resultCode == Activity.RESULT_OK) {
			  String sdStatus = Environment.getExternalStorageState();
			  Bundle bundle = data.getExtras();
			  Bitmap bitmap = (Bitmap) bundle.get("data");
			  FileOutputStream b = null;
			  File file = new File("/sdcard/myImage/");
			  file.mkdirs();
			  String fileName = "/sdcard/myImage/111.jpg";
			  try {
				b = new FileOutputStream(fileName);
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			  try {
				b.flush();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  ((ImageView) findViewById(R.id.imageView1)).setImageBitmap(bitmap);
		  }
	  }
}
