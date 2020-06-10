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
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DERS;
import javax.swing.DefaultComboBoxModel;

public class DersEkleFE extends JDialog implements FrontEndFaces {

	public DersEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ders Ekleme Alani"));
		getContentPane().add(panel);
		setTitle("Ders Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(7, 2));

		JLabel adiLabel = new JLabel("Ders Adi: ", JLabel.LEFT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(25);
		panel.add(adiField);
/*
		JLabel dersLabel = new JLabel("Ders Secimi", JLabel.LEFT);
		panel.add(dersLabel);
		JComboBox dersBox = new JComboBox(new DersDAL().GetAll().toArray());
		panel.add(dersBox);
		dersBox.insertItemAt("-- Ders Seciniz --", 0);
		dersBox.setSelectedIndex(0);
		*/

		JLabel dersKredisiLabel = new JLabel("Ders Kredisi: ", JLabel.LEFT);
		panel.add(dersKredisiLabel);
		JTextField dersKrediField = new JTextField(2);
		panel.add(dersKrediField);

		JLabel onSartLabel = new JLabel("Zorunlu Ders: ", JLabel.LEFT);
		panel.add(onSartLabel);
		JComboBox zorunluDers = new JComboBox(new String[] {"Ingilizce ", "Donem projesi"});
		panel.add(zorunluDers);
		zorunluDers.insertItemAt("-- Zorunlu Ders --", 0);
		zorunluDers.setSelectedIndex(0);

		JLabel bolumLabel = new JLabel("Bolum Secimi: ", JLabel.LEFT);
		panel.add(bolumLabel);
		JComboBox bolumSecimi = new JComboBox(new BolumDAL().GetAll().toArray());
		panel.add(bolumSecimi);
		bolumSecimi.insertItemAt("-- Bolum Seciniz --", 0);
		bolumSecimi.setSelectedIndex(0);

		JLabel dersMufredat = new JLabel("Mufredat: ", JLabel.LEFT);
		panel.add(dersMufredat);
		JTextField dersMufredatField = new JTextField(25);
		panel.add(dersMufredatField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DERS ders = new DERS();
				BOLUM bolum = new BOLUM();
				
				if (bolumSecimi.getSelectedIndex() != 0) {
					BOLUM castBolum = (BOLUM) bolumSecimi.getSelectedItem();
					
					ders.setDERS_ADI(adiField.getText());
					ders.setKREDI(Integer.parseInt(dersKrediField.getText()));
					ders.setONSART_DERS_ID(zorunluDers.getSelectedIndex());
					ders.setBOLUM_ID(bolumSecimi.getSelectedIndex());
				
					new DersDAL().Insert(ders);
					JOptionPane.showMessageDialog(null,
							ders.getDERS_ADI() + " adli Ders basarili bir sekilde eklenmistir !");
				} else {
					
					JOptionPane.showMessageDialog(null,
							ders.getDERS_ADI() + " adli Ders Eklenememistir !","Hata", JOptionPane.WARNING_MESSAGE);

					
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
