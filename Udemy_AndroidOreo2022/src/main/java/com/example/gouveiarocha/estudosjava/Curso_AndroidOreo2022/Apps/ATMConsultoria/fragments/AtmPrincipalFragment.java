package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.ATMConsultoria.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gouveiarocha.estudosjava.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AtmPrincipalFragment extends Fragment {


    public AtmPrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atm_principal, container, false);
    }

}
