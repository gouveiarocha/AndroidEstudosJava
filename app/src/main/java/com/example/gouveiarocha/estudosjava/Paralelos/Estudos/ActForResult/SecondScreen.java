package com.example.gouveiarocha.estudosjava.Paralelos.Estudos.ActForResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gouveiarocha.estudosjava.R;


public class SecondScreen extends AppCompatActivity {

    private TextView edtSecondScreen;
    private Button btnBack;

    private FirstScreen.Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        edtSecondScreen = findViewById(R.id.edt_second_screen);
        btnBack = findViewById(R.id.btn_back);

        if (getIntent().getExtras() != null){
            car = (FirstScreen.Car) getIntent().getSerializableExtra("car");
        }

        edtSecondScreen.setText("Carro: " + car.getName() + " - MaxSpeed: " + car.getMaxSpeed());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra("return", ret());
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }

    private String ret() {
        int value = Integer.parseInt(getIntent().getStringExtra("value"));
        car.setMaxSpeed(value * car.getMaxSpeed());
        String ret = "Carro: " + car.getName() + " - MaxValueTurbo: " + car.getMaxSpeed();
        return ret;
    }

}