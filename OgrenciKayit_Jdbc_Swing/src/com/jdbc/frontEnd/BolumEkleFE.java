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
import com.jdbc.database.OgretmenDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.interfaces.ICrud;
import com.jdbc.types.BOLUM;
import com.jdbc.types.OGRETMEN;
import javax.swing.SwingConstants;

public class BolumEkleFE extends JDialog implements FrontEndFaces {

	public BolumEkleFE() {

		initPencere();

	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Bolum Kayit Alani"));
		getContentPane().add(panel);

		setTitle("Bolum Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel adiLabel = new JLabel("Bolum Adi: ", SwingConstants.LEFT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(25);
		panel.add(adiField);

		JLabel bolumAdiLabel = new JLabel("Bolum Secimi", JLabel.LEFT);
		panel.add(bolumAdiLabel);
		JComboBox BolumBox = new JComboBox(new BolumDAL().GetAll().toArray());
		panel.add(BolumBox);
		BolumBox.insertItemAt("-- Bolum Seciniz --", 0);
		BolumBox.setSelectedIndex(0);

		JLabel bBaskaniLabel = new JLabel("Bolum Baskani: ", SwingConstants.LEFT);
		panel.add(bBaskaniLabel);
		JTextField bBaskaniField = new JTextField(5);
		panel.add(bBaskaniField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BOLUM bolum = new BOLUM();

				if (BolumBox.getSelectedIndex() != 0) {
					BOLUM castBolum = (BOLUM) BolumBox.getSelectedItem();
					bolum.setBOLUM_ADI(adiField.getText());
					bolum.setBOLUM_BASKAN_ID(Integer.parseInt(bBaskaniField.getText()));

					new BolumDAL().Insert(bolum);
					JOptionPane.showMessageDialog(null, bolum.getBOLUM_ADI() + " adli Bolum basariyla eklenmistir !");

				} else {
					JOptionPane.showMessageDialog(null, bolum.getBOLUM_ADI() + " adli bolum eklenememistir ! ","Hata ", JOptionPane.WARNING_MESSAGE);

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
