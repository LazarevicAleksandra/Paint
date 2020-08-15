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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDodavanjeKruga extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_X;
	private JTextField txt_Y;
	private JTextField txtPoluprecnik;
	private int x,y,poluprecnik;
	private Color bojaIvice=Color.BLACK,bojaUnutrasnjosti=Color.WHITE;
	private boolean potvrdi;
	JButton btnBojaIvice;
	JButton btnBojaUnutrasnjosti;

	public static void main(String[] args) {
		try {
			DlgDodavanjeKruga dialog = new DlgDodavanjeKruga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodavanjeKruga() {
		setTitle("Dodaj krug");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 325);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblKoordinataX = new JLabel("Koordinata x:");
		txt_X = new JTextField();
		txt_X.setColumns(10);
		
		JLabel lblKoordinataY = new JLabel("Koordinata y:");
		
		txt_Y = new JTextField();
		txt_Y.setColumns(10);
		
		JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
		
		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja Ivice:");
		
		 btnBojaIvice = new JButton("");
		 btnBojaIvice.setBackground(new Color(204, 153, 153));
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp= JColorChooser.showDialog(null, "izaberite boju",bojaIvice );
				if(temp!=null){bojaIvice=temp;btnBojaIvice.setBackground(bojaIvice);}
			}
		});
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
		
		 btnBojaUnutrasnjosti = new JButton("");
		 btnBojaUnutrasnjosti.setBackground(new Color(204, 153, 153));
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp= JColorChooser.showDialog(null, "izaberite boju", bojaUnutrasnjosti);
	 			if(temp!=null){bojaUnutrasnjosti=temp;btnBojaUnutrasnjosti.setBackground(bojaUnutrasnjosti);}
			}
		});
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(204, 153, 153));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x=Integer.parseInt(txt_X.getText());
					y=Integer.parseInt(txt_Y.getText());
					poluprecnik=Integer.parseInt(txtPoluprecnik.getText());
					if(x<0||y<0||poluprecnik<4)JOptionPane.showMessageDialog(null,"Unete vrednosti moraju biti vece!(0,0,4)", "Greska!",JOptionPane.ERROR_MESSAGE);
					else {
						setPotvrdi(true);
						dispose();
					}
					}
				 catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Niste pravilno uneli vrednosti brojeva!", "Greska!",JOptionPane.ERROR_MESSAGE);
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblKoordinataX)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPoluprecnik)
										.addComponent(lblKoordinataY)
										.addComponent(lblBojaIvice)))
								.addComponent(lblBojaUnutrasnjosti))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBojaUnutrasnjosti, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(btnBojaIvice, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(txt_Y, 124, 124, Short.MAX_VALUE)
								.addComponent(txt_X, 124, 124, Short.MAX_VALUE)
								.addComponent(txtPoluprecnik, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(111, Short.MAX_VALUE)
							.addComponent(btnPotvrdi)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOdustani)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataX)
						.addComponent(txt_X, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY)
						.addComponent(txt_Y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoluprecnik)
						.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBojaIvice)
						.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBojaUnutrasnjosti)
						.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPotvrdi)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	//Ukoliko su vec selektovane koordinate i boja
	public void dodajKrug(int x,int y,Color ivica,Color unutrasnjost)
	{
		
		setX(x);
		setY(y);
		setBojaIvice(ivica);
		setBojaUnutrasnjosti(unutrasnjost);
		txt_X.setText(Integer.toString(x));
		txt_Y.setText(Integer.toString(y));
		txt_X.setEditable(false);
		txt_Y.setEditable(false);
		btnBojaIvice.setBackground(ivica);
		btnBojaUnutrasnjosti.setBackground(unutrasnjost);
		
	}
	public void izmeniPostojeciKrug(int x,int y,int r,Color ivica,Color unustrasnjost)
	{
		setTitle("Izmeni krug");
		setX(x);
		setY(y);
		setPoluprecnik(r);
		setBojaIvice(ivica);
		setBojaUnutrasnjosti(unustrasnjost);
		txt_X.setText(Integer.toString(x));
		txt_Y.setText(Integer.toString(y));
		txtPoluprecnik.setText(Integer.toString(r));
		btnBojaIvice.setBackground(ivica);
		btnBojaUnutrasnjosti.setBackground(unustrasnjost);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public Color getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public boolean getPotvrdi() {
		return potvrdi;
	}

	public void setPotvrdi(boolean potvrdi) {
		this.potvrdi = potvrdi;
	}


}
