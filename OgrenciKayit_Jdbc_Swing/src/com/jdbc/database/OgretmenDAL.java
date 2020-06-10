package com.jdbc.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.jdbc.connectiontool.OjdbcTool;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.OGRETMEN;

public class OgretmenDAL extends OjdbcTool implements ICrud<OGRETMEN> {

	@Override
	public void Insert(OGRETMEN entity) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO OGRETMEN (ID, ADI, SOYADI, BOLUM_ID, UNVAN, SICIL_NO, BASLAMA_TARIHI)"
					+ "VALUES(" + "OGRETMEN_SEQ.nextval" + ",'" + entity.getADI() + "','" + entity.getSOYADI() + "',"
					+ entity.getBOLUM_ID() + ",'" + entity.getUNVAN() + "'," + entity.getSICIL_NO() + ","
					+ entity.getBASLAMA_TARIHI() + ")");
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<OGRETMEN> GetAll() {
		List<OGRETMEN> ogretmenListesi = new ArrayList<OGRETMEN>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From OGRETMEN");
			OGRETMEN ogretmen;
			while (resultSet.next()) {
				ogretmen = new OGRETMEN();
				ogretmen.setID(resultSet.getInt("ID"));
				ogretmen.setADI(resultSet.getString("ADI"));
				ogretmen.setSOYADI(resultSet.getString("SOYADI"));
				ogretmen.setBOLUM_ID(resultSet.getInt("BOLUM_ID"));
				ogretmen.setUNVAN(resultSet.getString("UNVAN"));
				ogretmen.setSICIL_NO(resultSet.getInt("SICIL_NO"));
				ogretmen.setBASLAMA_TARIHI(resultSet.getString("BASLAMA_TARIHI"));

				ogretmenListesi.add(ogretmen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ogretmenListesi;
	}

	@Override
	public OGRETMEN Delete(OGRETMEN entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(OGRETMEN entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OGRETMEN> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
