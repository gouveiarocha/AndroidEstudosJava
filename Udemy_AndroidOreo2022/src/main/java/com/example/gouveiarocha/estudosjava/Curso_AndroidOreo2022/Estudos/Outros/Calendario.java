package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Outros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gouveiarocha.estudosjava.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class Calendario extends AppCompatActivity {

    //private CalendarView calendarViewNativo;
    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        /**
        //Calendário Nativo. Este Calendário é limitado.
        calendarViewNativo = findViewById(R.id.calendar_view_nativo);
        calendarViewNativo.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {    //Recuperando a data.
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(Calendario.this, dayOfMonth + "/" + month+1 + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });*/

        //Calendário Importado. https://github.com/prolificinteractive/material-calendarview
        calendarView = findViewById(R.id.calendar_view);


        //Configurações data minima e máxima.
        //calendarView.state().edit()
        //        .setMinimumDate(CalendarDay.from(2018,1,1))
        //        .setMaximumDate(CalendarDay.from(2030,1,1))
        //        .commit();

        //Configurar o titulo dos meses
        CharSequence meses[] = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};
        calendarView.setTitleMonths(meses);

        //Configurar o titulo das semanas
        CharSequence dias[] = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab", "Dom"};
        calendarView.setWeekDayLabels(dias);

        //Recupera a data ao clicar no dia.
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                //Toast.makeText(Calendario.this, "" + date, Toast.LENGTH_SHORT).show();
            }
        });

        //Recupera a data ao clicar no mês.
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                //Toast.makeText(Calendario.this, "" + date, Toast.LENGTH_SHORT).show(); //default data
                Toast.makeText(Calendario.this, date.getMonth() + "/" + date.getYear(), Toast.LENGTH_SHORT).show(); //mes+ano
            }
        });

    }
}
