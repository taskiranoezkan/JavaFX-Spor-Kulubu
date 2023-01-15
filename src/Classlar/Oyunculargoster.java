package Classlar;

public class Oyunculargoster {
	int id;
	String oyuncu_adsoyad,brans_adi,yas,mevki;
	
	public Oyunculargoster(){
		
	}
	
	public Oyunculargoster(int id,String oyuncu_adsoyad,String brans_adi,String yas,String mevki){
		super();
		this.id=id;
		this.oyuncu_adsoyad=oyuncu_adsoyad;
		this.brans_adi=brans_adi;
		this.yas=yas;
		this.mevki=mevki;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOyuncu_adsoyad() {
		return oyuncu_adsoyad;
	}

	public void setOyuncu_adsoyad(String oyuncu_adsoyad) {
		this.oyuncu_adsoyad = oyuncu_adsoyad;
	}

	public String getBrans_adi() {
		return brans_adi;
	}

	public void setBrans_adi(String brans_adi) {
		this.brans_adi = brans_adi;
	}

	public String getYas() {
		return yas;
	}

	public void setYas(String yas) {
		this.yas = yas;
	}

	public String getMevki() {
		return mevki;
	}

	public void setMevki(String mevki) {
		this.mevki = mevki;
	}
}

	