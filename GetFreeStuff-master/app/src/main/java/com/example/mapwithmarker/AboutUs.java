package com.example.mapwithmarker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class AboutUs extends AppCompatActivity {

public Button play;
public Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets up the aboutUs activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        play = (Button) findViewById(R.id.playButton);
        proceed = (Button) findViewById(R.id.playButton);


    }

    public void onProceedClick(View v) {
        {
            Intent registerBtn = new Intent(AboutUs.this, MapsMarkerActivity.class);
            startActivity(registerBtn);
        }
    }

    public void onPlayButtonClick(View v) {
        //start videoView fragment on button press
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.free4u);
        videoview.setVideoURI(uri);
        videoview.start();


    }
}









