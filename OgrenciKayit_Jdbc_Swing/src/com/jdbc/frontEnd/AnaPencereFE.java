package com.jdbc.frontEnd;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.jdbc.database.OgrenciDAL;
import com.jdbc.database.OgretmenDAL;
import com.jdbc.interfaces.FrontEndFaces;
import com.jdbc.types.OGRENCI;
import com.jdbc.types.OGRETMEN;

import com.jdbc.utilities.Menuler;

public class AnaPencereFE extends JFrame implements FrontEndFaces {

	public AnaPencereFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		JMenuBar bar = initBar();

		add(panel);
		setJMenuBar(bar);
		setTitle("Oibs");
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JTabbedPane pane = initTabs();
		panel.add(pane, BorderLayout.CENTER);
		panel.add(pane);

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = Menuler.initBar();

		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		JTabbedPane pane = new JTabbedPane();

		ImageIcon icon = new ImageIcon("icon/3.png");
		ImageIcon icon2 = new ImageIcon("icon/3.png");

		JPanel ogrenciPanel = new JPanel(new BorderLayout());
		JPanel ogretmenPanel = new JPanel(new BorderLayout());

		// ogrenci İslemleri
		JPanel ogrenciSolPanel = new JPanel(new BorderLayout());
		JPanel ogrenciSolUstPanel = new JPanel(new GridLayout(3, 2));
		JPanel ogrenciSolAltPanel = new JPanel();

		ogrenciSolUstPanel.setBorder(BorderFactory.createTitledBorder("Ogrenci İslemleri"));
		Object[] ogrenciKlonlar = { "ID", "ADI", "OKUL NO", "BOLUM", "GIRIS YILI", "DANISMAN" };
		DefaultTableModel model = new DefaultTableModel(ogrenciKlonlar, 0);
		JTable table = new JTable(model);
		JScrollPane ogrenciTablePane = new JScrollPane(table);

		for (OGRENCI ogrenci : new OgrenciDAL().GetAll()) {
			model.addRow(ogrenci.getVeriler());
		}

		JLabel ogrenciAdiLabel = new JLabel("Ogreci Adi: ", JLabel.RIGHT);
		ogrenciSolUstPanel.add(ogrenciAdiLabel);
		JComboBox ogrenciAdiBox = new JComboBox(new OgrenciDAL().GetAll().toArray());
		ogrenciSolUstPanel.add(ogrenciAdiBox);

		JButton ogrenciListele = new JButton("Listele");
		ogrenciSolUstPanel.add(ogrenciListele);
		JButton ogrenciListelYenile = new JButton("Yenile");
		ogrenciSolUstPanel.add(ogrenciListelYenile);

		// Ogretmen İslemleri
		JPanel ogretmenSagPanel = new JPanel(new BorderLayout());
		JPanel ogretmenSagUstPanel = new JPanel(new GridLayout(3, 2));
		JPanel ogretmenSagAltPanel = new JPanel();
		ogretmenSagUstPanel.setBorder(BorderFactory.createTitledBorder("Ogretmen İslemleri"));

		Object[] ogretmenKlonlar = { "ID", "ADI", "SOYADI", "BOLUM", "UNVAN", "SICIL NO", "BASLAMA TARIHI" };
		DefaultTableModel ogretmenModel = new DefaultTableModel(ogretmenKlonlar, 0);
		JTable ogretmenTable = new JTable(ogretmenModel);
		JScrollPane ogretmenTablePane = new JScrollPane(ogretmenTable);

		for (OGRETMEN ogretmen : new OgretmenDAL().GetAll()) {
			ogretmenModel.addRow(ogretmen.getVeriler());
		}

		JLabel OgretmenAdiLabel = new JLabel("Ogretmen Adi: ", JLabel.RIGHT);
		ogretmenSagUstPanel.add(OgretmenAdiLabel);
		JComboBox ogretmenAdiBox = new JComboBox(new OgretmenDAL().GetAll().toArray());
		ogretmenSagUstPanel.add(ogretmenAdiBox);

		JButton ogretmenListele = new JButton("Listele");
		ogretmenSagUstPanel.add(ogretmenListele);
		JButton ogretmenListelelYenile = new JButton("Yenile");
		ogretmenSagUstPanel.add(ogretmenListelelYenile);

		ogrenciPanel.add(ogrenciSolPanel, BorderLayout.WEST);
		ogrenciPanel.add(ogrenciTablePane, BorderLayout.CENTER);

		ogretmenPanel.add(ogretmenSagPanel, BorderLayout.EAST);
		ogretmenPanel.add(ogretmenTablePane, BorderLayout.CENTER);

		ogretmenSagPanel.add(ogretmenSagUstPanel, BorderLayout.NORTH);
		ogretmenSagPanel.add(ogretmenSagAltPanel, BorderLayout.SOUTH);

		ogrenciSolPanel.add(ogrenciSolUstPanel, BorderLayout.NORTH);
		ogrenciSolPanel.add(ogrenciSolAltPanel, BorderLayout.SOUTH);

		pane.addTab("Ogrenciler", icon, ogrenciPanel, "does");
		pane.addTab("Ogretmenler", icon2, ogretmenPanel, "does not");
		return pane;
	}
}
