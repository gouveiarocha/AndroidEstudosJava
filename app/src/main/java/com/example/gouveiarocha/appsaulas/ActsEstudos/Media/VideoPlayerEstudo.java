package com.example.gouveiarocha.appsaulas.ActsEstudos.Media;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gouveiarocha.appsaulas.R;

public class VideoPlayerEstudo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_estudo);
    }

    public void executarVideo(View view){
        startActivity(new Intent(this, VideoPlayerEstudo2.class));
    }

}
