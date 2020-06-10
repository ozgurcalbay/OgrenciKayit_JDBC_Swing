package com.jdbc.types;

public class OGRENCI_DERS_KAYIT {

	
	private int ID;
	private int OGRENCI_ID;
	private int ACILAN_DERS_ID;
	private int DERS_ID;
	private int NOTU;
	private int OGRENCI_DONEM_KAYIT_ID;
	private int DONEM_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getOGRENCI_ID() {
		return OGRENCI_ID;
	}
	public void setOGRENCI_ID(int oGRENCI_ID) {
		OGRENCI_ID = oGRENCI_ID;
	}
	public int getACILAN_DERS_ID() {
		return ACILAN_DERS_ID;
	}
	public void setACILAN_DERS_ID(int aCILAN_DERS_ID) {
		ACILAN_DERS_ID = aCILAN_DERS_ID;
	}
	public int getDERS_ID() {
		return DERS_ID;
	}
	public void setDERS_ID(int dERS_ID) {
		DERS_ID = dERS_ID;
	}
	public int getNOTU() {
		return NOTU;
	}
	public void setNOTU(int nOTU) {
		NOTU = nOTU;
	}
	public int getOGRENCI_DONEM_KAYIT_ID() {
		return OGRENCI_DONEM_KAYIT_ID;
	}
	public void setOGRENCI_DONEM_KAYIT_ID(int oGRENCI_DONEM_KAYIT_ID) {
		OGRENCI_DONEM_KAYIT_ID = oGRENCI_DONEM_KAYIT_ID;
	}
	public int getDONEM_ID() {
		return DONEM_ID;
	}
	public void setDONEM_ID(int dONEM_ID) {
		DONEM_ID = dONEM_ID;
	}
	@Override
	public String toString() {
		return "OGRENCI_DERS_KAYIT [ID=" + ID + ", OGRENCI_ID=" + OGRENCI_ID + ", ACILAN_DERS_ID=" + ACILAN_DERS_ID
				+ ", DERS_ID=" + DERS_ID + ", NOTU=" + NOTU + ", OGRENCI_DONEM_KAYIT_ID=" + OGRENCI_DONEM_KAYIT_ID
				+ ", DONEM_ID=" + DONEM_ID + "]";
	}
	
	
	
}
