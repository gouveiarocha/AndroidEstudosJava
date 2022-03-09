package com.example.gouveiarocha.estudosjava.Paralelos.Estudos.ActForResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gouveiarocha.estudosjava.R;

import java.io.Serializable;

public class FirstScreen extends AppCompatActivity {

    private EditText edtValue;
    private Button btnSend;
    private TextView textResult;

    private Car car = new Car("Corsa", 220);

    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        edtValue = findViewById(R.id.edt_value);
        btnSend = findViewById(R.id.btn_send);
        textResult = findViewById(R.id.txt_result);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SecondScreen.class);
                intent.putExtra("car", car);
                intent.putExtra("value", edtValue.getText().toString());

                startActivityForResult(intent, REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                textResult.setText(data.getStringExtra("return"));
            }
        }
    }

    static class Car implements Serializable{

        private String name;
        private int maxSpeed;

        public Car() {
        }

        public Car(String name, int maxSpeed) {
            this.name = name;
            this.maxSpeed = maxSpeed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }
    }

}