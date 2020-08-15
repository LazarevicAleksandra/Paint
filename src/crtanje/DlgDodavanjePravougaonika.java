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

public class DlgDodavanjePravougaonika extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_X;
	private JTextField txt_Y;
	private JTextField txtVisina;
	private JTextField txtSirina;
	private int x,y,sirina,visina;
	private Color bojaIvice=Color.black,bojaUnutrasnjosti=Color.white;
	private boolean potvrdi=false;
	JButton btnBojaIvice;
	JButton btnBojaUnutrasnjosti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDodavanjePravougaonika dialog = new DlgDodavanjePravougaonika();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodavanjePravougaonika() {
		setTitle("Dodaj Pravougaonik");
		setBounds(100, 100, 300, 350);
		setModal(true);
		setResizable(false);
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
		
		JLabel lblDuzina = new JLabel("Visina:");
		
		txtVisina = new JTextField();
		txtVisina.setText("");
		txtVisina.setColumns(10);
		
		JLabel lblSirina = new JLabel("Sirina:");
		
		txtSirina = new JTextField();
		txtSirina.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		
		 btnBojaIvice = new JButton("");
		 btnBojaIvice.setBackground(new Color(204, 153, 153));
		 btnBojaIvice.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Color temp= JColorChooser.showDialog(null, "izaberite boju",bojaIvice );
				if(temp!=null){bojaIvice=temp;btnBojaIvice.setBackground(bojaIvice);}
		 	}
		 });
		
		JLabel lblUnutrasnjost = new JLabel("Unutrasnjost:");
		
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
					visina=Integer.parseInt(txtVisina.getText());
					sirina=Integer.parseInt(txtSirina.getText());
					if(x<0||y<0||visina<4||sirina<4)JOptionPane.showMessageDialog(null,"Unete vrednosti moraju biti vece!(0,0,4,4)", "Greska!",JOptionPane.ERROR_MESSAGE);
					else {
						potvrdi=true;
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
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUnutrasnjost)
						.addComponent(lblBojaIvice)
						.addComponent(lblSirina)
						.addComponent(lblDuzina)
						.addComponent(lblKoordinataY)
						.addComponent(lblKoordinataX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBojaUnutrasnjosti, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
						.addComponent(btnBojaIvice, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txt_X)
							.addComponent(txt_Y)
							.addComponent(txtVisina)
							.addComponent(txtSirina)))
					.addGap(25))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addComponent(btnPotvrdi)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOdustani)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_X, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinataX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY)
						.addComponent(txt_Y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuzina)
						.addComponent(txtVisina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSirina)
						.addComponent(txtSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBojaIvice)
						.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnutrasnjost)
						.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPotvrdi)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	//Ukoliko su vec selektovane koordinate i boja
		public void dodajPravougaonik(int x,int y,Color ivica,Color unutrasnjost)
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

		public void izmeniPostojeciPravougaonik(int x,int y,int visina,int sirina,Color ivica,Color unustrasnjost)
		{
			setTitle("Izmeni Pravougaonik");
			setX(x);
			setY(y);
			setVisina(visina);
			setSirina(sirina);
			setBojaIvice(ivica);
			setBojaUnutrasnjosti(unustrasnjost);
			txt_X.setText(Integer.toString(x));
			txt_Y.setText(Integer.toString(y));
			txtVisina.setText(Integer.toString(visina));
			txtSirina.setText(Integer.toString(sirina));
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

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
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
