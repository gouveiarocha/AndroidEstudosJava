package com.example.notificacoes_temp_udemyandroidoreo2022.api;

import com.example.notificacoes_temp_udemyandroidoreo2022.model.NotificacaoDados;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificacaoService {

    @Headers({
            "Authorization:key=AAAAbf-aeFs:APA91bHV4H1JmxPsB_M3_b0zgn-CUpXdht3Tu-9xcYfA2PiLTmEZyarUTGTTa8IcKzYLnvTM-JxjT_LEJI_LVLiEGkIpF1J5T2fbK29CldidMOXcVedJN4z7ETNSzU3Hoc4Mymqrh1Yf",
            "Content-Type:application/json"
    })
    @POST("send")
    Call<NotificacaoDados> salvaNotificacao(@Body NotificacaoDados notificacaoDados);

}
