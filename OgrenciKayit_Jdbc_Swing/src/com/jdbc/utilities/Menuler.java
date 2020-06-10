package com.jdbc.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import com.jdbc.frontEnd.AcilanDerslerFE;
import com.jdbc.frontEnd.AktifDonemBelirleFE;
import com.jdbc.frontEnd.BolumEkleFE;
import com.jdbc.frontEnd.DersEkleFE;
import com.jdbc.frontEnd.DonemEkleFE;
import com.jdbc.frontEnd.OgrenciDersKaydiFE;
import com.jdbc.frontEnd.OgrenciDonemKaydiFE;
import com.jdbc.frontEnd.OgrenciEkleFE;
import com.jdbc.frontEnd.OgretmenEkleFE;

public class Menuler {

	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();
		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("Cikis");
		dosyaMenu.add(cikisItem);

		JMenu bolumlerMenu = new JMenu("Bolumler");
		bar.add(bolumlerMenu);
		JMenuItem bolumEkle = new JMenuItem("Bolum Ekle");
		bolumlerMenu.add(bolumEkle);
		bolumlerMenu.addSeparator();
		JMenuItem bolumDuzenle = new JMenuItem("Bolumu Duzenle");
		bolumlerMenu.add(bolumDuzenle);

		JMenu dersMenu = new JMenu("Dersler");
		bar.add(dersMenu);
		JMenuItem dersEkle = new JMenuItem("Ders Ekle");
		dersMenu.add(dersEkle);
		JMenuItem acilanDersler = new JMenuItem("Acilan Dersler");
		dersMenu.add(acilanDersler);
		dersMenu.addSeparator();
		JMenuItem dersDuzenle = new JMenuItem("Dersi Duzenle");
		dersMenu.add(dersDuzenle);

		JMenu ogrenciMenu = new JMenu("Ogrenciler");
		bar.add(ogrenciMenu);
		JMenuItem ogrenciEkle = new JMenuItem("Ogrenci Ekle");
		ogrenciMenu.add(ogrenciEkle);
		JMenuItem ogrenciDuzenle = new JMenuItem("Ogrenci Duzenle");
		ogrenciMenu.add(ogrenciDuzenle);
		ogrenciMenu.addSeparator();
		JMenuItem ogrenciDersEkle = new JMenuItem("Ogrenci Ders Kaydi");
		ogrenciMenu.add(ogrenciDersEkle);
		JMenuItem ogrenciDonemKaydi = new JMenuItem("Ogrenci Donem Kaydi");
		ogrenciMenu.add(ogrenciDonemKaydi);

		JMenu ogretmenMenu = new JMenu("Ogretmenler");
		bar.add(ogretmenMenu);
		JMenuItem ogretmenEkle = new JMenuItem("Ogretmen Ekle");
		ogretmenMenu.add(ogretmenEkle);
		JMenuItem ogretmenDuzenle = new JMenuItem("Ogretmen Duzenle");
		ogretmenMenu.add(ogretmenDuzenle);

		JMenu donemMenu = new JMenu("Donemler");
		bar.add(donemMenu);
		JMenuItem donemEkle = new JMenuItem("Donem Ekle");
		donemMenu.add(donemEkle);
		JMenuItem donemDuzenle = new JMenuItem("Donem Duzenle");
		donemMenu.add(donemDuzenle);
		donemMenu.addSeparator();
		JMenuItem aktifDonemBelirle = new JMenuItem("Aktif Donem");
		donemMenu.add(aktifDonemBelirle);
		

	
		

		bolumEkle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						new BolumEkleFE();

					}
				});

			}
		});

		dersEkle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DersEkleFE();

			}
		});
		ogrenciEkle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new OgrenciEkleFE();

					}
				});

			}
		});
		ogretmenEkle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new OgretmenEkleFE();
					}
				});
			}
		});
		
		acilanDersler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AcilanDerslerFE();
						
					}
				});
				
			}
		});
		donemEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new DonemEkleFE();
						
					}
				});
				
			}
		});
		
		ogrenciDersEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new OgrenciDersKaydiFE();
						
					}
				});
				
			}
		});
		ogrenciDonemKaydi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new OgrenciDonemKaydiFE();
						
					}
				});
				
			}
		});
		aktifDonemBelirle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AktifDonemBelirleFE();
						
					}
				});
				
			}
		});

		return bar;
	}

}
