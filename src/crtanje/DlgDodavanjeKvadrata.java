package crtanje;


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

public class DlgDodavanjeKvadrata extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_X;
	private JTextField txt_Y;
	private JTextField txtDuzinaStranice;
	private int x,y,stranica;
	private Color bojaIvice=Color.black,bojaUnutrasnjosti=Color.white;
	private boolean potvrdi;
	JButton btnBojaIvice;
	JButton btnBojaUnutrasnjosti;


	public static void main(String[] args) {
		try {
			DlgDodavanjeKvadrata dialog = new DlgDodavanjeKvadrata();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodavanjeKvadrata() {
		getContentPane().setBackground(new Color(255, 255, 204));
		setTitle("Dodaj kvadrat");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 300, 300);
		contentPanel.setBackground(new Color(255, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblKoordinatax = new JLabel("Koordinata x:");
		
		txt_X = new JTextField();
		txt_X.setColumns(10);
		
		JLabel lblKoordinataY = new JLabel("Koordinata y:  ");
		
		txt_Y = new JTextField();
		txt_Y.setColumns(10);
		
		JLabel lblDuzinaStranice = new JLabel("Duzina stranice:  ");
		
		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice:  ");
		
		btnBojaIvice = new JButton("");
		btnBojaIvice.setBackground(new Color(204, 153, 153));
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp= JColorChooser.showDialog(null, "izaberite boju", bojaIvice);
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
					stranica=Integer.parseInt(txtDuzinaStranice.getText());
					if(x<0||y<0||stranica<4)JOptionPane.showMessageDialog(null,"Unete vrednosti moraju biti vece!(0,0,4)", "Greska!",JOptionPane.ERROR_MESSAGE);
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblKoordinataY)
								.addComponent(lblKoordinatax, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDuzinaStranice))
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtDuzinaStranice, 0, 0, Short.MAX_VALUE)
								.addComponent(txt_Y, 0, 0, Short.MAX_VALUE)
								.addComponent(txt_X, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(52)
									.addComponent(lblBojaIvice))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblBojaUnutrasnjosti)))
							.addGap(31)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnBojaIvice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBojaUnutrasnjosti, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_X, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinatax))
					.addGap(13)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_Y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinataY))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(16)
							.addComponent(lblDuzinaStranice))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(13)
							.addComponent(txtDuzinaStranice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBojaIvice)
						.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBojaUnutrasnjosti, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addComponent(btnBojaUnutrasnjosti, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPotvrdi)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOdustani)
							.addGap(16)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPotvrdi)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	//Ukoliko su vec selektovane koordinate i boja
	public void dodajKvadrat(int x,int y,Color ivica,Color unutrasnjost)
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
	public void izmeniPostojeciKvadrat(int x,int y,int stranica,Color ivica,Color unustrasnjost)
	{
		setTitle("Izmeni kvadrat");
		setX(x);
		setY(y);
		setStranica(stranica);
		setBojaIvice(ivica);
		setBojaUnutrasnjosti(unustrasnjost);
		txt_X.setText(Integer.toString(x));
		txt_Y.setText(Integer.toString(y));
		txtDuzinaStranice.setText(Integer.toString(stranica));
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

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
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
