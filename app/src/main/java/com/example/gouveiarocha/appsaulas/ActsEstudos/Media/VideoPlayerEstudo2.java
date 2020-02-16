package com.example.gouveiarocha.appsaulas.ActsEstudos.Media;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gouveiarocha.appsaulas.R;

public class VideoPlayerEstudo2 extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_estudo2);

        videoView = findViewById(R.id.vp_video);

        //Esconde a statusBar e barra de navegação(FULLSCREEN)
        View decorView = getWindow().getDecorView(); //Essa linha de codigo permite manipulação dos componentes de tela.
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //Seta para FULL SCREEN, é possivel utilizar mais de um usando o pipe(|)

        //Esconde a ActionBar
        getSupportActionBar().hide();

        //Executa o video
        videoView.setMediaController(new MediaController(this)); //Define os controladores do video
        //videoView.setVideoURI(); //Seta um video a partir de uma URL, como o youtube.
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();

    }
}
