package mx.com.gm.listacompras;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //1. Recuperamos el ListView
        ListView viewLista = (ListView) findViewById(R.id.listViewElementos);
        
        //2. Obtenemos los elementos de la lista
        final ArrayList<Elemento> elementos = getElementos();
        
        //3. Iniciamos el adaptador, el cual llamará
        //
        ElementoAdaptador adaptador = new ElementoAdaptador(this, elementos);
        
        //4. Asociamos el adaptador a la vista
        viewLista.setAdapter( adaptador );
        
        //5. Registramos el evento OnItemClick
        viewLista.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> padre, View vista, int posicion,
					long id) {
				
				//Recuperamos el layout
				Elemento elementoSel = elementos.get(posicion);
				String mensaje = "Posición " + posicion + " - " + elementoSel.getNombre();
				
				//Enviamos una notificación
				Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
			}
		});
    }

    //Estos elementos se pueden obtener de otra fuente, como una BD
    private ArrayList<Elemento> getElementos() {
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		
		elementos.add(new Elemento(1, "Manzana", "manzana"));
		elementos.add(new Elemento(2,"Kiwi","kiwi"));
		elementos.add(new Elemento(3, "Pera", "pera"));
		
		return elementos;
	}

}
