package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class EkleYoneticiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchororta;

    @FXML
    private Button btnbransekle;

    @FXML
    private Button btnoyuncuekle;

    @FXML
    private Button btnsponsorekle;

    @FXML
    private Button btnteknikekipekle;

    @FXML
    void btnbransekle_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/BransEkleYonetici.fxml"));
        	anchororta.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}
    }

    @FXML
    void btnoyuncuekle_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/OyuncuEkleYonetici.fxml"));
        	anchororta.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}
    }

    @FXML
    void btnsponsorekle_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/SponsorEkleYonetici.fxml"));
        	anchororta.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}
    }

    @FXML
    void btnteknikekipekle_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/TeknikEkipEkleYonetici.fxml"));
        	anchororta.getChildren().setAll(pane1);

		} catch (Exception e) {			
		}
    }

    @FXML
    void initialize() {
    	
    }
}