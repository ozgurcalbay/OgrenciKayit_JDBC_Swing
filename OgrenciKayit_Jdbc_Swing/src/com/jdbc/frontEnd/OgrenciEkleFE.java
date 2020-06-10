package com.jdbc.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.jdbc.database.BolumDAL;
import com.jdbc.database.DersDAL;
import com.jdbc.database.OgrenciDAL;
import com.jdbc.database.OgretmenDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DERS;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRETMEN;
import com.toedter.calendar.JDateChooser;

public class OgrenciEkleFE extends JDialog implements FrontEndFaces {

	public OgrenciEkleFE() {
		initPencere();

	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ogrenci Kayit"));
		add(panel);
		setTitle("Ogrenci Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(7, 2));

		JLabel adiLabel = new JLabel("Adi: ", JLabel.LEFT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(25);
		panel.add(adiField);

		JLabel soyAdiLabel = new JLabel("Soyadi: ", JLabel.LEFT);
		panel.add(soyAdiLabel);
		JTextField soyAdiField = new JTextField(25);
		panel.add(soyAdiField);

		JLabel okulNoLabel = new JLabel("Okul No: ", JLabel.LEFT);
		panel.add(okulNoLabel);
		JTextField okulNoField = new JTextField(25);
		panel.add(okulNoField);

		JLabel bolumLabel = new JLabel("Bolum Secimi: ", JLabel.LEFT);
		panel.add(bolumLabel);
		JComboBox bolumSecimi = new JComboBox(new BolumDAL().GetAll().toArray());
		panel.add(bolumSecimi);
		bolumSecimi.insertItemAt("-- Bolum Seciniz --", 0);
		bolumSecimi.setSelectedIndex(0);

		JLabel girisYiliLabel = new JLabel("Giris Yili: ", JLabel.LEFT);
		panel.add(girisYiliLabel);

		
		JTextField girisYiliField = new JTextField(25);
		panel.add(girisYiliField);

		
		JLabel danismanLabel = new JLabel("Danisman Secimi: ", JLabel.LEFT);
		panel.add(danismanLabel);
		JComboBox danismanSecimi = new JComboBox(new OgretmenDAL().GetAll().toArray());
		panel.add(danismanSecimi);
		danismanSecimi.insertItemAt("-- Danisman Seciniz --", 0);
		danismanSecimi.setSelectedIndex(0);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BOLUM bolum = new BOLUM();
				OGRENCI ogrenci = new OGRENCI();
				OGRETMEN ogretmen = new OGRETMEN();

				if (bolumSecimi.getSelectedIndex() != 0) {
					BOLUM castBolum = (BOLUM) bolumSecimi.getSelectedItem();
					ogrenci.setADI(adiField.getText());
					ogrenci.setSOYADI(soyAdiField.getText());
					ogrenci.setOKUL_NO(Integer.parseInt(okulNoField.getText()));
					ogrenci.setBOLUM_ID(bolumSecimi.getSelectedIndex());
					ogrenci.setGIRIS_YILI(Integer.parseInt(girisYiliField.getText()));
					OGRETMEN castOgretmen = (OGRETMEN) danismanSecimi.getSelectedItem();
					ogrenci.setDANISMAN_ID(danismanSecimi.getSelectedIndex());
					new OgrenciDAL().Insert(ogrenci);
					JOptionPane.showMessageDialog(null,
							ogrenci.getADI() + " " + ogrenci.getSOYADI() + "adli Ogrenci basariyla eklenmistir !");

				} else {

					JOptionPane.showMessageDialog(null,ogrenci.getADI() + " " + ogrenci.getSOYADI() +" adli ogrenci eklenememistir  ! ","Hata ", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		JButton iptalButton = new JButton("İptal");
		panel.add(iptalButton);

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
