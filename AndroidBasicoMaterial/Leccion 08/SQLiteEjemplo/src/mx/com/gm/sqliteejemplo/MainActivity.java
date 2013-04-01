package mx.com.gm.sqliteejemplo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Creación de Base de datos (sólo si no existe)
        SQLiteDatabase bd = openOrCreateDatabase("MiBD",MODE_PRIVATE , null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS PERSONA(nombre VARCHAR, ape_paterno VARCHAR);");
        
        //Escritura de datos
        String nombre="Juan";
        String apellido = "Perez";
        String sql = "INSERT INTO PERSONA(nombre,ape_paterno) VALUES('" + nombre + "','" + apellido + "') ";
        bd.execSQL(sql);
        
        //Lectura de datos
        Cursor c = bd.rawQuery("SELECT * FROM PERSONA", null);
        c.moveToFirst();
        Log.d("Valor 1",c.getString(c.getColumnIndex("nombre")));
        Log.d("Valor 2",c.getString(c.getColumnIndex("ape_paterno")));
        
        //Cierre base de datos
        bd.close();
    }

}
