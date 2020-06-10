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

import com.jdbc.database.Acilan_DersDAL;
import com.jdbc.database.BolumDAL;
import com.jdbc.database.DersDAL;
import com.jdbc.database.Ogreci_Ders_Kayit_DAL;
import com.jdbc.database.OgrenciDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.ACILAN_DERS;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DERS;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRENCI_DERS_KAYIT;

public class OgrenciDersKaydiFE extends JDialog implements FrontEndFaces {

	public OgrenciDersKaydiFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ogrenci Ders Atama"));
		getContentPane().add(panel);
		setTitle("Ders Atama");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel ogrenciLabel = new JLabel("Ogrenciler", JLabel.LEFT);
		panel.add(ogrenciLabel);
		JComboBox ogrenciBox = new JComboBox(new OgrenciDAL().GetAll().toArray());
		panel.add(ogrenciBox);
		ogrenciBox.insertItemAt("-- Ogrenci Seciniz --", 0);
		ogrenciBox.setSelectedIndex(0);

		JLabel acilanDersLabel = new JLabel("Acilan Dersler", JLabel.LEFT);
		panel.add(acilanDersLabel);
		JComboBox acilandersBox = new JComboBox(new Acilan_DersDAL().GetAll().toArray());
		panel.add(acilandersBox);
		acilandersBox.insertItemAt("-- Acilan Dersler --", 0);
		acilandersBox.setSelectedIndex(0);

		JLabel ogrenciNotuLabel = new JLabel("Notu: ", JLabel.LEFT);
		panel.add(ogrenciNotuLabel);
		JTextField ogrenciNotuField = new JTextField(10);
		panel.add(ogrenciNotuField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DERS ders = new DERS();
				OGRENCI_DERS_KAYIT ogrDersKayit = new OGRENCI_DERS_KAYIT();
				ACILAN_DERS acilanDers = new ACILAN_DERS();
				OGRENCI castBolum = (OGRENCI) ogrenciBox.getSelectedItem();
				ACILAN_DERS castAcilanDers = (ACILAN_DERS) acilandersBox.getSelectedItem();

				if (ogrenciBox.getSelectedIndex() != 0) {

					ogrDersKayit.setOGRENCI_ID(ogrenciBox.getSelectedIndex());
					ogrDersKayit.setACILAN_DERS_ID(acilandersBox.getSelectedIndex());
					ogrDersKayit.setDERS_ID(acilandersBox.getSelectedIndex());
					ogrDersKayit.setNOTU(Integer.parseInt(ogrenciNotuField.getText()));
					

					new Ogreci_Ders_Kayit_DAL().Insert(ogrDersKayit);
					JOptionPane.showMessageDialog(null, ogrDersKayit.getACILAN_DERS_ID()
							+ " adli Ogrencinin Ders Kaydi basarili bir sekilde eklenmistir !");
				} else {

					JOptionPane.showMessageDialog(null, ogrDersKayit.getACILAN_DERS_ID() + "adli ders eklenememistir ! ","Hata ", JOptionPane.WARNING_MESSAGE);

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
