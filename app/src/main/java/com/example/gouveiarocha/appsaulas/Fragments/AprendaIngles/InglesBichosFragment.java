package com.example.gouveiarocha.appsaulas.Fragments.AprendaIngles;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gouveiarocha.appsaulas.R;

public class InglesBichosFragment extends Fragment implements View.OnClickListener {

    private ImageView imgCao, imgGato, imgLeao, imgMacaco, imgOvelha, imgVaca;
    private MediaPlayer mediaPlayer;


    public InglesBichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingles_bichos, container, false);

        //REF COMPONENTES
        imgCao = view.findViewById(R.id.img_ai_cao);
        imgGato = view.findViewById(R.id.img_ai_gato);
        imgLeao = view.findViewById(R.id.img_ai_leao);
        imgMacaco = view.findViewById(R.id.img_ai_macaco);
        imgOvelha = view.findViewById(R.id.img_ai_ovelha);
        imgVaca = view.findViewById(R.id.img_ai_vaca);

        //EVENTOS DE CLIQUE
        imgCao.setOnClickListener(this);
        imgGato.setOnClickListener(this);
        imgLeao.setOnClickListener(this);
        imgMacaco.setOnClickListener(this);
        imgOvelha.setOnClickListener(this);
        imgVaca.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_ai_cao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_dog);
                tocarSom();
                break;
            case R.id.img_ai_gato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_cat);
                tocarSom();
                break;
            case R.id.img_ai_leao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_lion);
                tocarSom();
                break;
            case R.id.img_ai_macaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_monkey);
                tocarSom();
                break;
            case R.id.img_ai_ovelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_sheep);
                tocarSom();
                break;
            case R.id.img_ai_vaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
