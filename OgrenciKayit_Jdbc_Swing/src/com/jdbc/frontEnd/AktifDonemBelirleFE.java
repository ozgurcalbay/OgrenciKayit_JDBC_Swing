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

import com.jdbc.database.Aktif_DonemDAL;
import com.jdbc.database.DonemDAL;
import com.jdbc.database.Ogrenci_Donem_Kayit_DAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.AKTIF_DONEM;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRENCI_DONEM_KAYIT;

public class AktifDonemBelirleFE extends JDialog implements FrontEndFaces {

	public AktifDonemBelirleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Aktif Donem"));
		getContentPane().add(panel);

		setTitle("Aktif Donem Secimi");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 2));
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

				AKTIF_DONEM aktifDonem = new AKTIF_DONEM();

				if (donemBox.getSelectedIndex() != 0) {

					aktifDonem.setDONEM_ID(donemBox.getSelectedIndex());

					new Aktif_DonemDAL().Insert(aktifDonem);
					JOptionPane.showMessageDialog(null, aktifDonem.getDONEM_ID() + " Donem Aktif Donem secilmistir !");
				} else {

					JOptionPane.showMessageDialog(null, aktifDonem.getDONEM_ID() + " aktif donem secilemedi ! ",
							"Hata ", JOptionPane.WARNING_MESSAGE);

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
