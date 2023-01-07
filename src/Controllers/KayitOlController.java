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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

public class KayitOlController {
	
	public KayitOlController(){
		conn=BaglanVeriTabani.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchororta;

    @FXML
    private Button btnkayitol;

    @FXML
    private Button girisedon;

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtkullaniciadi;

    @FXML
    private TextField txtsifre;

    @FXML
    private TextField txtsoyisim;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btnkayitol_c(ActionEvent event) {
    	sql="Insert Into login Set isim=?,soyisim=?,kullanici_adi=?,sifre=?";
    	try {
        	TextInputDialog dialog=new TextInputDialog("");
        	dialog.setTitle("İSTE");
        	dialog.setHeaderText("Bilgilendirme Mesajı");
        	dialog.setContentText("Kulübümüzün Kuruluş Yılı Nedir?");
        	
        	Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("iSTE");
        	alert.setHeaderText("Bilgilendirme Measjı");
        	alert.setContentText("");
        	
        	if(txtisim.getText().isEmpty()||txtsifre.getText().isEmpty()||txtkullaniciadi.getText().isEmpty()||txtsoyisim.getText().isEmpty()) {
        		alert.setContentText("Kayıt Bilgileri Boş Bırakılamaz");		
        	}
        	else {
        			Optional<String> sonuc=dialog.showAndWait();
        			if(sonuc.get().equals("1999")) {
        				alert.setContentText("Kayıt Başarılı");
        				
        	    		sorgula=conn.prepareStatement(sql);
        	    		sorgula.setString(1, txtisim.getText().trim());
        	    		sorgula.setString(2, txtsoyisim.getText().trim());
        	    		sorgula.setString(3, txtkullaniciadi.getText().trim());
        	    		sorgula.setString(4, txtsifre.getText().trim());
        	    		
        	    		sorgula.executeUpdate();
        				
        		    	txtisim.setText("");
        		    	txtsoyisim.setText("");
        		    	txtkullaniciadi.setText("");
        		    	txtsifre.setText("");
        			}
        			else {
        				alert.setContentText("Yanıldınız");
        			}
        	}
        	alert.showAndWait();
		} catch (Exception e) {
			
		}
    }

    @FXML
    void girisedon_c(ActionEvent event) {
        try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/Giris.fxml"));
        	anchororta.getChildren().setAll(pane1);
		} catch (Exception e) {
		}
    }

    @FXML
    void initialize() {
      
    }
}

