package mx.com.gm.preferenciascompartidas;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editTextPreferencia;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editTextPreferencia = (EditText) findViewById(R.id.editTextPreferencia);
        
        SharedPreferences preferencias = getSharedPreferences("PREFERENCIAS",Context.MODE_PRIVATE);
        editTextPreferencia.setText( preferencias.getString("llave", ""));
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	SharedPreferences preferencias = getSharedPreferences("PREFERENCIAS", 0);
    	SharedPreferences.Editor editor = preferencias.edit();
    	editor.putString("llave", editTextPreferencia.getText().toString());
    	editor.commit();
    }
}
