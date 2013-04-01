package mx.com.gm.manejodialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	final private int MOSTRAR_DIALOGO = 0;
	
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
    
    protected android.app.Dialog onCreateDialog(int id){
    	switch(id)
    	{
    	case MOSTRAR_DIALOGO:
    		AlertDialog.Builder builder = new Builder(this);
    		return builder.setMessage("Responde")
    				.setNegativeButton("No", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "Contestaste NO", Toast.LENGTH_LONG).show();
							
						}
					})
					.setPositiveButton("Si", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(MainActivity.this, "Contestaste SI", Toast.LENGTH_LONG).show();
						}
					})
					.create();
    				
    	}
		return null;
    }

}
