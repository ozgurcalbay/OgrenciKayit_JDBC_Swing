package com.jdbc.types;

public class DONEM {

	
	private int ID;
	private String DONEM_ADI;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDONEM_ADI() {
		return DONEM_ADI;
	}
	public void setDONEM_ADI(String dONEM_ADI) {
		DONEM_ADI = dONEM_ADI;
	}
	@Override
	public String toString() {
		return "DONEM [ID=" + ID + ", DONEM_ADI=" + DONEM_ADI + "]";
	}
	
	
}
