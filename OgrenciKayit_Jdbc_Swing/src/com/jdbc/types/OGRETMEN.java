package com.jdbc.types;



public class OGRETMEN {

	private int ID;
	private String ADI;
	private String SOYADI;
	private int BOLUM_ID;
	private String UNVAN;
	private int SICIL_NO;
	private String BASLAMA_TARIHI;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getADI() {
		return ADI;
	}

	public void setADI(String aDI) {
		ADI = aDI;
	}

	public String getSOYADI() {
		return SOYADI;
	}

	public void setSOYADI(String sOYADI) {
		SOYADI = sOYADI;
	}

	public int getBOLUM_ID() {
		return BOLUM_ID;
	}

	public void setBOLUM_ID(int bOLUM_ID) {
		BOLUM_ID = bOLUM_ID;
	}

	public String getUNVAN() {
		return UNVAN;
	}

	public void setUNVAN(String uNVAN) {
		UNVAN = uNVAN;
	}

	public int getSICIL_NO() {
		return SICIL_NO;
	}

	public void setSICIL_NO(int sICIL_NO) {
		SICIL_NO = sICIL_NO;
	}

	public String getBASLAMA_TARIHI() {
		return BASLAMA_TARIHI;
	}

	public void setBASLAMA_TARIHI(String date) {
		BASLAMA_TARIHI = date;
	}
	public Object[] getVeriler() {
		Object[]veriler = {ID,ADI,SOYADI,BOLUM_ID,UNVAN,SICIL_NO,BASLAMA_TARIHI};
		
		return veriler;
	}

	@Override
	public String toString() {
		return getADI()+" "+getSOYADI();
	}

}
