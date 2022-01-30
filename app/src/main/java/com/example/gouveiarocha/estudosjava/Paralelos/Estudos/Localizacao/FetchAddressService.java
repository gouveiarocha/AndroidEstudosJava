package com.example.gouveiarocha.estudosjava.Paralelos.Estudos.Localizacao;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FetchAddressService extends IntentService {

    protected ResultReceiver receiver;

    public FetchAddressService() {
        super("fetchAddressService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) return;

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        Location location = intent.getParcelableExtra(Constants.LOCATION_DATA_EXTRA);
        receiver = intent.getParcelableExtra(Constants.RECEIVER);

        List<Address> addresses = null;

        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        } catch (IOException e) {
            Log.e("Teste", "Serviço Indisponivel");
            Toast.makeText(this, "Serviço Indisponivel", Toast.LENGTH_SHORT).show();
        } catch (IllegalArgumentException e) {
            Log.e("Teste", "Latitude ou Longitude invalida");
            Toast.makeText(this, "Latitude ou Longitude invalida", Toast.LENGTH_SHORT).show();
        }

        if (addresses == null || addresses.isEmpty()) {
            Log.e("Teste", "Nenhum endereço encontrado");
            Toast.makeText(this, "Nenhum endereço encontrado", Toast.LENGTH_SHORT).show();
            deliverResultToReceiver(Constants.FAILURE_RESULT, "Nenhum endereço encontrado");
        } else {
            Address address = addresses.get(0);
            List<String> addressF = new ArrayList<>();
            for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                addressF.add(address.getAddressLine(i));
            }
            deliverResultToReceiver(Constants.SUCCESS_RESULT, TextUtils.join("|", addressF));
        }
    }

    private void deliverResultToReceiver(int resultCode, String message) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.RESULT_DATA_KEY, message);
        receiver.send(resultCode, bundle);
    }
}
