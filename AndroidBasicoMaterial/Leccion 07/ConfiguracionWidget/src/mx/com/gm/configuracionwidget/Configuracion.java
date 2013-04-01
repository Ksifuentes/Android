package mx.com.gm.configuracionwidget;

import mx.com.gm.configuracionwidget.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class Configuracion extends Activity {

	private Configuracion contexto;
	private int widgetId;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        
        contexto = this;
        
        setResult(RESULT_CANCELED);
        
        Bundle extras = getIntent().getExtras();
        if(extras != null){
        	widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        
        final AppWidgetManager widgetManager = AppWidgetManager.getInstance(contexto);
        final RemoteViews views = new RemoteViews(contexto.getPackageName(), R.layout.activity_main);
        
        final EditText editText = (EditText) findViewById(R.id.editTextURL);
        Button boton = (Button) findViewById(R.id.botonCrearWidget);
        boton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
				PendingIntent pendingIntent = PendingIntent.getActivity(contexto, 0, intent, 0);
				views.setOnClickPendingIntent(R.id.botonAbrirNavegador, pendingIntent);
				widgetManager.updateAppWidget(widgetId, views);
				
				Intent resultadoIntent = new Intent();
				resultadoIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
				setResult(RESULT_OK, resultadoIntent);
				finish();
				
				
			}
		});
    }

   
}
