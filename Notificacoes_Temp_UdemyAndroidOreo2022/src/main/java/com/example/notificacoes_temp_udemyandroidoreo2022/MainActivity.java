package com.example.notificacoes_temp_udemyandroidoreo2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notificacoes_temp_udemyandroidoreo2022.api.NotificacaoService;
import com.example.notificacoes_temp_udemyandroidoreo2022.model.Notificacao;
import com.example.notificacoes_temp_udemyandroidoreo2022.model.NotificacaoDados;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private String baseUrl;

    private String myToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarToken();

        //notificação por tópico
        //inscrição
        FirebaseMessaging.getInstance().subscribeToTopic("brasil");
        //cancela inscrição
        FirebaseMessaging.getInstance().unsubscribeFromTopic("brasil");

        //notificação com Retrofit
        baseUrl = "https://fcm.googleapis.com/fcm/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    //método para recuperar o token
    public void recuperarToken(){
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                //token
                myToken = instanceIdResult.getToken();
            }
        });
    }

    public void enviarNotificacao(View view){

        //string, vamos testar envio para tópicos e para token
        //String to = "/topics/brasil"; //ex topics
        String to = myToken; //ex token

        //monta objeto notificação
        Notificacao notificacao = new Notificacao("teste", "msg de teste");
        NotificacaoDados notificacaoDados = new NotificacaoDados(to, notificacao);

        //
        NotificacaoService service = retrofit.create(NotificacaoService.class);
        Call<NotificacaoDados> call = service.salvaNotificacao(notificacaoDados);
        call.enqueue(new Callback<NotificacaoDados>() {
            @Override
            public void onResponse(Call<NotificacaoDados> call, Response<NotificacaoDados> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NotificacaoDados> call, Throwable t) {

            }
        });

    }

}