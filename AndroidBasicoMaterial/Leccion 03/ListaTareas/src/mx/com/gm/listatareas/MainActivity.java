package mx.com.gm.listatareas;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //1. Obtenemos las referencias a los elementos UI
        ListView listViewTarea = (ListView) findViewById(R.id.listViewTarea);
        final EditText editTextTarea = (EditText) findViewById(R.id.editTextTarea);
        
        //2. Creamos un arrayList de tareas, y agregamos algunas tareas
        final ArrayList<String> tareas = new ArrayList<String>();
        tareas.add("Tarea 1");
        tareas.add("Tarea 2");
        
        //3. Creamos el adaptador que enlazara el arreglo con el ListView
        //Utilizamos un layout que ya nos proporciona Android: simple_list_item_1
        final ArrayAdapter<String> adaptador = 
        		new ArrayAdapter(this, android.R.layout.simple_list_item_1, tareas);
        
        //4. Enlazamos el adaptador de datos con el ListView
        listViewTarea.setAdapter(adaptador);
        
        //5. Capturamos el evento Enter para agregar nuevos elementos
        editTextTarea.setOnKeyListener(new OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction() == KeyEvent.ACTION_DOWN){
					if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER || 
					   keyCode == KeyEvent.KEYCODE_ENTER){
						//Agregamos la nueva tarea
						tareas.add(editTextTarea.getText().toString());
						editTextTarea.setText("");
						//Notificamos el cambio en la lista de tareas
						adaptador.notifyDataSetChanged();
						return true;
					}
				}
				return false;
			}
		});
    }

}
