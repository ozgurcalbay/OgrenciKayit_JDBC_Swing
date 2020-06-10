package com.jdbc.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connectiontool.OjdbcTool;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DERS;

public class BolumDAL extends OjdbcTool implements ICrud<BOLUM> {

	@Override
	public void Insert(BOLUM entity) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO BOLUM (ID, BOLUM_ADI, BOLUM_BASKAN_ID)" + "VALUES(" + "BOLUM_SEQ.nextval" + ",'"
					+ entity.getBOLUM_ADI() + "'," + entity.getBOLUM_BASKAN_ID() + ")");
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<BOLUM> GetAll() {

		List<BOLUM> bolumListesi = new ArrayList<BOLUM>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From BOLUM");
			BOLUM bolum;
			while (resultSet.next()) {
				bolum = new BOLUM();
				bolum.setID(resultSet.getInt("ID"));
				bolum.setBOLUM_ADI(resultSet.getString("BOLUM_ADI"));
				bolum.setBOLUM_BASKAN_ID(resultSet.getInt("BOLUM_BASKAN_ID"));

				bolumListesi.add(bolum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bolumListesi;
	}

	@Override
	public BOLUM Delete(BOLUM entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(BOLUM entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BOLUM> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
