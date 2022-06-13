package com.example.thezoo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Zoo extends MainActivity{

    ImageButton prevBtn;
    ImageButton nextBtn;
    Button infoButton;
    ImageView animalImage;
    ZooData[] data = {
            new ZooData(R.drawable.deer, R.raw.deer, "https://en.wikipedia.org/wiki/Deer"),
            new ZooData(R.drawable.gorilla, R.raw.gorilla, "https://en.wikipedia.org/wiki/Gorilla"),
            new ZooData(R.drawable.panda, R.raw.panda, "https://en.wikipedia.org/wiki/Giant_panda"),
            new ZooData(R.drawable.lion, R.raw.lion, "https://en.wikipedia.org/wiki/Lion"),
            new ZooData(R.drawable.elephant, R.raw.elephant, "https://en.wikipedia.org/wiki/Elephant")
    };
    int i=0;
    static MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo);

        animalImage = (ImageButton) findViewById(R.id.animalImage);
        prevBtn = (ImageButton) findViewById(R.id.prevBtn);
        nextBtn = (ImageButton) findViewById(R.id.nextBtn);
        infoButton = (Button) findViewById(R.id.infoButton);

        startService(new Intent(Zoo.this, SoundService.class));

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(data[i].url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
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
        mp.start();
    }

    public void prevBtnHandler(View view) {
        if(i == 0) {
            i = data.length-1;
        } else {
            i--;
        }
        animalImage.setImageResource(data[i].image);
    }

    public void NextBtnHandler(View view) {
        i = (i+1) % data.length;
        animalImage.setImageResource(data[i].image);

    }

    protected void onDestroy() {
        stopService(new Intent(Zoo.this, SoundService.class));
        super.onDestroy();
    }
}
