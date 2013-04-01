package mx.com.gm.listacompras;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ElementoAdaptador extends BaseAdapter{
	
	private Activity actividad;
	private ArrayList<Elemento> elementos;

	public ElementoAdaptador(Activity actividad, ArrayList<Elemento> elementos) {
		this.actividad = actividad;
		this.elementos = elementos;
	}

	public int getCount() {
		return elementos.size();
	}

	public Object getItem(int index) {
		return elementos.get(index);
	}

	public long getItemId(int index) {
		return elementos.get(index).getId();
	}

	public View getView(int posicion, View vistaACambiar, ViewGroup padre) {
		View vista = vistaACambiar;
		//Verificamos si la vista no se ha desplegado
		if(vista == null){
			LayoutInflater inflater = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vista = inflater.inflate(R.layout.lista_elementos_layout, null);
		}
		
		Elemento elemento = elementos.get(posicion);
		
		//Modificamos el contenido del nombre del elemento
		TextView nombre = (TextView) vista.findViewById(R.id.nombre);
		nombre.setText(elemento.getNombre());
		
		//Modificamos el contenido de la imagen del elemento
		ImageView imagen = (ImageView) vista.findViewById(R.id.imagenElemento);
		//Recuperamos el identificador de la imagen
		int recursoImagen = actividad.getResources().getIdentifier("drawable/" + elemento.getImagen(), null, actividad.getPackageName());
		//Colocamos la imagen recuperada segun clase R
		imagen.setImageDrawable(actividad.getResources().getDrawable(recursoImagen));
		
		return vista;
	}
	
	

}
