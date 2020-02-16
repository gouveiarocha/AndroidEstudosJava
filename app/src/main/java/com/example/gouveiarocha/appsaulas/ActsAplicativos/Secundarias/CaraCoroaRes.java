package com.example.gouveiarocha.appsaulas.ActsAplicativos.Secundarias;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gouveiarocha.appsaulas.ActsAplicativos.AppCaraCoroa;
import com.example.gouveiarocha.appsaulas.R;

public class CaraCoroaRes extends AppCompatActivity {

    private ImageView imgRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_coroa_res);

        imgRes = findViewById(R.id.caracoroa_img_res);

        Bundle dados = getIntent().getExtras();
        String res = dados.getString("resultado");
        if(res.equals("cara")){
            imgRes.setImageResource(R.drawable.caracoroa_moeda_cara);
        }else if(res.equals("coroa")){
            imgRes.setImageResource(R.drawable.caracoroa_moeda_coroa);
        }

    }

    public void voltar(View view){
        startActivity(new Intent(getApplicationContext(), AppCaraCoroa.class));
    }

}
