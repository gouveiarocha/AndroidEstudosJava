package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gouveiarocha.estudosjava.R;

import java.util.Random;

public class AppSorteio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_sorteio);
    }

    public void sortear(View view){

        //Elementos
        EditText numSorteioMax = findViewById(R.id.SORTEIO_NUMMAX);
        TextView numSorteioRes = findViewById(R.id.SORTEIO_NUMRES);

        int numMax = Integer.parseInt(numSorteioMax.getText().toString());

        if (numMax > 0){
            int r = new Random().nextInt(numMax + 1);
            numSorteioRes.setText("" + r);
        }else{
            numSorteioRes.setText("Escolha um número Máximo...");
        }

    }

}
