package mx.com.gm.notificaciones;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button boton = (Button) findViewById(R.id.botonNotificacion);
        
        boton.setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				
				Notification notificacion = new Notification(android.R.drawable.stat_notify_more,"Notificación", System.currentTimeMillis());
			
				Intent intent = new Intent(MainActivity.this, MainActivity.class);
				PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
				notificacion.setLatestEventInfo(MainActivity.this, "Titulo", "Detalles", pIntent);
				manager.notify(0,notificacion);
			}
		});
    }

}
