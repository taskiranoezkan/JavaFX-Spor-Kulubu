package Controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

public class AnaSayfaKullaniciController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorortakullanici;

    @FXML
    private AnchorPane anchorsolkullanici;

    @FXML
    private Button btnanasayfakullanici;

    @FXML
    private Button btnayarlarkullanici;

    @FXML
    private Button btncikiskullanici;

    @FXML
    private Button btngosterkullanici;

    @FXML
    void btnanasayfakullanici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/AnaEkranKullanici.fxml"));
        	anchorortakullanici.getChildren().setAll(pane1);
		} catch (Exception e) {			
		}
    }

    @FXML
    void btnayarlarkullanici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/BilgiDuzenleKullanici.fxml"));
        	anchorortakullanici.getChildren().setAll(pane1);
		} catch (Exception e) {			
		}
    }

    @FXML
    void btncikiskullanici_c(ActionEvent event) {
    	if(btncikiskullanici.getOnMouseClicked()!=btncikiskullanici) {
    		
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
    void btngosterkullanici_c(ActionEvent event) {
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/EkleKullanici.fxml"));
        	anchorortakullanici.getChildren().setAll(pane1);

		} catch (Exception e) {			
		}
    }
    
    
    @FXML
    void initialize() {
      
    }
}
