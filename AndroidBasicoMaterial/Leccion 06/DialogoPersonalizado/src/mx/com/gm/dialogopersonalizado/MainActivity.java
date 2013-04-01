package mx.com.gm.dialogopersonalizado;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final private int MOSTRAR_DIALOGO = 0;

	private Dialog dialogo = null;

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

				showDialog(MOSTRAR_DIALOGO);
			}
		});
	}

	protected android.app.Dialog onCreateDialog(int id) {
		switch (id) {
		case MOSTRAR_DIALOGO:
			dialogo = new Dialog(this);
			dialogo.setContentView(R.layout.dialogo_personalizado);
			return dialogo;
		}
		return null;
	}

}
