package com.jdbc.types;

public class OGRENCI {
	
	
	private int ID;
	private String ADI;
	private String SOYADI;
	private int OKUL_NO;
	private int BOLUM_ID;
	private int GIRIS_YILI;
	private int DANISMAN_ID;
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
	public int getOKUL_NO() {
		return OKUL_NO;
	}
	public void setOKUL_NO(int oKUL_NO) {
		OKUL_NO = oKUL_NO;
	}
	public int getBOLUM_ID() {
		return BOLUM_ID;
	}
	public void setBOLUM_ID(int bOLUM_ID) {
		BOLUM_ID = bOLUM_ID;
	}
	public int getGIRIS_YILI() {
		return GIRIS_YILI;
	}
	public void setGIRIS_YILI(int gIRIS_YILI) {
		GIRIS_YILI = gIRIS_YILI;
	}
	public int getDANISMAN_ID() {
		return DANISMAN_ID;
	}
	public void setDANISMAN_ID(int dANISMAN_ID) {
		DANISMAN_ID = dANISMAN_ID;
	}
	public Object[] getVeriler() {
		Object[]veriler = {ID,ADI,OKUL_NO,BOLUM_ID,GIRIS_YILI,DANISMAN_ID};
		
		return veriler;
	}
	@Override
	public String toString() {
		return getADI()+" "+getSOYADI();
	}
	
	
	

}
