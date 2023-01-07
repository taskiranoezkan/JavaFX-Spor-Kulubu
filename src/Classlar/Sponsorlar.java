package Classlar;

public class Sponsorlar {
	int id;
	String sponsor_adi,destek_oldugu_brans,gelir_beklentisi,tarih;
	
	public Sponsorlar(){
		
	}
	
	public Sponsorlar(int id,String sponsor_adi,String destek_oldugu_brans,String gelir_beklentisi,String tarih){
		super();
		this.id=id;
		this.sponsor_adi=sponsor_adi;
		this.destek_oldugu_brans=destek_oldugu_brans;
		this.gelir_beklentisi=gelir_beklentisi;
		this.tarih=tarih;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSponsor_adi() {
		return sponsor_adi;
	}

	public void setSponsor_adi(String sponsor_adi) {
		this.sponsor_adi = sponsor_adi;
	}

	public String getDestek_oldugu_brans() {
		return destek_oldugu_brans;
	}

	public void setDestek_oldugu_brans(String destek_oldugu_brans) {
		this.destek_oldugu_brans = destek_oldugu_brans;
	}

	public String getGelir_beklentisi() {
		return gelir_beklentisi;
	}

	public void setGelir_beklentisi(String gelir_beklentisi) {
		this.gelir_beklentisi = gelir_beklentisi;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

}
