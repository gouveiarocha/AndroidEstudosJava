package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API.Api.CEPService;
import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API.Model.CEP;
import com.example.gouveiarocha.estudosjava.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequisicoesRetrofit extends AppCompatActivity {

    private TextView txtResultado;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisicoes_retrofit);

        txtResultado = findViewById(R.id.txt_req_retrofit_res);

        //Configuração Retrofit.
        retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")               //url
                .addConverterFactory(GsonConverterFactory.create()) //conversor
                .build();

    }

    public void recuperar(View view) {
        recuperarCEPRetrofit();
    }

    private void recuperarCEPRetrofit() {
        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCEP("02968150");
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if (response.isSuccessful()) {
                    CEP cep = response.body();
                    //txtResultado.setText(cep.getLogradouro() + ", " + cep.getBairro());
                    txtResultado.setText(cep.toString());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });

    }

}
