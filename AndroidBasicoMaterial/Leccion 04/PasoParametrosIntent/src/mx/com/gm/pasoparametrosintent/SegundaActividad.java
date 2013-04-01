package mx.com.gm.pasoparametrosintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActividad extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);
        
        TextView informacion = (TextView) findViewById(R.id.textViewInformacion);
        informacion.setText( getIntent().getExtras().getString("informacion"));
    }

}
