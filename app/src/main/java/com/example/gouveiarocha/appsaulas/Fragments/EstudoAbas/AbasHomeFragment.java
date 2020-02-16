package com.example.gouveiarocha.appsaulas.Fragments.EstudoAbas;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gouveiarocha.appsaulas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbasHomeFragment extends Fragment {


    public AbasHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abas_home, container, false);
    }

}
