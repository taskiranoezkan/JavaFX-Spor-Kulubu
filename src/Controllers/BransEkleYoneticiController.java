package Controllers;

import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Classlar.Branslar;
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

public class BransEkleYoneticiController {
	
	public BransEkleYoneticiController() {
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
    private TableColumn<Branslar, String> kol_ayrilantutar;

    @FXML
    private TableColumn<Branslar, String> kol_bransadi;

    @FXML
    private TableColumn<Branslar, Integer> kol_id;

    @FXML
    private TableColumn<Branslar, String> kol_tarih;

    @FXML
    private TableView<Branslar> tablebransekle;

    @FXML
    private TextField txtayrilantutar;
    
    @FXML
    private TextField txtbransadi;

    @FXML
    private TextField txttarih;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void tablebransekle_c(MouseEvent event) {
    	
    	Branslar brans =new Branslar();
    	brans=(Branslar) tablebransekle.getItems().get(tablebransekle.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(brans.getId()));
    	txtbransadi.setText(brans.getBrans_adi());
    	txtayrilantutar.setText(brans.getAyrilan_tutar());
    	txttarih.setText(brans.getTarih());

    }
    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into branslar Set brans_adi=?,ayrilan_tutar=?,tarih=? ";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtayrilantutar.getText());
    		sorgula.setString(3, txttarih.getText());
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbransadi.setText("");
    	txtayrilantutar.setText("");
    	txttarih.setText("");
    	
    	BranslariGetir(tablebransekle);
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {
    	sql="update branslar set brans_adi=?,ayrilan_tutar=?,tarih=? where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbransadi.getText());
    		sorgula.setString(2, txtayrilantutar.getText());
    		sorgula.setString(3, txttarih.getText());
    		sorgula.setString(4, lblid.getText());
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbransadi.setText("");
    	txtayrilantutar.setText("");
    	txttarih.setText("");
    	
    	BranslariGetir(tablebransekle);
    }

    @FXML
    void btnsil_c(ActionEvent event) {
    	sql="delete from branslar where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1,lblid.getText());
    		sorgula.execute();
		} catch (Exception e) {
		}
    	txtbransadi.setText("");
    	txtayrilantutar.setText("");
    	txttarih.setText("");
    	
    	BranslariGetir(tablebransekle);
    	
    }
    public void BranslariGetir(TableView<Branslar>table) {
    	sql="Select * from branslar";
    	ObservableList<Branslar> bransdegerleri=FXCollections.observableArrayList();
    	try {
    		sorgula=conn.prepareStatement(sql);
    		ResultSet getirilen=sorgula.executeQuery();
    		
    		while(getirilen.next()) {
    			bransdegerleri.add(new Branslar(getirilen.getInt("id"),
    					getirilen.getString("brans_adi"),
    					getirilen.getString("ayrilan_tutar"),
    					getirilen.getString("tarih")));
    		}
    		kol_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		kol_bransadi.setCellValueFactory(new PropertyValueFactory<>("brans_adi"));
    		kol_ayrilantutar.setCellValueFactory(new PropertyValueFactory<>("ayrilan_tutar"));
    		kol_tarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
    		
    		tablebransekle.setItems(bransdegerleri);
			
		} catch (Exception e) {		
		}	
    }
   

    @FXML
    void initialize() {
    	
    	BranslariGetir(tablebransekle);
    }

}
