package mx.com.gm.dialogoprogreso;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Dialog dialogo = null;

	//Definimos el Handler de Mensajes
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			dialogo.dismiss();
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button botonMostrarDialogo = (Button) findViewById(R.id.botonMostrarDialogo);

		botonMostrarDialogo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				//Se muestra el dialogo de progreso
				dialogo = ProgressDialog.show(MainActivity.this, "Esperando..", "Trabajo en progreso...");
				
				Thread hilo = new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(3000);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						//Se concluye el proceso
						handler.sendEmptyMessage(0);
					}
				});
				//se inicia el proceso en background
				hilo.start();	
			}
		});

	}

}
