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
import javax.swing.SwingConstants;

import com.jdbc.database.Acilan_DersDAL;
import com.jdbc.database.BolumDAL;
import com.jdbc.database.DersDAL;
import com.jdbc.database.DonemDAL;
import com.jdbc.database.OgrenciDAL;
import com.jdbc.database.OgretmenDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.ACILAN_DERS;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DERS;
import com.jdbc.types.DONEM;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRETMEN;

public class AcilanDerslerFE extends JDialog implements FrontEndFaces {

	public AcilanDerslerFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Acilan Dersler"));
		getContentPane().add(panel);

		setTitle("Acilan Dersler");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(6, 2));

		JLabel dersAdiLabel = new JLabel("Ders Seciniz", JLabel.LEFT);
		panel.add(dersAdiLabel);
		JComboBox dersBox = new JComboBox(new DersDAL().GetAll().toArray());
		panel.add(dersBox);
		dersBox.insertItemAt("-- Ders Seciniz --", 0);
		dersBox.setSelectedIndex(0);

		JLabel ogretmenAdiLabel = new JLabel("Ogretmen Seciniz", JLabel.LEFT);
		panel.add(ogretmenAdiLabel);
		JComboBox ogretmenBox = new JComboBox(new OgretmenDAL().GetAll().toArray());
		panel.add(ogretmenBox);
		ogretmenBox.insertItemAt("-- Ogretmen Seciniz --", 0);
		ogretmenBox.setSelectedIndex(0);

		JLabel kontenjanLabel = new JLabel("Kontenjan Belirleyiniz: ", SwingConstants.LEFT);
		panel.add(kontenjanLabel);
		JTextField kontenjanField = new JTextField(5);
		panel.add(kontenjanField);

		JLabel ogrenciAdiLabel = new JLabel("Kayitli Ogrenci", JLabel.LEFT);
		panel.add(ogrenciAdiLabel);
		JComboBox ogrenciBox = new JComboBox(new OgrenciDAL().GetAll().toArray());
		panel.add(ogrenciBox);
		ogrenciBox.insertItemAt("-- Kayitli Ogrenci Listesi --", 0);
		ogrenciBox.setSelectedIndex(0);
		
		JLabel donemAdiLabel = new JLabel("Donem Seciniz", JLabel.LEFT);
		panel.add(donemAdiLabel);
		JComboBox donemBox = new JComboBox(new DonemDAL().GetAll().toArray());
		panel.add(donemBox);
		donemBox.insertItemAt("-- Donemler --", 0);
		donemBox.setSelectedIndex(0);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {
			BOLUM bolum = new BOLUM();
			OGRENCI ogrenci = new OGRENCI();
			OGRETMEN ogretmen = new OGRETMEN();
			DONEM donem = new DONEM();
			DERS ders = new DERS();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ACILAN_DERS acilandersler = new ACILAN_DERS();
				if (dersBox.getSelectedIndex() != 0) {
					DERS castBolum = (DERS) dersBox.getSelectedItem();
					OGRETMEN castOgretmen = (OGRETMEN) ogretmenBox.getSelectedItem();
					OGRENCI castOgrenci = (OGRENCI) ogrenciBox.getSelectedItem();
					DONEM castDonem= (DONEM) donemBox.getSelectedItem();
					
					acilandersler.setDERS_ID(dersBox.getSelectedIndex());
					acilandersler.setOGRETMEN_ID(ogretmenBox.getSelectedIndex());
					acilandersler.setKONTENJAN(Integer.parseInt(kontenjanField.getText()));
					acilandersler.setKAYITLI_OGRENCI_SAYISI(ogrenciBox.getSelectedIndex());
					acilandersler.setDONEM_ID(donemBox.getSelectedIndex());
					

					new Acilan_DersDAL().Insert(acilandersler);
					JOptionPane.showMessageDialog(null, acilandersler.getDONEM_ID() + "adli Dersler basariyla eklenmistir !");

				} else {
					

					
					JOptionPane.showMessageDialog(null, acilandersler.getDONEM_ID() + "adli Dersler eklenememistir ! ","Hata ", JOptionPane.WARNING_MESSAGE);

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
