package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Sponsorlar;
import VeriTabaniBaglan.BaglanVeriTabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SponsorEkleYoneticiController {
	
	public SponsorEkleYoneticiController() {
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
    private Button btnsil;

    @FXML
    private TableColumn<Sponsorlar, String> kol_destekoldugubrans;

    @FXML
    private TableColumn<Sponsorlar, String> kol_gelirbeklentisi;

    @FXML
    private TableColumn<Sponsorlar, Integer> kol_id;

    @FXML
    private TableColumn<Sponsorlar, String> kol_sponsoradi;

    @FXML
    private TableColumn<Sponsorlar, String> kol_tarih;

    @FXML
    private Label lblid;

    @FXML
    private TableView<Sponsorlar> tablesponsorekle;

    @FXML
    private TextField txtdestekoldugubrans;

    @FXML
    private TextField txtgelirbeklentisi;

    @FXML
    private TextField txtsponsoradi;

    @FXML
    private TextField txttarih;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into sponsorlar Set sponsor_adi=?,destek_oldugu_brans=?,gelir_beklentisi=?, tarih=?";
    	try {
     		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtsponsoradi.getText());
    		sorgula.setString(2, txtdestekoldugubrans.getText());
    		sorgula.setString(3, txtgelirbeklentisi.getText());
    		sorgula.setString(4, txttarih.getText());
    		
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtsponsoradi.setText("");
    	txtdestekoldugubrans.setText("");
    	txtgelirbeklentisi.setText("");
    	txttarih.setText("");
    	
    	SponsorlariGetir(tablesponsorekle);
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {
    	sql="update sponsorlar Set sponsor_adi=?,destek_oldugu_brans=?,gelir_beklentisi=?, tarih=? where id=?";
    	try {
     		sorgula=conn.prepareStatement(sql);

    		sorgula.setString(1, txtsponsoradi.getText());
    		sorgula.setString(2, txtdestekoldugubrans.getText());
    		sorgula.setString(3, txtgelirbeklentisi.getText());
    		sorgula.setString(4, txttarih.getText());
    		sorgula.setString(5, lblid.getText());
    		
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtsponsoradi.setText("");
    	txtdestekoldugubrans.setText("");
    	txtgelirbeklentisi.setText("");
    	txttarih.setText("");
    	
    	SponsorlariGetir(tablesponsorekle);
    }

    @FXML
    void btnsil_c(ActionEvent event) {
    	sql="delete from sponsorlar where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1,lblid.getText());
    		
    		sorgula.execute();
		} catch (Exception e) {
		}
    	txtsponsoradi.setText("");
    	txtdestekoldugubrans.setText("");
    	txtgelirbeklentisi.setText("");
    	txttarih.setText("");
    	
    	SponsorlariGetir(tablesponsorekle);
    }

    @FXML
    void tablesponsorekle_c(MouseEvent event) {
    	
    	Sponsorlar sponsorlar=new Sponsorlar();
    	sponsorlar=(Sponsorlar) tablesponsorekle.getItems().get(tablesponsorekle.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(sponsorlar.getId()));
    	txtsponsoradi.setText(sponsorlar.getSponsor_adi());
    	txtdestekoldugubrans.setText(sponsorlar.getDestek_oldugu_brans());
    	txtgelirbeklentisi.setText(sponsorlar.getGelir_beklentisi());
    	txttarih.setText(sponsorlar.getTarih());
    }
    
    public void SponsorlariGetir(TableView<Sponsorlar>table) {
    	sql="Select * from sponsorlar";
    	ObservableList<Sponsorlar> sponsordegerleri =FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			sponsordegerleri.add(new Sponsorlar(getirilen.getInt("id"),
    					getirilen.getString("sponsor_adi"),
    					getirilen.getString("destek_oldugu_brans"),
    					getirilen.getString("gelir_beklentisi"),
    					getirilen.getString("tarih")));
    			
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_sponsoradi.setCellValueFactory(new PropertyValueFactory<>("sponsor_adi"));
    		kol_destekoldugubrans.setCellValueFactory(new PropertyValueFactory<>("destek_oldugu_brans"));
    		kol_gelirbeklentisi.setCellValueFactory(new PropertyValueFactory<>("gelir_beklentisi"));
    		kol_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    		
    		tablesponsorekle.setItems(sponsordegerleri);
			
		} catch (Exception e) {
		}
    }

    @FXML
    void initialize() {
    	SponsorlariGetir(tablesponsorekle);
    }
}
