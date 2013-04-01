package mx.com.gm.manejomapas;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity implements LocationListener{

	MapController controlador;
	MapView mapa;
	GeoPoint p;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MapView mapa = (MapView) findViewById(R.id.mapa);
        mapa.setBuiltInZoomControls(true);
        
        controlador = mapa.getController();
        
        LocationManager manejador = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        
        manejador.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

	public void onLocationChanged(Location location) {
		Log.d("CAMBIO UBICACION", "Cambio" + location.toString());
		GeoPoint p = new GeoPoint((int)(location.getLongitude() * 1E6),(int)(location.getLatitude() * 1E6));
		controlador.animateTo(p);
	}

	public void onProviderDisabled(String provider) {}

	public void onProviderEnabled(String provider) {}

	public void onStatusChanged(String provider, int status, Bundle extras) {}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}
