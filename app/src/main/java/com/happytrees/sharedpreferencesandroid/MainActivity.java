package com.happytrees.sharedpreferencesandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity  {
    Toolbar mToolbar;
    Button mGreenColor;
    Button mRedColor;
    Button mYellowColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mGreenColor = (Button)findViewById(R.id.grnBtn);
        mRedColor = (Button)findViewById(R.id.rdBtn);
        mYellowColor = (Button)findViewById(R.id.yellowBtn);

        //make default app name  appear in toolbar
        mToolbar.setTitle(getResources().getString(R.string.app_name));

        //check if there  is already  stored color in SharedPreferences

        if(getColor()!=getResources().getColor(R.color.colorPrimary)){
            mToolbar.setBackgroundColor(getColor());
        }

        mRedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                storeColor(getResources().getColor(R.color.colorRed));
            }
        });

        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                storeColor(getResources().getColor(R.color.colorGreen));
            }
        });

        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
                storeColor(getResources().getColor(R.color.colorYellow));
            }
        });

    }


//method to store colors via SharedPreferences
private void storeColor(int color) {
    SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);//first argument is just name,second is access level
    SharedPreferences.Editor mEditor = mSharedPreferences.edit();
    mEditor.putInt("color",color);//first one is key value
    mEditor.apply();//this line saves color inside shared preferences
}
//method to get value
private int  getColor(){
    SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);//first argument is just name,second is access level
     int SelectedColor  = mSharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimary));
    return SelectedColor;
}
}

