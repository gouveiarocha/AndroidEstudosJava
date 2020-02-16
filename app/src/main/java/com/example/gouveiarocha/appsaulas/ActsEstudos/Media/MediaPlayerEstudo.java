package com.example.gouveiarocha.appsaulas.ActsEstudos.Media;

import android.content.Context;
import android.media.AudioManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;


import com.example.gouveiarocha.appsaulas.R;

public class MediaPlayerEstudo extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar skbVolume;
    private AudioManager audioManager;
    private RadioButton rdbBach, rdbTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);;

        configurarAudio();
        inicializarSeekBar();

    }

    public void inicializarSeekBar() {
        skbVolume = findViewById(R.id.mp_skb_volume);

        //Configura o audio manager...
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE); //Recupera o serviço de audio do sistema Android.

        //Configura o volume maximo e atual para a seekbar...
        skbVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));   //Recupera volume maximo.
        skbVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)); //Recupera o volume atual.

        //Permite e configura alteração pelo Usuario...
        skbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void configurarAudio(){

        rdbBach = findViewById(R.id.mp_rdb_bach);
        rdbTeste = findViewById(R.id.mp_rdb_teste);

        if (rdbBach.isChecked()) {
            Toast.makeText(this, "Bach", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.bach);
        } else if (rdbTeste.isChecked()) {
            Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(this, R.raw.teste);
        }

    }

    public void executarSom(View view) {
        configurarAudio();
        if (mediaPlayer != null) {          //Verifica se o audio esta configurado...
            if (mediaPlayer.isPlaying()) {  //Verifica se ja esta estocando...
            } else {
                mediaPlayer.start(); //Executa o audio...
            }
        }
    }

    public void pausarSom(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause(); //Pausa o audio...
        } else {
            Toast.makeText(this, "Nenhuma música tocando...", Toast.LENGTH_SHORT).show();
        }
    }

    public void pararSom(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop(); //Para o audio...
            configurarAudio();
        } else {
            Toast.makeText(this, "Nenhuma música tocando...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release(); //Libera os recursos...
            mediaPlayer = null;
        }
    }
}
