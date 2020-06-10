package com.jdbc.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.connectiontool.OjdbcTool;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.ACILAN_DERS;
import com.jdbc.types.DERS;

public class Acilan_DersDAL extends OjdbcTool implements ICrud<ACILAN_DERS> {

	@Override
	public void Insert(ACILAN_DERS entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate(
					"INSERT INTO ACILAN_DERS (ID,DERS_ID, OGRETMEN_ID, KONTENJAN, KAYITLI_OGRENCI_SAYISI, DONEM_ID) VALUES("
							+ "ACILAN_DERS_SEQ.nextval" + "," + entity.getDERS_ID() + "," + entity.getOGRETMEN_ID()
							+ "," + entity.getKONTENJAN() + "," + entity.getKAYITLI_OGRENCI_SAYISI() + ","
							+ entity.getDONEM_ID() + ")");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<ACILAN_DERS> GetAll() {
		List<ACILAN_DERS> AcilanDersListesi = new ArrayList<ACILAN_DERS>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From ACILAN_DERS");
			ACILAN_DERS acilanDers;
			while (resultSet.next()) {
				acilanDers = new ACILAN_DERS();
				acilanDers.setID(resultSet.getInt("ID"));
				acilanDers.setDERS_ID(resultSet.getInt("DERS_ID"));
				acilanDers.setOGRETMEN_ID(resultSet.getInt("OGRETMEN_ID"));
				acilanDers.setKONTENJAN(resultSet.getInt("KONTENJAN"));
				acilanDers.setKAYITLI_OGRENCI_SAYISI(resultSet.getInt("KAYITLI_OGRENCI_SAYISI"));
				acilanDers.setDONEM_ID(resultSet.getInt("DONEM_ID"));

				AcilanDersListesi.add(acilanDers);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AcilanDersListesi;
	}

	@Override
	public ACILAN_DERS Delete(ACILAN_DERS entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(ACILAN_DERS entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ACILAN_DERS> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
