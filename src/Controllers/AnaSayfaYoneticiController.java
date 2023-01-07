package Controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class AnaSayfaYoneticiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorortayonetici;

    @FXML
    private AnchorPane anchorsolyonetici;

    @FXML
    private Button btnanasayfayonetici;

    @FXML
    private Button btnayarlaryonetici;

    @FXML
    private Button btncikisyonetici;

    @FXML
    private Button btnekleyonetici;

    @FXML
    void btnanasayfayonetici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/AnaEkranYonetici.fxml"));
        	anchorortayonetici.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}	
    }

    @FXML
    void btnayarlaryonetici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/BilgiDuzenleYonetici.fxml"));
        	anchorortayonetici.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}
    }

    @FXML
    void btncikisyonetici_c(ActionEvent event) {
    	if(btncikisyonetici.getOnMouseClicked()!=btncikisyonetici) {
    		
    		Alert alert=new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("EAGLES");
        	alert.setHeaderText("Uyarý Mesajý");
        	alert.setContentText("Çýkýþ Yapýlsýn Mý?");
        	ButtonType buton1=new ButtonType("Evet");
        	ButtonType buton2=new ButtonType("iptal");
        	alert.getButtonTypes().setAll(buton1,buton2);
        	Optional<ButtonType> ekle=alert.showAndWait();
        	
        	if(ekle.get()==buton1) {
        		System.exit(0);
        	}
        	else if(ekle.get()==buton2) {
        		alert.close();
        	}		
    	}
    }

    @FXML
    void btnekleyonetici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/EkleYonetici.fxml"));
        	anchorortayonetici.getChildren().setAll(pane1);

		} catch (Exception e) {		
		}
    }

    @FXML
    void initialize() {
    	
    }
}
