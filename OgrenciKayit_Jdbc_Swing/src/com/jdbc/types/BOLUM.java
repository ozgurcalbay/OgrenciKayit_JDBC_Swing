package com.jdbc.types;

public class BOLUM {
	
	private int ID;
	private String BOLUM_ADI;
	private int BOLUM_BASKAN_ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBOLUM_ADI() {
		return BOLUM_ADI;
	}
	public void setBOLUM_ADI(String bOLUM_ADI) {
		BOLUM_ADI = bOLUM_ADI;
	}
	public int getBOLUM_BASKAN_ID() {
		return BOLUM_BASKAN_ID;
	}
	public void setBOLUM_BASKAN_ID(int bOLUM_BASKAN_ID) {
		BOLUM_BASKAN_ID = bOLUM_BASKAN_ID;
	}
	@Override
	public String toString() {
		return ID + " "+ BOLUM_ADI;
	}
	
	

}
