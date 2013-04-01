package mx.com.gm.notificacionesmejorado;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@TargetApi(16)
public class MainActivity extends Activity {

	private String textoLargo="Esto es un texto más largo de lo normal " +
			"y por lo tanto lo podemos colocar con un estilo de texto más largo " +
			"con el nuevo sistema de notificaciones de Android";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button boton = (Button) findViewById(R.id.botonNotificacion);

		boton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

				Intent intent = new Intent(MainActivity.this,
						MainActivity.class);
				PendingIntent pIntent = PendingIntent.getActivity(
						MainActivity.this, 0, intent, 0);
				
				Notification.Builder builder = new Notification.Builder(MainActivity.this);
				
				builder.setSmallIcon(R.drawable.ic_launcher)
						.setTicker("Nueva Notification")
						.setWhen(System.currentTimeMillis())
						//.setDefaults(Notification.DEFAULT_SOUND| Notification.DEFAULT_VIBRATE)
						//.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
						//.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
						//.setLights(Color.RED, 0, 1)
						.setContentTitle("Titulo")
						.setContentText("Detalle Notificacion")
						.setContentIntent(pIntent);
						//.setStyle(new Notification.BigTextStyle().bigText(textoLargo)) ;
				
				Notification notificacion = builder.build();
				
				manager.notify(0, notificacion);
			}
		});

		
	}

}
