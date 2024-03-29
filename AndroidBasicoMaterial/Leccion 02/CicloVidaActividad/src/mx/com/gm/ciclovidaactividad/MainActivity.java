package mx.com.gm.ciclovidaactividad;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate...");
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.d(TAG,"onStart...");
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	Log.d(TAG,"onResume...");
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.d(TAG,"onPause...");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.d(TAG,"onStop...");
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	Log.d(TAG,"onRestart...");
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Log.d(TAG,"onDestroy...");
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	Log.d(TAG,"onRestoreInstanceState...");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	Log.d(TAG,"onSaveInstanceState...");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
