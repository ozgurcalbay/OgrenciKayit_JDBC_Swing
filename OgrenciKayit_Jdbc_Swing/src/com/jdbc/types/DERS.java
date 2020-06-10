package com.jdbc.types;

public class DERS {
	
	private int ID;
	private String DERS_ADI;
	private int KREDI;
	private int ONSART_DERS_ID;
	private int BOLUM_ID;
	private String MUFREDAT;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDERS_ADI() {
		return DERS_ADI;
	}
	public void setDERS_ADI(String dERS_ADI) {
		DERS_ADI = dERS_ADI;
	}
	public int getKREDI() {
		return KREDI;
	}
	public void setKREDI(int kREDI) {
		KREDI = kREDI;
	}
	public int getONSART_DERS_ID() {
		return ONSART_DERS_ID;
	}
	public void setONSART_DERS_ID(int oNSART_DERS_ID) {
		ONSART_DERS_ID = oNSART_DERS_ID;
	}
	public int getBOLUM_ID() {
		return BOLUM_ID;
	}
	public void setBOLUM_ID(int bOLUM_ID) {
		BOLUM_ID = bOLUM_ID;
	}
	public String getMUFREDAT() {
		return MUFREDAT;
	}
	public void setMUFREDAT(String mUFREDAT) {
		MUFREDAT = mUFREDAT;
	}
	@Override
	public String toString() {
		return  DERS_ADI;
	}
	
	
	

}
