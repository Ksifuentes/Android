package mx.com.globalmentoring.android.ejemplo;

import mx.com.globalmentoring.android.ejemplo.R;
import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
import android.view.Menu;

public class GlobalMentoringEjemplo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_mentoring_ejemplo);
        //Log.d("Mensaje", "Entrando a la actividad");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_global_mentoring_ejemplo, menu);
        return true;
    }
}

