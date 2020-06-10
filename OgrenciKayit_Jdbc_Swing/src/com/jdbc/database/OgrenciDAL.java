package com.jdbc.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connectiontool.OjdbcTool;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.DERS;
import com.jdbc.types.OGRENCI;

public class OgrenciDAL extends OjdbcTool implements ICrud<OGRENCI> {

	@Override
	public void Insert(OGRENCI entity) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO OGRENCI (ID, ADI, SOYADI, OKUL_NO, BOLUM_ID, GIRIS_YILI, DANISMAN_ID)"
					+ "VALUES(" + "OGRENCI_SEQ.nextval" + ",'" + entity.getADI() + "','" + entity.getSOYADI() + "',"
					+ entity.getOKUL_NO() + "," + entity.getBOLUM_ID() + "," + entity.getGIRIS_YILI() + ","
					+ entity.getDANISMAN_ID() + ")");
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<OGRENCI> GetAll() {
		List<OGRENCI> ogrenciListesi = new ArrayList<OGRENCI>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From OGRENCI");
			OGRENCI ogrenci;
			while(resultSet.next()) {
				ogrenci = new OGRENCI();
				ogrenci.setID(resultSet.getInt("ID"));
				ogrenci.setADI(resultSet.getString("ADI"));
				ogrenci.setSOYADI(resultSet.getString("SOYADI"));
				ogrenci.setOKUL_NO(resultSet.getInt("OKUL_NO"));
				ogrenci.setBOLUM_ID(resultSet.getInt("BOLUM_ID"));
				ogrenci.setGIRIS_YILI(resultSet.getInt("GIRIS_YILI"));
				ogrenci.setDANISMAN_ID(resultSet.getInt("DANISMAN_ID"));
			
				ogrenciListesi.add(ogrenci);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ogrenciListesi;
	}
	

	@Override
	public OGRENCI Delete(OGRENCI entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(OGRENCI entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OGRENCI> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
