package magasin.admin;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import javafx.application.Application;
import javafx.fxml.FXML;


import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * @author Zaki
 */
public class AdminMapControl extends Application implements MapComponentInitializedListener {


    @FXML
    private WebView webMap;
    @FXML
    private GoogleMapView mapView;
    private GoogleMap map;


    @Override
    public void mapInitialized() {
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);
    }


    public void initMap() {

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(43.615888, 7.071728))
                .mapType(MapTypeIdEnum.TERRAIN)
                .overviewMapControl(false)
                .panControl(false)
                .mapTypeControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(19)
                .styleString("[{featureType: \"poi\",stylers: [{ visibility: \"off\" }]}]");

        map = mapView.createMap(mapOptions);

        //Add a marker to the map
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position( new LatLong(43.615888, 7.071728) )
                .visible(Boolean.TRUE)
                .title("To Be Or To Have - Cap Sophia");

        Marker marker = new Marker( markerOptions );

        map.addMarker(marker);


    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
