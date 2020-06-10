package com.jdbc.Test;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jdbc.frontEnd.AnaPencereFE;

public class Run {

	public static void main(String[] args) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new AnaPencereFE();

			}
		});

	}

}
