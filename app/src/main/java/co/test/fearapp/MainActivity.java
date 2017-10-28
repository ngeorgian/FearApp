package co.test.fearapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Changes screen to HeartRateSensorActivity when pressed
    public void onBeginButtonClick(View view) {
        Intent i = new Intent(this, HeartRateSensorActivity.class);
        startActivity(i);
    }
}
