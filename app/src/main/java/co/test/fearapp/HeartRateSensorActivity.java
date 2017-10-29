package co.test.fearapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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

        //Create an imageCounter to help with randomness. Time is for how long each picture has. Iterations is how many pictures there are. curInt creates a random int that
        //hasn't been used yet
        int imageCounter[] = {1,1,1,1,1,1};
        int time = 0; int iterations = 6;
        int curInt = (int) (Math.random() * 6);

        while(iterations > 0) {
            //While the number has already been used, it keeps generating random numbers
            while(imageCounter[curInt] == -1){ curInt = (int) (Math.random() * 6); System.out.println("curInt " + curInt); System.out.println("imageCounter " + imageCounter[curInt]);}

            final ImageClass dynamicCurrent = images[curInt];

            //Every (time) milliseconds, a new picture is shown
            timer.postDelayed(new Runnable() {
                public void run() {
                    currentImage.setImageDrawable(dynamicCurrent.getImage());
                }
            }, time);

            //Iterate time between pictures, make the imageCounter[curInt] -1 so it will be skipped, decrement iterations
            time += 2000;
            imageCounter[curInt] = -1;
            iterations--;

        }
    }
}
