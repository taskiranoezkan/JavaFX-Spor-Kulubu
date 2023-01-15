package Classlar;

public class Teknikekipler {
	int id;
	String brans_adi,rol,tarih;
	
	public Teknikekipler(){
		
	}
	
	public Teknikekipler(int id,String brans_adi,String rol,String tarih){
		super();
		this.id=id;
		this.brans_adi=brans_adi;
		this.rol=rol;
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}


}
