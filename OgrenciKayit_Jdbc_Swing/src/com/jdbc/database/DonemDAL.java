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
import com.jdbc.types.DONEM;

public class DonemDAL extends OjdbcTool implements ICrud<DONEM> {

	@Override
	public void Insert(DONEM entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate("INSERT INTO DONEM (ID, DONEM_ADI) VALUES(" + "DONEM_SEQ.nextval" + ",'"+entity.getDONEM_ADI()+"')");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<DONEM> GetAll() {
		List<DONEM> donemListesi = new ArrayList<DONEM>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From DONEM");
			DONEM donem;
			while (resultSet.next()) {
				donem = new DONEM();
				donem.setID(resultSet.getInt("ID"));
				donem.setDONEM_ADI(resultSet.getString("DONEM_ADI"));

				donemListesi.add(donem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donemListesi;
	}

	@Override
	public DONEM Delete(DONEM entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(DONEM entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DONEM> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
