package com.example.mapwithmarker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */

public class MapsMarkerActivity extends AppCompatActivity
        implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {

    public static Marker music, food, clothes;
    public static LatLng sfMusic, sfFood, sfClothes;
    public static String musicInfo, foodInfo, clothesInfo;


    public Button button6;
    public TextView infoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        //Map Fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        infoView = (TextView) findViewById(R.id.infoView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.events_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        button6 = (Button) findViewById(R.id.button);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent ABoutBtn = new Intent(MapsMarkerActivity.this, MainActivity.class);
                    startActivity(ABoutBtn);
                }
            }
        });
    }


    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Initialize MAP FRAGMENT
        // Add several markers in San Francisco California
        // and move the map's camera to the same location.
        googleMap.setOnMarkerClickListener(this);
        musicInfo = "Address: 123 Cabbage Street \n Value:$5.00 \n Time: 10 AM";
        foodInfo = "Address: 43 Main Street \n Value:$5.00 \n Time: 1 PM";
        clothesInfo = "Address: 90 Walnut Way \n Value:$4.30 \n Time: 11 AM";
        sfMusic = new LatLng(37.7749, -122.4194);
        music = googleMap.addMarker(new MarkerOptions().position(sfMusic)
                .title("SF Music Fest"));
        sfFood = new LatLng(37.7821, -122.4154);
        food = googleMap.addMarker(new MarkerOptions().position(sfFood)
                .title("SF Food Fest"));
        sfClothes = new LatLng(37.7749, -122.4220);
        clothes = googleMap.addMarker(new MarkerOptions().position(sfClothes)
                .title("SF Clothes Fest"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sfClothes, 13));
    }


    @Override
    public boolean onMarkerClick(Marker marker) {

        // Retrieve the data from the marker.
        if(marker.getTitle().contains("Music")) {
            infoView.setText(musicInfo);
        }
        if(marker.getTitle().contains("Clothes")){
            infoView.setText(clothesInfo);
        }
        if(marker.getTitle().contains("Food")){
            infoView.setText(foodInfo);
        }
        //return true to confirm user's actions
        return true;

    }

}
