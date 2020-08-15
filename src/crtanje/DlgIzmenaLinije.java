package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgIzmenaLinije extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_XPocetna;
	private JTextField txt_YPocetna;
	private JTextField txt_XKrajnja;
	private JTextField txt_YKrajnja;
	private int pocetnaX,pocetnaY,krajnjaX,krajnjaY;
	private Color boja=Color.BLACK;
	private JButton btnBojaLinije;
	private boolean potvrdi;
	
	public static void main(String[] args) {
		try {
			DlgIzmenaLinije dialog = new DlgIzmenaLinije();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgIzmenaLinije() {
		setTitle("Izmeni liniju");
		setBounds(100, 100, 300, 350);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		
		JLabel lblPocetnaTacka = new JLabel("Pocetna tacka");
		
		JLabel lblKoordinataX = new JLabel("Koordinata x:");
		
		txt_XPocetna = new JTextField();
		txt_XPocetna.setColumns(10);
		
		JLabel lblKoordinataY = new JLabel("Koordinata y:");
		
		txt_YPocetna = new JTextField();
		txt_YPocetna.setColumns(10);
		
		JLabel lblKrajnjaTacka = new JLabel("Krajnja tacka");
		
		JLabel lblKoordinataX_1 = new JLabel("Koordinata x:");
		
		txt_XKrajnja = new JTextField();
		txt_XKrajnja.setColumns(10);
		
		JLabel lblKoordinataY_1 = new JLabel("Koordinata y:");
		
		txt_YKrajnja = new JTextField();
		txt_YKrajnja.setColumns(10);
		
		JLabel lblBoja = new JLabel("Boja");
		
		 btnBojaLinije = new JButton("");
		 btnBojaLinije.setBackground(new Color(204, 153, 153));
		btnBojaLinije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp= JColorChooser.showDialog(null, "izaberite boju", boja);
	 			if(temp!=null){boja=temp;btnBojaLinije.setBackground(boja);}
			}
		});
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(204, 153, 153));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pocetnaX=Integer.parseInt(txt_XPocetna.getText());
					pocetnaY=Integer.parseInt(txt_YPocetna.getText());
					krajnjaX=Integer.parseInt(txt_XKrajnja.getText());
					krajnjaY=Integer.parseInt(txt_YKrajnja.getText());
					if(pocetnaX<0||pocetnaY<0||krajnjaX<0||krajnjaY<0)JOptionPane.showMessageDialog(null,"Unete vrednosti moraju biti vece od -1!", "Greska!",JOptionPane.ERROR_MESSAGE);
					else {
						potvrdi=true;
						dispose();
					}
					}
				 catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Niste pravilno uneli vrednosti brojeva!");
				}
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
							.addContainerGap()
							.addComponent(lblPocetnaTacka))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblKrajnjaTacka))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
									.addGap(57)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblKoordinataY)
										.addComponent(lblKoordinataX))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txt_YPocetna, 0, 0, Short.MAX_VALUE)
										.addComponent(txt_XPocetna, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
									.addGap(60)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblKoordinataY_1)
										.addComponent(lblKoordinataX_1)
										.addComponent(lblBoja, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txt_XKrajnja, 0, 0, Short.MAX_VALUE)
										.addComponent(txt_YKrajnja, 0, 0, Short.MAX_VALUE)
										.addComponent(btnBojaLinije, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
					.addGap(15))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOdustani, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblPocetnaTacka)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_XPocetna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinataX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY)
						.addComponent(txt_YPocetna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblKrajnjaTacka)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataX_1)
						.addComponent(txt_XKrajnja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY_1)
						.addComponent(txt_YKrajnja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBoja)
						.addComponent(btnBojaLinije, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPotvrdi)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	public void izmeniPostojecuLiniju(int px,int py,int kx,int ky,Color boja)
	{
		setTitle("Izmeni Liniju");
		setPocetnaX(px);
		setPocetnaY(py);
		setKrajnjaX(kx);
		setKrajnjaY(ky);
		setBoja(boja);
		txt_XPocetna.setText(Integer.toString(px));
		txt_YPocetna.setText(Integer.toString(py));
		txt_XKrajnja.setText(Integer.toString(kx));
		txt_YKrajnja.setText(Integer.toString(ky));
		btnBojaLinije.setBackground(boja);
	}

	public int getPocetnaX() {
		return pocetnaX;
	}

	public void setPocetnaX(int pocetnaX) {
		this.pocetnaX = pocetnaX;
	}

	public int getPocetnaY() {
		return pocetnaY;
	}

	public void setPocetnaY(int pocetnaY) {
		this.pocetnaY = pocetnaY;
	}

	public int getKrajnjaX() {
		return krajnjaX;
	}

	public void setKrajnjaX(int krajnjaX) {
		this.krajnjaX = krajnjaX;
	}

	public int getKrajnjaY() {
		return krajnjaY;
	}

	public void setKrajnjaY(int krajnjaY) {
		this.krajnjaY = krajnjaY;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public boolean getPotvrdi() {
		return potvrdi;
	}

	public void setPotvrdi(boolean potvrdi) {
		this.potvrdi = potvrdi;
	}

	
}
