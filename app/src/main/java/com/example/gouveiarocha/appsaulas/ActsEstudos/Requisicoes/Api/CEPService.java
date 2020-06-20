package com.example.gouveiarocha.appsaulas.ActsEstudos.Requisicoes.Api;

import com.example.gouveiarocha.appsaulas.ActsEstudos.Requisicoes.Model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

}
