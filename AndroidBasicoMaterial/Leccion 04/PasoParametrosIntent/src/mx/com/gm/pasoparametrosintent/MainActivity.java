package mx.com.gm.pasoparametrosintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText texto = (EditText) findViewById(R.id.editTextInfo);
        Button boton = (Button) findViewById(R.id.botonEnviar);
        boton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				//Configuramos la llamada a la siguiente actividad al presionarse el botón
				Intent intent = new Intent(MainActivity.this, SegundaActividad.class);
				
				//Enviarmos la información capturada en la caja de texto
				intent.putExtra("informacion", texto.getText().toString());
				
				//Iniciamos la nueva actividad
				startActivity(intent);
			}
		});
    }

}
