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
import com.jdbc.database.DonemDAL;
import com.jdbc.database.Ogreci_Ders_Kayit_DAL;
import com.jdbc.database.OgrenciDAL;
import com.jdbc.database.Ogrenci_Donem_Kayit_DAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.ACILAN_DERS;
import com.jdbc.types.DERS;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRENCI_DERS_KAYIT;
import com.jdbc.types.OGRENCI_DONEM_KAYIT;

public class OgrenciDonemKaydiFE extends JDialog implements FrontEndFaces{

	public OgrenciDonemKaydiFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ogrenci Donem Kayit Alani"));
		getContentPane().add(panel);
		setTitle("Donem");
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
		
		JLabel kayitLabel = new JLabel("Kayit", JLabel.LEFT);
		panel.add(kayitLabel);
		JComboBox kayitBox = new JComboBox(new String[] {"0 - Kayit yok ", "1 - Ders Secimi Yapabilir","2 - Onay gönderildi","3 - Onaylandi"});
		panel.add(kayitBox);
		kayitBox.insertItemAt("-- Kayit Durumu--", 0);
		kayitBox.setSelectedIndex(0);

		JLabel donemLabel = new JLabel("Donem", JLabel.LEFT);
		panel.add(donemLabel);
		JComboBox donemBox = new JComboBox(new DonemDAL().GetAll().toArray());
		panel.add(donemBox);
		donemBox.insertItemAt("-- Donem Seciniz --", 0);
		donemBox.setSelectedIndex(0);


		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			
				OGRENCI castBolum = (OGRENCI) ogrenciBox.getSelectedItem();
				OGRENCI_DONEM_KAYIT ogrKayit = new OGRENCI_DONEM_KAYIT();
		

				if (ogrenciBox.getSelectedIndex() != 0) {

					ogrKayit.setOGRENCI_ID(ogrenciBox.getSelectedIndex());
					ogrKayit.setKAYIT_DURUM(kayitBox.getSelectedIndex());
					ogrKayit.setDONEM_ID(donemBox.getSelectedIndex());
					
					

					new Ogrenci_Donem_Kayit_DAL().Insert(ogrKayit);
					JOptionPane.showMessageDialog(null, ogrKayit.getOGRENCI_ID()
							+ " adli Ogrencinin Donem Kaydi basarili bir sekilde yapilmistir !");
				} else {

					JOptionPane.showMessageDialog(null, ogrKayit.getOGRENCI_ID() + " adli donem kaydi yapilamadi  ! ","Hata ", JOptionPane.WARNING_MESSAGE);

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
