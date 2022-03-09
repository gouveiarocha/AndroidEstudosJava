package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Apps.CaraCoroa;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gouveiarocha.estudosjava.R;

import java.util.Random;

public class AppCaraCoroa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_cara_coroa);
    }

    public void jogar(View view){
        int nRandom = new Random().nextInt(2);
        if( nRandom == 0 ){
            Intent intent = new Intent(getApplicationContext(), CaraCoroaRes.class);
            intent.putExtra("resultado", "cara");
            startActivity(intent);
        }else{
            Intent intent = new Intent(getApplicationContext(), CaraCoroaRes.class);
            intent.putExtra("resultado", "coroa");
            startActivity(intent);
        }

    }

}
