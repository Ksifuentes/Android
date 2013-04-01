package mx.com.gm.ejemplowidget;

import mx.com.gm.ejemplowidget.R;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class MainActivity extends AppWidgetProvider {

	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		for (int i = 0; i < appWidgetIds.length; i++) {
			int appWidgetId = appWidgetIds[i];
			
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://icursos.net"));
			PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
			
			RemoteViews vistas = new RemoteViews(context.getPackageName(), R.layout.activity_main);
			vistas.setOnClickPendingIntent(R.id.botonAbrirNavegador, pendingIntent);
			
			appWidgetManager.updateAppWidget(appWidgetId, vistas);
			
		}
	}
	
}
