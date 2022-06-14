//Bala murali krishna
package com.example.thezoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button prevBtn;
    Button nextBtn;
    ImageView animalImage;
    TextView title;
    int[] images = {R.drawable.deer, R.drawable.gorilla, R.drawable.panda, R.drawable.lion, R.drawable.elephant };
    int i=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        animalImage = (ImageView) findViewById(R.id.animalImage);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        title = (TextView) findViewById(R.id.titleZoo);
    }

    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }

    public void prevBtnHandler(View view) {
        title.setText("");
        if(i==-1) {
            i=images.length-1;
        }
        animalImage.setImageResource(images[i]);
        i--;

    }

    public void NextBtnHandler(View view) {
        title.setText("");
        if(i==images.length || i==-1) {
            i=0;
        }
        animalImage.setImageResource(images[i]);
        i++;
    }
}