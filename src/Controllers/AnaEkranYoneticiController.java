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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AnaEkranYoneticiController {
	
	public AnaEkranYoneticiController() {
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
    private Label lblid;

    @FXML
    private Label lblsiteyonetici;

    @FXML
    private TableView<Ýstatistikler> tableistatistik;

    @FXML
    private TextField txtbasari;

    @FXML
    private TextField txtbrans;

    @FXML
    private TextField txtoyuncu;

    @FXML
    private TextField txtpuan;

    @FXML
    private TextField txtsezon;
    
    Connection conn=null;
    PreparedStatement sorgula=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btnekle_c(ActionEvent event) {
    	sql="Insert Into istatistikler Set brans=?,sezon=?,basari=?,parlayanoyuncu=?,puan=?";
    	try {
     		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbrans.getText());
    		sorgula.setString(2, txtsezon.getText());
    		sorgula.setString(3, txtbasari.getText());
    		sorgula.setString(4, txtoyuncu.getText());
    		sorgula.setString(5, txtpuan.getText());
    	
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbrans.setText("");
    	txtsezon.setText("");
    	txtbasari.setText("");
    	txtoyuncu.setText("");
    	txtpuan.setText("");
    
    	
    	ÝstatistikleriGetir(tableistatistik);
    }

    @FXML
    void btnguncelle_c(ActionEvent event) {
    	sql="update istatistikler Set brans=?,sezon=?,basari=?,parlayanoyuncu=?,puan=? where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1, txtbrans.getText());
    		sorgula.setString(2, txtsezon.getText());
    		sorgula.setString(3, txtbasari.getText());
    		sorgula.setString(4, txtoyuncu.getText());
    		sorgula.setString(5, txtpuan.getText());
    		sorgula.setString(6, lblid.getText());
    		
    		sorgula.executeUpdate();
		} catch (Exception e) {		
		}
    	txtbrans.setText("");
    	txtsezon.setText("");
    	txtbasari.setText("");
    	txtoyuncu.setText("");
    	txtpuan.setText("");
    	
    	ÝstatistikleriGetir(tableistatistik);
    }

    @FXML
    void btnsil_c(ActionEvent event) {
    	sql="delete from istatistikler where id=?";
    	try {
    		sorgula=conn.prepareStatement(sql);
    		sorgula.setString(1,lblid.getText());
    		
    		sorgula.execute();
		} catch (Exception e) {
		}
    	txtbrans.setText("");
    	txtsezon.setText("");
    	txtbasari.setText("");
    	txtoyuncu.setText("");
    	txtpuan.setText("");
    	
    	ÝstatistikleriGetir(tableistatistik);
    }

    @FXML
    void tableistatistik_c(MouseEvent event) {
    	Ýstatistikler istatistik=new Ýstatistikler();
    	istatistik=(Ýstatistikler) tableistatistik.getItems().get(tableistatistik.getSelectionModel().getSelectedIndex());
    	lblid.setText(String.valueOf(istatistik.getId()));
    	txtbrans.setText(istatistik.getBrans());
    	txtsezon.setText(istatistik.getSezon());
    	txtbasari.setText(istatistik.getBasari());
    	txtoyuncu.setText(istatistik.getParlayanoyuncu());
    	txtpuan.setText(istatistik.getPuan());

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
