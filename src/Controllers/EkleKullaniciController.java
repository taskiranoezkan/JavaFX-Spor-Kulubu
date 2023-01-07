package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Oyuncular;
import Classlar.Oyunculargoster;
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

public class EkleKullaniciController {
	
	public EkleKullaniciController() {
		conn=BaglanVeriTabani.Baglan();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnara;
    
    @FXML
    private Label lblid;
    
    @FXML
    private TableColumn<Oyuncular, String> kol_brans;

    @FXML
    private TableColumn<Oyuncular, String> kol_mevki;

    @FXML
    private TableColumn<Oyuncular, String> kol_oyuncu;

    @FXML
    private TableColumn<Oyuncular, String> kol_yas;

    @FXML
    private TableColumn<Oyuncular, Integer> kol_id;

    @FXML
    private TableView<Oyunculargoster> tableoyuncugoster;

    @FXML
    private TextField txtbrans;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void btnara_c(ActionEvent event) {
    	ara(tableoyuncugoster);
    }
    
    public void ara(TableView<Oyunculargoster>table) {
    	sql="Select * from oyuncular where brans_adi=?";
    	ObservableList<Oyunculargoster> gosterilen=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, String.valueOf(txtbrans.getText()));
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			gosterilen.add(new Oyunculargoster(getirilen.getInt("id"),
    					getirilen.getString("oyuncu_adsoyad"),
    					getirilen.getString("brans_adi"),
    					getirilen.getString("yas"),
    					getirilen.getString("mevki")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_oyuncu.setCellValueFactory(new PropertyValueFactory<>("oyuncu_adsoyad"));
    		kol_brans.setCellValueFactory(new PropertyValueFactory<>("brans_adi"));
    		kol_yas.setCellValueFactory(new PropertyValueFactory<>("yas"));
    		kol_mevki.setCellValueFactory(new PropertyValueFactory<>("mevki"));
    		
    		tableoyuncugoster.setItems(gosterilen);
			
		} catch (Exception e) {	
		}	
    }

    @FXML
    void tableoyuncugoster_c(MouseEvent event) {
    	Oyunculargoster oyuncular=new Oyunculargoster();
    	oyuncular=(Oyunculargoster) tableoyuncugoster.getItems().get(tableoyuncugoster.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(oyuncular.getId())); 	
    }
    
    
    public void OyunculariGetir(TableView<Oyunculargoster>table) {
    	sql="Select * from oyuncular";
    	ObservableList<Oyunculargoster> gosterilen=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			gosterilen.add(new Oyunculargoster(getirilen.getInt("id"),
    					getirilen.getString("oyuncu_adsoyad"),
    					getirilen.getString("brans_adi"),
    					getirilen.getString("yas"),
    					getirilen.getString("mevki")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_oyuncu.setCellValueFactory(new PropertyValueFactory<>("oyuncu_adsoyad"));
    		kol_brans.setCellValueFactory(new PropertyValueFactory<>("brans_adi"));
    		kol_yas.setCellValueFactory(new PropertyValueFactory<>("yas"));
    		kol_mevki.setCellValueFactory(new PropertyValueFactory<>("mevki"));
    		
    		tableoyuncugoster.setItems(gosterilen);
			
		} catch (Exception e) {	
		}	
    }
    @FXML
    void initialize() {
    	OyunculariGetir(tableoyuncugoster);
    }

}
