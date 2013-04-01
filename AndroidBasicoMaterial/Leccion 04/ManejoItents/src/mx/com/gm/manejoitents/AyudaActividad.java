package mx.com.gm.manejoitents;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AyudaActividad extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_actividad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ayuda_actividad, menu);
        return true;
    }
}
