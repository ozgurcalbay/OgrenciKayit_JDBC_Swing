package com.jdbc.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connectiontool.OjdbcTool;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.DONEM;
import com.jdbc.types.OGRENCI_DONEM_KAYIT;

public class Ogrenci_Donem_Kayit_DAL extends OjdbcTool implements ICrud<OGRENCI_DONEM_KAYIT> {

	@Override
	public void Insert(OGRENCI_DONEM_KAYIT entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate("INSERT INTO OGRENCI_DONEM_KAYIT (ID, OGRENCI_ID, KAYIT_DURUM, DONEM_ID) VALUES("
					+ "OGRENCI_DONEM_KAYIT_SEQ.nextval" + "," + entity.getOGRENCI_ID() + "," + entity.getKAYIT_DURUM()
					+ "," + entity.getDONEM_ID() + ")");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<OGRENCI_DONEM_KAYIT> GetAll() {
		List<OGRENCI_DONEM_KAYIT> ogrenciDonemListesi = new ArrayList<OGRENCI_DONEM_KAYIT>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From OGRENCI_DONEM_KAYIT");
			OGRENCI_DONEM_KAYIT ogrDonem;
			while (resultSet.next()) {
				ogrDonem = new OGRENCI_DONEM_KAYIT();
				ogrDonem.setID(resultSet.getInt("ID"));
				ogrDonem.setOGRENCI_ID(resultSet.getInt("OGRENCI_ID"));
				ogrDonem.setKAYIT_DURUM(resultSet.getInt("KAYIT_DURUM"));
				ogrDonem.setDONEM_ID(resultSet.getInt("DONEM_ID"));

				ogrenciDonemListesi.add(ogrDonem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ogrenciDonemListesi;
	}

	@Override
	public OGRENCI_DONEM_KAYIT Delete(OGRENCI_DONEM_KAYIT entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(OGRENCI_DONEM_KAYIT entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OGRENCI_DONEM_KAYIT> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
