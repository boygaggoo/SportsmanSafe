package com.example.sportsmansafe;

import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class FishingMapActivity extends MapActivity implements OnClickListener {
    
	private TextView fishingMapBackButton,fishingMapLocationButton,fishingMapSearchButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fishing_map);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    		
        fishingMapBackButton         = (TextView)findViewById(R.id.fishingMapBackButton);
        fishingMapLocationButton     = (TextView)findViewById(R.id.fishingMapLocationIcon);
        fishingMapSearchButton       = (TextView)findViewById(R.id.fishingMapSearchIcon);
        
        fishingMapBackButton.setOnClickListener(this);
        fishingMapLocationButton.setOnClickListener(this);
        fishingMapSearchButton.setOnClickListener(this);

		MapView mapView = (MapView)findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setSatellite(true);
		
		MapController mc = mapView.getController();
		double lat = Double.parseDouble("48.85827758964043"); // latitude
		double lon = Double.parseDouble("2.294543981552124"); // longitude
		GeoPoint geoPoint = new GeoPoint((int)(lat * 1E6), (int)(lon * 1E6));
		mc.animateTo(geoPoint);
		mc.setZoom(15);
		mapView.invalidate(); 
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.mark_red);
		AddItemizedOverlay itemizedOverlay = 
		new AddItemizedOverlay(drawable, this);
		         
		         
		OverlayItem overlayitem = new OverlayItem(geoPoint, "Hello", "Sample Overlay item");
		         
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fishing_map, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.fishingMapBackButton:
			startActivity(new Intent(this,MainActivity.class));
			break;
		case R.id.fishingMapLocationIcon:
			Toast.makeText(getApplicationContext(), "Location  Image Clicked", Toast.LENGTH_SHORT)
            .show();
			break;
		case R.id.fishingMapSearchIcon:
			Toast.makeText(getApplicationContext(), "Search  Image Clicked", Toast.LENGTH_SHORT)
            .show();
			break;
		}
	}
	
}
