package co.test.fearapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class HeartRateSensorActivity extends AppCompatActivity {

    ImageView currentImage;
    Handler timer;
    boolean isWaiting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_sensor);

        //Initialization
        String bug = "Bug"; String ghost = "Ghost"; String reptile = "Reptile";
        currentImage = (ImageView) findViewById(R.id.image);
        timer = new Handler();

        //Creates an array of images, then sets each images with its corresponding topic
        ImageClass[] images = new ImageClass[6];
        images[0] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.bug1), bug);
        images[1] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.bug2), bug);
        images[2] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.figure1), ghost);
        images[3] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.figure2), ghost);
        images[4] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.reptile1), reptile);
        images[5] = new ImageClass(ContextCompat.getDrawable(this, R.drawable.reptile2), reptile);

        int imageCounter[] = new int[6];
        int curInt;

        while(imageCounter.length > 0){
            curInt = (int) Math.random() * imageCounter.length;
            

            if(curInt != imageCounter.length - 1) images[curInt] = images[imageCounter.length - 1];
            int[] newImageCounter = new int[imageCounter.length - 1];
            for(int counter = 0; counter < imageCounter.length - 2; counter++){ newImageCounter[counter] = imageCounter[counter];}
            newImageCounter = imageCounter;
        }
        currentImage.setImageDrawable(images[5].getImage());
        final ImageClass cur = images[3];
        timer.postDelayed(new Runnable() {
            public void run() {
                currentImage.setImageDrawable(cur.getImage());
            }
        }, 2000);
    }
}
