//Bala murali krishna
package com.example.thezoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    static boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Zoo();
    }

    public void Zoo()
    {
        if(isFirst) {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    isFirst = false;
                    Intent mainIntent = new Intent(MainActivity.this,Zoo.class);
                    startActivity(mainIntent);
                    finish();
                }
            }, 2000);
        }

    }
}