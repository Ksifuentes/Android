package mx.com.gm.formulariosimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        //Recuperamos la etiqueta del resultado y la modificamos desde este código Java
        TextView resultado = (TextView)findViewById(R.id.textViewResultado);
        resultado.setText("Aquí se verá el resultado");
        
        //Asociamos el evento onclick al botón del usuario
        Button botonUsuario = (Button) findViewById(R.id.buttonEnviar);
        botonUsuario.setOnClickListener( botonListener );
    }

	private OnClickListener botonListener = new OnClickListener(){
		
		public void onClick(android.view.View v) {
		
			//Recuperamos el valor de la caja de texto
	        final EditText usuario = (EditText) findViewById(R.id.editTextUsuario);
	        String valorUsuario = usuario.getText().toString();
	        
	        //Establecemos el valor recien capturado
	        TextView resultado = (TextView)findViewById(R.id.textViewResultado);
	        resultado.setText( valorUsuario );
		};
	};

}