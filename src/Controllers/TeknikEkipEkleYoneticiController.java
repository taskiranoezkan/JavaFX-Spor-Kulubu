package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Teknikekipler;
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

public class TeknikEkipEkleYoneticiController {
	
	public TeknikEkipEkleYoneticiController() {
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
    private Label lblid;

    @FXML
    private TableColumn<Teknikekipler, String> kol_bransadi;

    @FXML
    private TableColumn<Teknikekipler, String> kol_id;

    @FXML
    private TableColumn<Teknikekipler, String> kol_rol;

    @FXML
    private TableColumn<Teknikekipler, String> kol_tarih;

    @FXML
    private TableView<Teknikekipler> tableteknikekipekle;

    @FXML
    private TextField txtbransadi;

    @FXML
    private TextField txtrol;

    @FXML
    private TextField txttarih;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into teknikekipler Set brans_adi=?,rol=?,tarih=?";
    	try {
     		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtrol.getText());
    		sorgula.setString(3, txttarih.getText());
    		
    		sorgula.executeUpdate();
		} catch (Exception e) {	
		}
    	txtbransadi.setText("");
    	txtrol.setText("");
    	txttarih.setText("");
   	
    	TeknikekipleriGetir(tableteknikekipekle);
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {
    	sql="update teknikekipler Set brans_adi=?, rol=?, tarih=? where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtrol.getText());
    		sorgula.setString(3, txttarih.getText());
    		sorgula.setString(4, lblid.getText());
    		sorgula.executeUpdate();
    		
		} catch (Exception e) {	
		}
    	txtbransadi.setText("");
    	txtrol.setText("");
    	txttarih.setText("");
    	
    	TeknikekipleriGetir(tableteknikekipekle);
    }
    
    @FXML
    void tableteknikekipekle_c(MouseEvent event) {
    	Teknikekipler teknikekipler=new Teknikekipler();
    	teknikekipler=(Teknikekipler) tableteknikekipekle.getItems().get(tableteknikekipekle.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(teknikekipler.getId()));
    	txtbransadi.setText(teknikekipler.getBrans_adi());
    	txtrol.setText(teknikekipler.getRol());
    	txttarih.setText(teknikekipler.getTarih());
    }

    @FXML
    void btnsil_c(ActionEvent event) {
    	sql="delete from teknikekipler where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1,lblid.getText());
    		sorgula.execute();
		} catch (Exception e) {
		}
    	txtbransadi.setText("");
    	txtrol.setText("");
    	txttarih.setText("");
    	
    	TeknikekipleriGetir(tableteknikekipekle);
    }
    
    public void TeknikekipleriGetir(TableView<Teknikekipler>table) {
    	sql="Select * from teknikekipler";
    	ObservableList<Teknikekipler> teknikekipdegerleri=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			teknikekipdegerleri.add(new Teknikekipler(getirilen.getInt("id"),
    					getirilen.getString("brans_adi"),
    					getirilen.getString("rol"),
    					getirilen.getString("tarih")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_bransadi.setCellValueFactory(new PropertyValueFactory<>("brans_adi"));
    		kol_rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
    		kol_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    		
    		tableteknikekipekle.setItems(teknikekipdegerleri);
			
		} catch (Exception e) {		
		}
    }

    @FXML
    void initialize() {
    	TeknikekipleriGetir(tableteknikekipekle);
    }
}

