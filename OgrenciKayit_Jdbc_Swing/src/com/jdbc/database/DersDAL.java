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

public class DersDAL extends OjdbcTool implements ICrud<DERS> {

	@Override
	public void Insert(DERS entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate("INSERT INTO DERS (ID,DERS_ADI, KREDI, ONSART_DERS_ID, BOLUM_ID, MUFREDAT) VALUES(" + "DERS_SEQ.nextval" + ",'"
					+ entity.getDERS_ADI() + "'," + entity.getKREDI() + "," + entity.getONSART_DERS_ID() + ","
					+ entity.getBOLUM_ID() + ",'" + entity.getMUFREDAT() + "')");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<DERS> GetAll() {
		List<DERS> dersListesi = new ArrayList<DERS>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From DERS");
			DERS ders;
			while(resultSet.next()) {
				ders = new DERS();
				ders.setID(resultSet.getInt("ID"));
				ders.setDERS_ADI(resultSet.getString("DERS_ADI"));
				ders.setKREDI(resultSet.getInt("KREDI"));
				ders.setONSART_DERS_ID(resultSet.getInt("ONSART_DERS_ID"));
				ders.setBOLUM_ID(resultSet.getInt("BOLUM_ID"));
				ders.setMUFREDAT(resultSet.getString("MUFREDAT"));
				
				dersListesi.add(ders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dersListesi;
	}

	@Override
	public DERS Delete(DERS entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(DERS entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DERS> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
