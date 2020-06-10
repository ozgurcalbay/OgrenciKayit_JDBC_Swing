package com.jdbc.types;

public class OGRENCI_DONEM_KAYIT {

	private int ID;
	private int OGRENCI_ID;
	private int KAYIT_DURUM;
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

	public int getKAYIT_DURUM() {
		return KAYIT_DURUM;
	}

	public void setKAYIT_DURUM(int kAYIT_DURUM) {
		KAYIT_DURUM = kAYIT_DURUM;
	}

	public int getDONEM_ID() {
		return DONEM_ID;
	}

	public void setDONEM_ID(int dONEM_ID) {
		DONEM_ID = dONEM_ID;
	}

	@Override
	public String toString() {
		return "OGRENCI_DONEM_KAYIT [ID=" + ID + ", OGRENCI_ID=" + OGRENCI_ID + ", KAYIT_DURUM=" + KAYIT_DURUM
				+ ", DONEM_ID=" + DONEM_ID + "]";
	}

}
