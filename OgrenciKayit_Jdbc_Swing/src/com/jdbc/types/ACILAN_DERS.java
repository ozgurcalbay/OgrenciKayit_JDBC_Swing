package com.jdbc.types;

public class ACILAN_DERS {
	
	
	private int ID;
	private int DERS_ID;
	private int OGRETMEN_ID;
	private int KONTENJAN;
	private int KAYITLI_OGRENCI_SAYISI;
	private int DONEM_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getDERS_ID() {
		return DERS_ID;
	}
	public void setDERS_ID(int dERS_ID) {
		DERS_ID = dERS_ID;
	}
	public int getOGRETMEN_ID() {
		return OGRETMEN_ID;
	}
	public void setOGRETMEN_ID(int oGRETMEN_ID) {
		OGRETMEN_ID = oGRETMEN_ID;
	}
	public int getKONTENJAN() {
		return KONTENJAN;
	}
	public void setKONTENJAN(int kONTENJAN) {
		KONTENJAN = kONTENJAN;
	}
	public int getKAYITLI_OGRENCI_SAYISI() {
		return KAYITLI_OGRENCI_SAYISI;
	}
	public void setKAYITLI_OGRENCI_SAYISI(int kAYITLI_OGRENCI_SAYISI) {
		KAYITLI_OGRENCI_SAYISI = kAYITLI_OGRENCI_SAYISI;
	}
	public int getDONEM_ID() {
		return DONEM_ID;
	}
	public void setDONEM_ID(int dONEM_ID) {
		DONEM_ID = dONEM_ID;
	}
	@Override
	public String toString() {
		return "ACILAN_DERS [ID=" + ID + ", DERS_ID=" + DERS_ID + ", OGRETMEN_ID=" + OGRETMEN_ID + ", KONTENJAN="
				+ KONTENJAN + ", KAYITLI_OGRENCI_SAYISI=" + KAYITLI_OGRENCI_SAYISI + ", DONEM_ID=" + DONEM_ID + "]";
	}
	
	
	
	

}
