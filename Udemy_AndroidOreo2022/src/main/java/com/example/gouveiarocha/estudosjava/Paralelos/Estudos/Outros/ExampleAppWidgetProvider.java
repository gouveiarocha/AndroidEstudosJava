package com.example.gouveiarocha.estudosjava.Paralelos.Estudos.Outros;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.gouveiarocha.estudosjava.ActivitysPrincipais.MainActivity;
import com.example.gouveiarocha.estudosjava.R;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds){
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_widget);
            views.setOnClickPendingIntent(R.id.example_widget_button, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }

    }
}
