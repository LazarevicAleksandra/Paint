package crtanje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DlgBrisanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	boolean potvrdi;

	public static void main(String[] args) {
		try {
			DlgBrisanje dialog = new DlgBrisanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DlgBrisanje() {
		setTitle("Brisanje");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 400, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblDaLiSte = new JLabel("Da li ste sigurni da zelite da obrisete ovaj objekat?");
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(204, 153, 153));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				potvrdi=true;
				dispose();
			}
		});
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(new Color(204, 153, 153));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				potvrdi=false;
				dispose();
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(46)
							.addComponent(lblDaLiSte))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(135)
							.addComponent(btnPotvrdi)
							.addGap(33)
							.addComponent(btnOdustani)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblDaLiSte)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPotvrdi)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	public boolean getPotvrdi() {
		return potvrdi;
	}

	public void setPotvrdi(boolean potvrdi) {
		this.potvrdi = potvrdi;
	}


}
