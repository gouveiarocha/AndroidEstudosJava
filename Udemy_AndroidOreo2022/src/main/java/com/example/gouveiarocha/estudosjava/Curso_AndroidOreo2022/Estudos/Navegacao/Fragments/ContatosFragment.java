package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Navegacao.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gouveiarocha.estudosjava.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatosFragment extends Fragment {


    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estudos_contatos, container, false);
    }

}
