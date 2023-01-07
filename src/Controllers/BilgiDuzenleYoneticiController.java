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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class BilgiDuzenleYoneticiController {
	public BilgiDuzenleYoneticiController(){
		conn=BaglanVeriTabani.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnekle;

    @FXML
    private Button btnguncelle;

    @FXML
    private Label lblid;
    
    @FXML
    private TextField txtadsoyadekle;

    @FXML
    private TextField txtkuladiguncelle;

    @FXML
    private TextField txtkullaniciadiekle;

    @FXML
    private TextField txtsifreekle;

    @FXML
    private TextField txtsifreguncelle;

    @FXML
    private TextField txttelefonekle;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;
    String sql1;
    
    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into yonetici Set ad_soyad=?,telefon=?,kullanici_adi=?,sifre=?";
    	sql1="select * from yonetici where kullanici_adi=?";
    	try {
        	TextInputDialog dialog=new TextInputDialog("Giriniz");
        	dialog.setTitle("EAGLES");
        	dialog.setHeaderText("Bilgilendirme Mesajı");
        	dialog.setContentText("Kulübümüzün Kuruluş Yılı Nedir?");
        	
        	Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("EAGLES");
        	alert.setHeaderText("Bilgilendirme Measjı");
        	alert.setContentText("");
        	
        	if(txtadsoyadekle.getText().isEmpty()||txtkullaniciadiekle.getText().isEmpty()||txtsifreekle.getText().isEmpty()||txttelefonekle.getText().isEmpty()) {
        		alert.setContentText("Boş Geçilmeyecek Alanlar Mevcut");
        		alert.showAndWait();
        	}
        	else {
        		if(txtkullaniciadiekle.getText().contains(sql1)) {
            		alert.setContentText("Bu Kullanıcı Adı Daha Önce Alınmış");
            		alert.showAndWait();
        		}
        		else { 			
            		sorgula=conn.prepareStatement(sql);
            		sorgula.setString(1, txtadsoyadekle.getText().trim());
            		sorgula.setString(2, txttelefonekle.getText().trim());
            		sorgula.setString(3, txtkullaniciadiekle.getText().trim());
            		sorgula.setString(4, txtsifreekle.getText().trim());
            		
            		sorgula.executeUpdate();
            		
                	txtadsoyadekle.setText("");
                	txttelefonekle.setText("");
                	txtkullaniciadiekle.setText("");
                	txtsifreekle.setText("");
                	
        			alert.setContentText("Kayıt Başarılı");
        			alert.showAndWait();
        		}
        	}		
    		
		} catch (Exception e) {		
		}
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {  	
    	sql="update yonetici Set kullanici_adi=?,sifre=?";
    	try {
        	if(btnguncelle.getOnMouseClicked()!=btnguncelle) {
        		
        		Alert alert=new Alert(AlertType.WARNING);
            	alert.setTitle("EAGLES");
            	alert.setHeaderText("Uyarı Mesajı");
            	alert.setContentText("Güncelleme Yapılsın mı?");
            	ButtonType buton1=new ButtonType("Evet");
            	ButtonType buton2=new ButtonType("iptal");
            	alert.getButtonTypes().setAll(buton1,buton2);
            	Optional<ButtonType> ekle=alert.showAndWait();
            	
            	if(ekle.get()==buton1) {
            		sorgula=conn.prepareStatement(sql);
            		sorgula.setString(1, txtkuladiguncelle.getText());
            		sorgula.setString(2, txtsifreguncelle.getText());
            		
            		sorgula.executeUpdate();
            		
                	txtkuladiguncelle.setText("");
                	txtsifreguncelle.setText("");
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


