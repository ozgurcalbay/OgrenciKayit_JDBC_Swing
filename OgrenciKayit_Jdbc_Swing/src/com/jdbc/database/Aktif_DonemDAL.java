package com.jdbc.database;

import com.jdbc.interfaces.ICrud;
import com.jdbc.types.AKTIF_DONEM;
import com.jdbc.types.DONEM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connectiontool.OjdbcTool;

public class Aktif_DonemDAL extends OjdbcTool implements ICrud<AKTIF_DONEM> {

	@Override
	public void Insert(AKTIF_DONEM entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate("INSERT INTO AKTIF_DONEM (DONEM_ID) VALUES(" + entity.getDONEM_ID() + ")");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<AKTIF_DONEM> GetAll() {
		List<AKTIF_DONEM> donemListesi = new ArrayList<AKTIF_DONEM>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From AKTIF_DONEM");
			AKTIF_DONEM donem;
			while (resultSet.next()) {
				donem = new AKTIF_DONEM();
				donem.setDONEM_ID(resultSet.getInt("DONEM_ID"));

				donemListesi.add(donem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donemListesi;
	}

	@Override
	public AKTIF_DONEM Delete(AKTIF_DONEM entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AKTIF_DONEM entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AKTIF_DONEM> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
