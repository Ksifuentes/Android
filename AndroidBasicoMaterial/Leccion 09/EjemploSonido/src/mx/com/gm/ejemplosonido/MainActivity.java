package mx.com.gm.ejemplosonido;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void reproducirSonido(View view){
	   MediaPlayer reproductor = MediaPlayer.create(MainActivity.this, R.raw.sonido);
	   reproductor.start();
   }
}
