package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import VeriTabaniBaglan.BaglanVeriTabani;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BilgiDuzenleKullaniciController {
	
	public BilgiDuzenleKullaniciController(){
		conn=BaglanVeriTabani.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnguncelle;

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtkuladi;

    @FXML
    private TextField txtsifre;

    @FXML
    private TextField txtsoyisim;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;
    String sql1;

    @FXML
    void btnguncelle_c(ActionEvent event) {  	
    	sql="update login Set isim=?,soyisim=?,kullanici_adi=?,sifre=?";
    	try {
        	if(btnguncelle.getOnMouseClicked()!=btnguncelle) {
        		
        		Alert alert=new Alert(AlertType.WARNING);
            	alert.setTitle("EAGLES");
            	alert.setHeaderText("Uyarý Mesajý");
            	alert.setContentText("Güncelleme Yapýlsýn mý?");
            	ButtonType buton1=new ButtonType("Evet");
            	ButtonType buton2=new ButtonType("iptal");
            	alert.getButtonTypes().setAll(buton1,buton2);
            	Optional<ButtonType> ekle=alert.showAndWait();
            	
            	if(ekle.get()==buton1) {
            		sorgula=conn.prepareStatement(sql);
            		sorgula.setString(1, txtisim.getText());
            		sorgula.setString(2, txtsoyisim.getText());
            		sorgula.setString(3, txtkuladi.getText());
            		sorgula.setString(4, txtsifre.getText());
            		
            		sorgula.executeUpdate();
            		
            		txtisim.setText("");
            		txtsoyisim.setText("");
            		txtkuladi.setText("");
            		txtsifre.setText("");
            	}
            	else if(ekle.get()==buton2) {
            		alert.close();
            	}		
        	}
		} catch (Exception e) {		
		}

    }

    @FXML
    void initialize() {
    	

    }

}
