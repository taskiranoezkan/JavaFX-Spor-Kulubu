package Classlar;

public class Oyuncular {
	int id;
	String brans_adi,oyuncu_adsoyad,yas,cinsiyet,mevki,tarih;
	
	public Oyuncular(){
		
	}
	
	public Oyuncular(int id,String brans_adi,String oyuncu_adsoyad,String yas,String cinsiyet,String mevki,String tarih){
		super();
		this.id=id;
		this.brans_adi=brans_adi;
		this.oyuncu_adsoyad=oyuncu_adsoyad;
		this.yas=yas;
		this.cinsiyet=cinsiyet;
		this.mevki=mevki;
		this.tarih=tarih;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
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

	public String getOyuncu_adsoyad() {
		return oyuncu_adsoyad;
	}

	public void setOyuncu_adsoyad(String oyuncu_adsoyad) {
		this.oyuncu_adsoyad = oyuncu_adsoyad;
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

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
}
