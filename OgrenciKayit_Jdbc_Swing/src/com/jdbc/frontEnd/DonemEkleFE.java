package com.jdbc.frontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.jdbc.database.DersDAL;
import com.jdbc.database.DonemDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.BOLUM;
import com.jdbc.types.DONEM;

public class DonemEkleFE extends JDialog implements FrontEndFaces {

	public DonemEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Donem Ekleme Alani"));
		getContentPane().add(panel);
		setTitle("Donem Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 2));

		JLabel adiLabel = new JLabel("Donem Giriniz: ", JLabel.LEFT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(25);
		panel.add(adiField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {
			DONEM donem = new DONEM();

			@Override
			public void actionPerformed(ActionEvent e) {

				donem.setDONEM_ADI(adiField.getText());
				new DonemDAL().Insert(donem);
				JOptionPane.showMessageDialog(null,
						donem.getDONEM_ADI() + " adli Donem basarili bir sekilde eklenmistir !");

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
