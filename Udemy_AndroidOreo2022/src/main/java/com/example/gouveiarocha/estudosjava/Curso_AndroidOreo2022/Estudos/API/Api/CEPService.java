package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API.Api;

import com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API.Model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

}
