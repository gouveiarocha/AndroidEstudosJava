package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Componentes;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.gouveiarocha.estudosjava.R;

public class Componentes2 extends AppCompatActivity {

    private Switch switch_teste;
    private ToggleButton tb_teste;
    private TextView txt_switch, txt_tb, txt_sb;
    private ProgressBar pb_horizontal, pb_circular;
    private SeekBar sb_teste;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes2);

        //REF COMPONENTES
        //Switch..
        switch_teste = findViewById(R.id.switch_teste);
        txt_switch = findViewById(R.id.txt_switch);
        //ToggleButton
        tb_teste = findViewById(R.id.tb_teste);
        txt_tb = findViewById(R.id.txt_tb);
        //ProgressBar
        pb_horizontal = findViewById(R.id.pb_horizontal);
        pb_circular = findViewById(R.id.pb_circular);
        //SeekBar
        sb_teste = findViewById(R.id.sb_teste);
        txt_sb = findViewById(R.id.txt_sb);

        ouvinte();

        pb_circular.setVisibility(View.GONE);   //esconder

    }

    public void ouvinte() {
        //Switch...
        switch_teste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    txt_switch.setText("Switch LIGADO");
                } else {
                    txt_switch.setText("Switch DESLIGADO");
                }
            }
        });

        //ToggleButton
        tb_teste.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    txt_tb.setText("ToggleButton LIGADO");
                } else {
                    txt_tb.setText("ToggleButton DESLIGADO");
                }
            }
        });

        //SeekBar
        sb_teste.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //Progredir...
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txt_sb.setText("Progresso: " + i + "/" + seekBar.getMax());
            }

            @Override
            //Ao clicar...
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            //Ao soltar o clique...
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void testarToast(View view) {
        //Padrão
        //Toast.makeText(getApplicationContext(), "TOAST TESTADO COM SUCESSO", Toast.LENGTH_LONG).show();

        //Configurando e Exibindo um toast customizado com uma img...
        ImageView img = new ImageView(getApplicationContext());
        img.setImageResource(android.R.drawable.star_big_on);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(img);
        toast.show();
    }

    public void testarAlertDialog(View view) {
        //Instanciar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Configurar a Dialog...
        builder.setTitle("Titulo da Dialog...");            //titulo...
        builder.setMessage("Mensagem da Dialog...");        //mensagem...
        builder.setCancelable(false);                       //cancelamento...
        builder.setIcon(R.drawable.about_icon_email);       //icone...

        //Configurar ações para as opções
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "CLICOU NO SIM", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "CLICOU NO NÃO", Toast.LENGTH_SHORT).show();
            }
        });

        //Criar e Exibir AlertDialog
        builder.create();
        builder.show();

    }

    public void testarProgressBar(View view) {

        //ProgressBar Horizontal
        progresso = progresso + 1;
        pb_horizontal.setProgress(progresso);

        //ProgressBar Circular
        pb_circular.setVisibility(View.VISIBLE);    //tornar visivel...
        if (progresso == 10) {
            pb_circular.setVisibility(View.GONE);
        }

    }

}
