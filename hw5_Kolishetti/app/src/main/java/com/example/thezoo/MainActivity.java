//Bala murali krishna
package com.example.thezoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

class ZooData {
    int image, sound;
    ZooData(int image, int sound){
        this.image = image;
        this.sound = sound;
    }
}

public class MainActivity extends AppCompatActivity {
    ImageButton prevBtn;
    ImageButton nextBtn;
    ImageView animalImage;
    TextView title;
    ZooData[] data = { new ZooData(R.drawable.deer, R.raw.deer), new ZooData(R.drawable.gorilla, R.raw.gorilla), new ZooData(R.drawable.panda, R.raw.panda), new ZooData(R.drawable.lion, R.raw.lion), new ZooData(R.drawable.elephant, R.raw.elephant)};
    int i=0;
    static boolean isFirst = true;
    static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalImage = (ImageButton) findViewById(R.id.animalImage);
        prevBtn = (ImageButton) findViewById(R.id.prevBtn);
        nextBtn = (ImageButton) findViewById(R.id.nextBtn);
        title = (TextView) findViewById(R.id.titleZoo);

        startService(new Intent(MainActivity.this, SoundService.class));
    }

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }

    public void imageButtonHandler(View view){
        mp = MediaPlayer.create(this, data[i].sound);
        if(!isFirst) {
            mp.start();
        }
    }

    public void prevBtnHandler(View view) {
        if(isFirst){
            isFirst = false;
            i = data.length-1;
        } else if(i == 0) {
            i = data.length-1;
        } else {
            i--;
        }
        title.setText("");
        animalImage.setImageResource(data[i].image);
    }

    public void NextBtnHandler(View view) {
        if(isFirst) {
            isFirst = false;
            i = 0;

        } else {
            i = (i+1) % data.length;
        }
        title.setText("");
        animalImage.setImageResource(data[i].image);

    }

    protected void onDestroy() {
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onDestroy();
    }
}