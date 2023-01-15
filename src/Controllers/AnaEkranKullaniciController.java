package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Ýstatistikler;
import VeriTabaniBaglan.BaglanVeriTabani;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AnaEkranKullaniciController {
	
	public AnaEkranKullaniciController() {
		conn=BaglanVeriTabani.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Ýstatistikler, String> kol_basari;

    @FXML
    private TableColumn<Ýstatistikler, String> kol_brans;

    @FXML
    private TableColumn<Ýstatistikler, Integer> kol_id;

    @FXML
    private TableColumn<Ýstatistikler, String> kol_oyuncu;

    @FXML
    private TableColumn<Ýstatistikler, String> kol_puan;

    @FXML
    private TableColumn<Ýstatistikler, String> kol_sezon;

    @FXML
    private Label lbladres;

    @FXML
    private Label lblbaskan;

    @FXML
    private Label lblbolge;

    @FXML
    private Label lblsehir;

    @FXML
    private Label lblsite;

    @FXML
    private Label lbltelefon;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    private TableView<Ýstatistikler> tableistatistik;

    @FXML
    void tableistatistik_c(MouseEvent event) {

    }
    public void ÝstatistikleriGetir(TableView<Ýstatistikler>table) {
    	sql="Select * from istatistikler";
    	ObservableList<Ýstatistikler> degerler=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			degerler.add(new Ýstatistikler(getirilen.getInt("id"),
    					getirilen.getString("brans"),
    					getirilen.getString("sezon"),
    					getirilen.getString("basari"),
    					getirilen.getString("parlayanoyuncu"),
    					getirilen.getString("puan")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_brans.setCellValueFactory(new PropertyValueFactory<>("brans"));
    		kol_sezon.setCellValueFactory(new PropertyValueFactory<>("sezon"));
    		kol_basari.setCellValueFactory(new PropertyValueFactory<>("basari"));
    		kol_oyuncu.setCellValueFactory(new PropertyValueFactory<>("parlayanoyuncu"));
    		kol_puan.setCellValueFactory(new PropertyValueFactory<>("puan"));
    		
    		
    		
    		tableistatistik.setItems(degerler);
			
		} catch (Exception e) {		
		}
    }
    
    @FXML
    void initialize() {
    	ÝstatistikleriGetir(tableistatistik);

    }

}
