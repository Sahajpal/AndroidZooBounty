//Bala murali krishna
package com.example.thezoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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