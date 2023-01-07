package Classlar;

public class Ýstatistikler {
	int id;
	String brans,sezon,basari,parlayanoyuncu,puan;
 public Ýstatistikler() {
	 
 }
 public Ýstatistikler(int id,String brans,String sezon,String basari,String parlayanoyuncu,String puan) {
	 super();
	 this.id=id;
	 this.brans=brans;
	 this.sezon=sezon;
	 this.basari=basari;
	 this.parlayanoyuncu=parlayanoyuncu;
	 this.puan=puan;
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBrans() {
	return brans;
}
public void setBrans(String brans) {
	this.brans = brans;
}
public String getSezon() {
	return sezon;
}
public void setSezon(String sezon) {
	this.sezon = sezon;
}
public String getBasari() {
	return basari;
}
public void setBasari(String basari) {
	this.basari = basari;
}
public String getParlayanoyuncu() {
	return parlayanoyuncu;
}
public void setParlayanoyuncu(String parlayanoyuncu) {
	this.parlayanoyuncu = parlayanoyuncu;
}
public String getPuan() {
	return puan;
}
public void setPuan(String puan) {
	this.puan = puan;
}
}
