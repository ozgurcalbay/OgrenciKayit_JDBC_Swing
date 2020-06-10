package com.jdbc.frontEnd;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
import com.jdbc.database.OgretmenDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.BOLUM;
import com.jdbc.types.OGRETMEN;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class OgretmenEkleFE extends JDialog implements FrontEndFaces {

	public OgretmenEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ogretmen Ekleme Alani"));
		getContentPane().add(panel);
		setTitle("Ogretmen Ekleyin");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(8, 2));

		JLabel adiLabel = new JLabel("Adi: ", JLabel.LEFT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(25);
		panel.add(adiField);

		JLabel soyAdiLabel = new JLabel("Soyadi: ", JLabel.LEFT);
		panel.add(soyAdiLabel);
		JTextField soyAdiField = new JTextField(25);
		panel.add(soyAdiField);

		JLabel bolumLabel = new JLabel("Bolum Secimi: ", JLabel.LEFT);
		panel.add(bolumLabel);
		JComboBox bolumSecimi = new JComboBox(new BolumDAL().GetAll().toArray());
		panel.add(bolumSecimi);
		bolumSecimi.insertItemAt("-- Bolum Seciniz --", 0);
		bolumSecimi.setSelectedIndex(0);

		JLabel unvanSecLabel = new JLabel("Unvan Secimi: ", JLabel.LEFT);
		panel.add(unvanSecLabel);
		JComboBox unvanSecimi = new JComboBox(new String[] { "PROF", "DOC", "DR", "ARS.GR", "ASISTAN" });
		panel.add(unvanSecimi);
		unvanSecimi.insertItemAt("-- Unvan Seciniz --", 0);
		unvanSecimi.setSelectedIndex(0);

		JLabel sicilNoLabel = new JLabel("Sicil No: ", JLabel.LEFT);
		panel.add(sicilNoLabel);
		JTextField sicilNoField = new JTextField(25);
		panel.add(sicilNoField);

		JLabel girisYiliLabel = new JLabel("Giris Yili: ", JLabel.LEFT);
		panel.add(girisYiliLabel);
		JDateChooser girisYili = new JDateChooser();
		girisYili.setDateFormatString("MM/dd/yyyy");
		panel.add(girisYili);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		kaydetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BOLUM bolum = new BOLUM();
				OGRETMEN ogretmen = new OGRETMEN();

				if (bolumSecimi.getSelectedIndex() != 0) {
					BOLUM castBolum = (BOLUM) bolumSecimi.getSelectedItem();
					ogretmen.setADI(adiField.getText());
					ogretmen.setSOYADI(soyAdiField.getText());
					ogretmen.setBOLUM_ID(bolumSecimi.getSelectedIndex());
					ogretmen.setUNVAN((String) unvanSecimi.getSelectedItem());
					ogretmen.setSICIL_NO(Integer.parseInt(sicilNoField.getText()));
					SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
					String date = format.format(girisYili.getDate());
					ogretmen.setBASLAMA_TARIHI(null);

					new OgretmenDAL().Insert(ogretmen);
					JOptionPane.showMessageDialog(null,
							ogretmen.getADI() + " " + ogretmen.getSOYADI() + " adli Ogretmen basariyla eklenmistir !");

				} else {

					JOptionPane.showMessageDialog(null,
							ogretmen.getADI() + " " + ogretmen.getSOYADI() + " Adli ogretmen eklenememistir! ", "Hata ",
							JOptionPane.WARNING_MESSAGE);
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
