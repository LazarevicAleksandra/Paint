package stek;

import oblici.Kvadrat;
import oblici.Oblik;
import oblici.Tacka;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class DlgDodajNaStek extends JDialog {
	private JTextField txt_X;
	private JTextField txt_Y;
	private JTextField txt_DuzinaStranice;
	private JComboBox<String> cbx_BojaIvice;
	private JComboBox<String> cbx_BojaUnutrasnjosti;
	private boolean potvrdi;
	private int x, y, duzina;
	private String bojaIvice, bojaUnustrasnjosti;
	private Kvadrat kreiranKvadrat;

	public static void main(String[] args) {
		try {
			DlgDodajNaStek dialog = new DlgDodajNaStek();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgDodajNaStek() {
		getContentPane().setBackground(new Color(255, 255, 204));
		setBounds(100, 100, 300, 300);
		potvrdi=false;
		setModal(true);
		setResizable(false);
		setTitle("Dodaj kvadrat");
		
		JLabel lbl_Koordinata_X = new JLabel("Koordinata x:  ");
		JLabel lbl_Koordinata_Y = new JLabel("Koordinata y:  ");
		JLabel lbl_DuzinaStranice = new JLabel("Duzina stranice:  ");
		JLabel lbl_BojaIvice = new JLabel("Boja ivice:  ");
		JLabel lbl_BojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:   ");
		
		txt_X = new JTextField();
		txt_X.setColumns(10);
		txt_Y = new JTextField();
		txt_Y.setColumns(10);
		txt_DuzinaStranice = new JTextField();
		txt_DuzinaStranice.setColumns(10);
		cbx_BojaIvice = new JComboBox<String>();
		cbx_BojaIvice.setBackground(new Color(204, 153, 153));
		cbx_BojaIvice.setModel(new DefaultComboBoxModel<String>(
				new String[] { "plava", "zuta", "siva", "zelena", "crvena", "roze", "bela", "crna" }));
		cbx_BojaUnutrasnjosti = new JComboBox<String>();
		cbx_BojaUnutrasnjosti.setBackground(new Color(204, 153, 153));
		cbx_BojaUnutrasnjosti.setModel(new DefaultComboBoxModel<String>(
				new String[] { "plava", "zuta", "siva", "zelena", "crvena", "roze", "bela", "crna" }));
		
		JButton btn_Promenljivo = new JButton("Potvrdi");
		btn_Promenljivo.setBackground(new Color(204, 153, 153));
		btn_Promenljivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x = Integer.parseInt(txt_X.getText());
					y = Integer.parseInt(txt_Y.getText());
					duzina = Integer.parseInt(txt_DuzinaStranice.getText());
					if (x < 1 || y < 1 || duzina < 1)
						JOptionPane.showMessageDialog(null, "Brojevi moraju biti veci od 0!", "Greska!",JOptionPane.ERROR_MESSAGE);
					else {
					 bojaIvice =(String) cbx_BojaIvice.getSelectedItem();
					 bojaUnustrasnjosti =(String)cbx_BojaUnutrasnjosti.getSelectedItem();
						kreiranKvadrat = new Kvadrat(new Tacka(x, y), duzina, Oblik.pronadjiBojuPoImenu(bojaIvice), Oblik.pronadjiBojuPoImenu(bojaUnustrasnjosti));
						potvrdi=true;
						dispose();
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Niste pravilno uneli vrednosti brojeva!", "Greska!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btn_Odustani = new JButton("Odustani");
		btn_Odustani.setBackground(new Color(204, 153, 153));
		btn_Odustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(20)
									.addComponent(lbl_BojaUnutrasnjosti))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(30)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lbl_Koordinata_X)
										.addComponent(lbl_Koordinata_Y)
										.addComponent(lbl_DuzinaStranice)
										.addComponent(lbl_BojaIvice))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbx_BojaUnutrasnjosti, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbx_BojaIvice, 0, 97, Short.MAX_VALUE)
								.addComponent(txt_Y, 0, 0, Short.MAX_VALUE)
								.addComponent(txt_X, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(txt_DuzinaStranice, 0, 0, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(btn_Promenljivo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_Odustani)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Koordinata_X)
						.addComponent(txt_X, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Koordinata_Y)
						.addComponent(txt_Y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_DuzinaStranice)
						.addComponent(txt_DuzinaStranice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_BojaIvice)
						.addComponent(cbx_BojaIvice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_BojaUnutrasnjosti)
						.addComponent(cbx_BojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Promenljivo)
						.addComponent(btn_Odustani))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	
	public void izbrisiKvadrat(int x,int y,int duzina,String bojaIvice,String bojaUnutrasnjosti)
	{
		setTitle("Da li zelite da izbrisete ovaj kvadrat?");
		txt_X.setText(Integer.toString(x));
		txt_X.setEditable(false);
		txt_Y.setText(Integer.toString(y));
		txt_Y.setEditable(false);
		txt_DuzinaStranice.setText(Integer.toString(duzina));
		txt_DuzinaStranice.setEditable(false);
		cbx_BojaIvice.setSelectedItem(bojaIvice);
		cbx_BojaIvice.setEnabled(false);
		cbx_BojaUnutrasnjosti.setSelectedItem(bojaUnutrasnjosti);
		cbx_BojaUnutrasnjosti.setEnabled(false);
	}
	public void setKreiraniKvadrat(Kvadrat k) {
		kreiranKvadrat=k;
	}
	public Kvadrat getKreiraniKvadrat() {
		return kreiranKvadrat;
	}
	public boolean getPotvrdi() {
		return potvrdi;
	}
	public void setPotvrdi(boolean da) {
		this.potvrdi=da;
	}

}
