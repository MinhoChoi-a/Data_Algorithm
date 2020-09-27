package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Gaaa {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gaaa window = new Gaaa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gaaa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton1 = new JButton();
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton1.gridx = 0;
		gbc_btnNewButton1.gridy = 0;
		panel.add(btnNewButton1, gbc_btnNewButton1);
		
		JButton btnNewButton2 = new JButton();
		GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
		gbc_btnNewButton2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton2.gridx = 1;
		gbc_btnNewButton2.gridy = 0;
		panel.add(btnNewButton2, gbc_btnNewButton2);
		
		JButton btnNewButton3 = new JButton();
		GridBagConstraints gbc_btnNewButton3 = new GridBagConstraints();
		gbc_btnNewButton3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton3.gridx = 2;
		gbc_btnNewButton3.gridy = 0;
		panel.add(btnNewButton3, gbc_btnNewButton3);
		
		JButton btnNewButton4 = new JButton();
		GridBagConstraints gbc_btnNewButton4 = new GridBagConstraints();
		gbc_btnNewButton4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton4.gridx = 3;
		gbc_btnNewButton4.gridy = 0;
		panel.add(btnNewButton4, gbc_btnNewButton4);		
		
	}

}
