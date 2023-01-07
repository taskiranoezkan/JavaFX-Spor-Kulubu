package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import VeriTabaniBaglan.BaglanVeriTabani;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class GirisController {
	
	public GirisController() {
		conn=BaglanVeriTabani.Baglan();
	}
	
    @FXML
    private AnchorPane anchororta;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnkayitol;

    @FXML
    private Button btnkullanicigiris;

    @FXML
    private Button btnyetkiligris;

    @FXML
    private TextField txtkullanici;

    @FXML
    private PasswordField txtparola;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;
        
    @FXML
    void btnkayitol_c(ActionEvent event) {
         try {
            	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/KayitOl.fxml"));
            	anchororta.getChildren().setAll(pane1);
    		} catch (Exception e) {
    		}
    }
    
    @FXML
    void btnkullanicigiris_c(ActionEvent event) {
    	sql="select * from login where kullanici_adi=? and sifre=?";
    	try {
			sorgula=conn.prepareStatement(sql);
			sorgula.setString(1, txtkullanici.getText().trim());
			sorgula.setString(2, txtparola.getText().trim());
			ResultSet getirilen=sorgula.executeQuery();
			
			if(!getirilen.next()) {
		    	Alert alert=new Alert(AlertType.WARNING);
		    	alert.setTitle("Uyarı");
		    	alert.setHeaderText("Uyarı");
		    	alert.setContentText("Kullanıcı Adı Veya Parola Hatalı");
		    	alert.showAndWait();
			}
			else {
	    		Stage stage=new Stage();
	        	AnchorPane pane1=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/AnaSayfaKullanici.fxml"));
	        	Scene scene1=new Scene(pane1);
	        	stage.setScene(scene1);
	        	stage.show();
			}
		} catch (Exception e) {		
			System.out.println(e.getMessage().toString());
		}
	}

    @FXML
    void btnyetkiligris_c(ActionEvent event) {
    	sql="select * from yonetici where kullanici_adi=? and sifre=?";
    	try {
			sorgula=conn.prepareStatement(sql);
			sorgula.setString(1, txtkullanici.getText().trim());
			sorgula.setString(2, txtparola.getText().trim());
			ResultSet getirilen=sorgula.executeQuery();
			
			if(!getirilen.next()) {
		    	Alert alert=new Alert(AlertType.WARNING);
		    	alert.setTitle("Uyarı");
		    	alert.setHeaderText("Uyarı");
		    	alert.setContentText("Kullanıcı Adı Veya Parola Hatalı");
		    	alert.showAndWait();
			}
			else {
	    		Stage stage=new Stage();
	        	AnchorPane pane1=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/AnaSayfaYonetici.fxml"));
	        	Scene scene1=new Scene(pane1);
	        	stage.setScene(scene1);
	        	stage.show();
			}
		} catch (Exception e) {			
			System.out.println(e.getMessage().toString());
		}
	}
   
    @FXML
    void initialize() {
    	
    }
}


