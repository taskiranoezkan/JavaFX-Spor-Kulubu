package Controllers;

import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Oyuncular;
import VeriTabaniBaglan.BaglanVeriTabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class OyuncuEkleYoneticiController {
	
	public OyuncuEkleYoneticiController() {
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
    private TableColumn<Oyuncular, String> kol_bransadi;

    @FXML
    private TableColumn<Oyuncular, Integer> kol_id;

    @FXML
    private TableColumn<Oyuncular, String> kol_mevki;

    @FXML
    private TableColumn<Oyuncular, String> kol_oyuncuadsoyad;

    @FXML
    private TableColumn<Oyuncular, String> kol_tarih;

    @FXML
    private TableColumn<Oyuncular, String> kol_yas;
    
    @FXML
    private TableColumn<Oyuncular, String> kol_cinsiyet;

    @FXML
    private TableView<Oyuncular> tableoyuncuekle;

    @FXML
    private TextField txtbransadi;

    @FXML
    private TextField txtcinsiyet;

    @FXML
    private TextField txtmevki;

    @FXML
    private TextField txtoyuncuadsoyad;
    
    @FXML
    private Label lblid;
    
    @FXML
    private TextField txtoyuncuyas;

    @FXML
    private TextField txttarih;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into oyuncular Set brans_adi=?,oyuncu_adsoyad=?,yas=?,cinsiyet=?,mevki=?,tarih=? ";
    	try {
     		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtoyuncuadsoyad.getText());
    		sorgula.setString(3, txtoyuncuyas.getText());
    		sorgula.setString(4, txtcinsiyet.getText());
    		sorgula.setString(5, txtmevki.getText());
    		sorgula.setString(6, txttarih.getText());
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbransadi.setText("");
    	txtoyuncuadsoyad.setText("");
    	txtoyuncuyas.setText("");
    	txtcinsiyet.setText("");
    	txtmevki.setText("");
    	txttarih.setText("");
    	
    	OyunculariGetir(tableoyuncuekle);
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {
    	sql="update oyuncular Set brans_adi=?,oyuncu_adsoyad=?,yas=?,cinsiyet=?,mevki=?,tarih=? where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtoyuncuadsoyad.getText());
    		sorgula.setString(3, txtoyuncuyas.getText());
    		sorgula.setString(4, txtcinsiyet.getText());
    		sorgula.setString(5, txtmevki.getText());
    		sorgula.setString(6, txttarih.getText());
    		sorgula.setString(7, lblid.getText());
    		
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbransadi.setText("");
    	txtoyuncuadsoyad.setText("");
    	txtoyuncuyas.setText("");
    	txtcinsiyet.setText("");
    	txtmevki.setText("");
    	txttarih.setText("");
    	
    	OyunculariGetir(tableoyuncuekle);
    }

    @FXML
    void btnsil_c(ActionEvent event) {
    	sql="delete from oyuncular where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1,lblid.getText());
    		
    		sorgula.execute();
		} catch (Exception e) {
		}
    	txtbransadi.setText("");
    	txtoyuncuadsoyad.setText("");
    	txtoyuncuyas.setText("");
    	txtcinsiyet.setText("");
    	txtmevki.setText("");
    	txttarih.setText("");
    	
    	OyunculariGetir(tableoyuncuekle);
    }

    @FXML
    void tableoyuncuekle_c(MouseEvent event) {
    	Oyuncular oyuncular=new Oyuncular();
    	oyuncular=(Oyuncular) tableoyuncuekle.getItems().get(tableoyuncuekle.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(oyuncular.getId()));
    	txtbransadi.setText(oyuncular.getBrans_adi());
    	txtoyuncuadsoyad.setText(oyuncular.getOyuncu_adsoyad());
    	txtoyuncuyas.setText(oyuncular.getYas());
    	txtcinsiyet.setText(oyuncular.getCinsiyet());
    	txtmevki.setText(oyuncular.getMevki());
    	txttarih.setText(oyuncular.getTarih());
    }
    
    public void OyunculariGetir(TableView<Oyuncular>table) {
    	sql="Select * from oyuncular";
    	ObservableList<Oyuncular> oyuncudegerleri=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			oyuncudegerleri.add(new Oyuncular(getirilen.getInt("id"),
    					getirilen.getString("brans_adi"),
    					getirilen.getString("oyuncu_adsoyad"),
    					getirilen.getString("yas"),
    					getirilen.getString("cinsiyet"),
    					getirilen.getString("mevki"),
    					getirilen.getString("tarih")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_bransadi.setCellValueFactory(new PropertyValueFactory<>("brans_adi"));
    		kol_oyuncuadsoyad.setCellValueFactory(new PropertyValueFactory<>("oyuncu_adsoyad"));
    		kol_yas.setCellValueFactory(new PropertyValueFactory<>("yas"));
    		kol_cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
    		kol_mevki.setCellValueFactory(new PropertyValueFactory<>("mevki"));
    		kol_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    		
    		tableoyuncuekle.setItems(oyuncudegerleri);
			
		} catch (Exception e) {		
		}		
    }

    @FXML
    void initialize() {  	
    	OyunculariGetir(tableoyuncuekle);
    }
}
