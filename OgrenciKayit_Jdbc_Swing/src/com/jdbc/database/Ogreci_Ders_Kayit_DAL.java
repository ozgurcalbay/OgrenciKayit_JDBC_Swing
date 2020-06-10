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
import com.jdbc.types.OGRENCI_DERS_KAYIT;

public class Ogreci_Ders_Kayit_DAL extends OjdbcTool implements ICrud<OGRENCI_DERS_KAYIT> {

	@Override
	public void Insert(OGRENCI_DERS_KAYIT entity) {
		Connection connection = getConnection();
		try {
			Statement stmt = connection.createStatement();

			stmt.executeUpdate(
					"INSERT INTO OGRENCI_DERS_KAYIT (ID, OGRENCI_ID, ACILAN_DERS_ID, DERS_ID, NOTU, OGRENCI_DONEM_KAYIT_ID) VALUES("
							+ "OGRENCI_DERS_KAYIT_SEQ.nextval" + "," + entity.getOGRENCI_ID() + ","
							+ entity.getACILAN_DERS_ID() + "," + entity.getDERS_ID() + "," + entity.getNOTU() + ","
							+ entity.getOGRENCI_DONEM_KAYIT_ID() +")");
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<OGRENCI_DERS_KAYIT> GetAll() {
		List<OGRENCI_DERS_KAYIT> ogrenciDersKayitListesi = new ArrayList<OGRENCI_DERS_KAYIT>();
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * From OGRENCI_DERS_KAYIT");
			OGRENCI_DERS_KAYIT ogrenciDersKayit;
			while (resultSet.next()) {
				ogrenciDersKayit = new OGRENCI_DERS_KAYIT();
				ogrenciDersKayit.setID(resultSet.getInt("ID"));
				ogrenciDersKayit.setOGRENCI_ID(resultSet.getInt("OGRENCI_ID"));
				ogrenciDersKayit.setACILAN_DERS_ID(resultSet.getInt("ACILAN_DERS_ID"));
				ogrenciDersKayit.setDERS_ID(resultSet.getInt("DERS_ID"));
				ogrenciDersKayit.setNOTU(resultSet.getInt("NOTU"));
				ogrenciDersKayit.setOGRENCI_DONEM_KAYIT_ID(resultSet.getInt("OGRENCI_DONEM_KAYIT_ID"));
				ogrenciDersKayit.setDONEM_ID(resultSet.getInt("DONEM_ID"));

				ogrenciDersKayitListesi.add(ogrenciDersKayit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ogrenciDersKayitListesi;
	}

	@Override
	public OGRENCI_DERS_KAYIT Delete(OGRENCI_DERS_KAYIT entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(OGRENCI_DERS_KAYIT entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OGRENCI_DERS_KAYIT> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
