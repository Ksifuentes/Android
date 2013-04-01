package mx.com.gm.dialogoprogresohorizontal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	ProgressDialog dialog;
	final static int INCREMENTO = 10;
	final static int MAXIMO = 100;

	Handler progressHandler = new Handler() {
	    public void handleMessage(Message msg) {
	        if (dialog.getProgress() >= MAXIMO) {
	            dialog.dismiss();
	        } else {
	            dialog.incrementProgressBy(INCREMENTO);
	        }
	    }
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button boton = (Button) findViewById(R.id.botonMostrarDialogo);
		boton.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {

				dialog = new ProgressDialog(MainActivity.this);
				dialog.setCancelable(true);
				dialog.setMessage("Cargando...");
				//Tipo de barra de progreso 
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				//Iniciamos el valor a cero
				dialog.setProgress(0);

				//Valor maximo
				dialog.setMax(MAXIMO);
				//Desplegar la barra
				dialog.show();

				//Creación del hilo
				Thread hilo = new Thread(new Runnable() {
					public void run() {
						try {
							// Se incrementa mientras no llegue al máximo
							while (dialog.getProgress() <= dialog.getMax()) {
								// espera 5ms 
								Thread.sleep(500);

								//Se activa la actualización de la barra
								progressHandler.sendMessage(progressHandler
										.obtainMessage());
							}
						} catch (java.lang.InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

				//se incia el proceso en background
				hilo.start();

			}
		});
	}

}
