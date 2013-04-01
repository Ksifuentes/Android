package mx.com.gm.ejemplovideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        VideoView video = (VideoView) findViewById(R.id.videoView1);
        //Ruta: /mnt/sdcard/nombreVideo
        video.setVideoPath(Environment.getExternalStorageDirectory().getPath()+ "/video.3gp");
        video.setMediaController(new MediaController(this));
        video.start();
        video.requestFocus();
    }

}
