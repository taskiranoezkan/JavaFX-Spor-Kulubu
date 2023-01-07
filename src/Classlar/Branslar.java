package Classlar;

public class Branslar {
	int id;
	String brans_adi,ayrilan_tutar,tarih;

	public Branslar(){
		
	}
	public Branslar(int id,String brans_adi,String ayrilan_tutar,String tarih) {
		super();
		this.id=id;
		this.brans_adi=brans_adi;
		this.ayrilan_tutar=ayrilan_tutar;
		this.tarih=tarih;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrans_adi() {
		return brans_adi;
	}
	public void setBrans_adi(String brans_adi) {
		this.brans_adi = brans_adi;
	}
	public String getAyrilan_tutar() {
		return ayrilan_tutar;
	}
	public void setAyrilan_tutar(String ayrilan_tutar) {
		this.ayrilan_tutar = ayrilan_tutar;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
}
