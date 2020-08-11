package com.example.gouveiarocha.appsaulas.ActsEstudos.Exclusivos.Localizacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

import com.example.gouveiarocha.appsaulas.Classes.ExcLocalizacao.Constants;
import com.example.gouveiarocha.appsaulas.Classes.ExcLocalizacao.FetchAddressService;
import com.example.gouveiarocha.appsaulas.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Aula exclusiva Tiago Aguiar
 * Link Aulas: https://www.youtube.com/watch?v=-5qrgm13DeI
 */

public class ExcLocalizacaoActivity extends AppCompatActivity {

    FusedLocationProviderClient client;
    AddressResultReceiver resultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao_exc);

        client = LocationServices.getFusedLocationProviderClient(this);
        resultReceiver = new AddressResultReceiver(null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        verificarPlayServices();

        //Método1. Recupera a ultima posição disponivel do usuario.
        client.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            Log.i("Teste1", location.getLatitude() + " " + location.getLongitude());
                            Toast.makeText(ExcLocalizacaoActivity.this, location.getLatitude() + " " + location.getLongitude(), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.i("Teste1", "null");
                            Toast.makeText(ExcLocalizacaoActivity.this, "null", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Teste1", "falha");
                        Toast.makeText(ExcLocalizacaoActivity.this, "Falha: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //Método 2. Permite configurar a localização - escolhendo entre mais ou menos precisão.
        final LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(15 * 1000);         //intervalo que o app vai buscar a localização - em milisegundo - 15 segundos.
        locationRequest.setFastestInterval(5 * 1000);   //intervalo que o app vai buscar a localização, caso houver outro com requisição mais rapida.
        locationRequest.setPriority(locationRequest.PRIORITY_BALANCED_POWER_ACCURACY);  //alta precisão com economia de bateria.
        //locationRequest.setPriority(locationRequest.PRIORITY_HIGH_ACCURACY);          //extrema precisão sem economia de bateria.
        //locationRequest.setPriority(locationRequest.PRIORITY_LOW_POWER);              //baixa precisão com muita economia de bateria.
        //locationRequest.setPriority(locationRequest.PRIORITY_NO_POWER);               //nula precisão sem consumo da bateria.

        //Cria um builder.
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        //Cria um SettingsClient, que permite conferir as configurações de localização requisitadas. Ex: Se vamos utilizar o Wifi para determinar a localização, o SettingsClient nos permite conferir se o Wifi esta ativado.
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(builder.build())
                .addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        //Retorna true, se a rede estiver ativada.
                        Log.i("Teste2", locationSettingsResponse.getLocationSettingsStates().isNetworkLocationPresent() + "");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Em eventos de falha, o codigo abaixo starta um Dialog para o usuario resolver o problema
                        if (e instanceof ResolvableApiException) {
                            try {
                                ResolvableApiException resolvable = (ResolvableApiException) e;
                                resolvable.startResolutionForResult(ExcLocalizacaoActivity.this, 10);
                            } catch (IntentSender.SendIntentException ex) {

                            }
                        }
                    }
                });

        //Listener que fica escutando toda vez que houver um retorno do provider - onde acima determinamos de 15 em 15 segundos.
        final LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    Log.i("Teste3", "local is null");
                    Toast.makeText(ExcLocalizacaoActivity.this, "local is null", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    Log.i("Teste3", location.getLatitude() + "");
                    Toast.makeText(ExcLocalizacaoActivity.this, location.getLatitude() + "", Toast.LENGTH_SHORT).show();
                    if (!Geocoder.isPresent()) {
                        return;
                    }
                    startIntentService(location);
                }
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                Log.i("Teste4", locationAvailability.isLocationAvailable() + "");
            }
        };

        client.requestLocationUpdates(locationRequest, locationCallback, null);

    }

    private class AddressResultReceiver extends ResultReceiver {
        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData == null) return;

            final String addressOutput = resultData.getString(Constants.RESULT_DATA_KEY);

            if (addressOutput != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ExcLocalizacaoActivity.this, addressOutput, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    //Método para verificar se o usuario possui o Google Play Service instalado, atualizado e ativado.
    private void verificarPlayServices() {
        int errorCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        switch (errorCode) {
            //Erro.
            case ConnectionResult.SERVICE_MISSING:                      //não instalado.
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:      //desatualizado.
            case ConnectionResult.SERVICE_DISABLED:                     //desativado.
                Log.d("Teste", "Show Dialog");
                //Mostra Dialog sobre o Problema.
                GoogleApiAvailability.getInstance().getErrorDialog(this, errorCode, 0, new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //Fecha a activity.
                        finish();
                    }
                }).show();
                break;
            //Sucesso.
            case ConnectionResult.SUCCESS:
                Log.d("Teste", "Google Play Services OK!");
                break;
        }
    }

    private void startIntentService(Location location) {
        Intent intent = new Intent(this, FetchAddressService.class);
        intent.putExtra(Constants.RECEIVER, resultReceiver);
        intent.putExtra(Constants.LOCATION_DATA_EXTRA, location);
        startService(intent);
    }
}
