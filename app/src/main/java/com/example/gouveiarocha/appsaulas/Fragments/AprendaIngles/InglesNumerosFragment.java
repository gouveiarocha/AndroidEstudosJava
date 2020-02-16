package com.example.gouveiarocha.appsaulas.Fragments.AprendaIngles;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gouveiarocha.appsaulas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InglesNumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imgUm, imgDois, imgTres, imgQuatro, imgCinco, imgSeis;
    private MediaPlayer mediaPlayer;


    public InglesNumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingles_numeros, container, false);

        //REF COMPONENTES
        imgUm = view.findViewById(R.id.ai_img_um);
        imgDois = view.findViewById(R.id.ai_img_dois);
        imgTres = view.findViewById(R.id.ai_img_tres);
        imgQuatro = view.findViewById(R.id.ai_img_quatro);
        imgCinco = view.findViewById(R.id.ai_img_cinco);
        imgSeis = view.findViewById(R.id.ai_img_seis);

        //EVENTO DE CLIQUE
        imgUm.setOnClickListener(this);
        imgDois.setOnClickListener(this);
        imgTres.setOnClickListener(this);
        imgQuatro.setOnClickListener(this);
        imgCinco.setOnClickListener(this);
        imgSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ai_img_um:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_one);
                tocarSom();
                break;
            case R.id.ai_img_dois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_two);
                tocarSom();
                break;
            case R.id.ai_img_tres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_three);
                tocarSom();
                break;
            case R.id.ai_img_quatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_four);
                tocarSom();
                break;
            case R.id.ai_img_cinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_five);
                tocarSom();
                break;
            case R.id.ai_img_seis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ai_six);
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if (mediaPlayer != null){
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
