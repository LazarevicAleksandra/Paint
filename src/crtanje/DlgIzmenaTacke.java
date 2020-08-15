package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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

public class DlgIzmenaTacke extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_X;
	private JTextField txt_Y;
	private JButton btnBojaTacke;
	private int korX,korY;
	private Color boja=Color.BLACK;
	private boolean potvrdi;

	public static void main(String[] args) {
		try {
			DlgIzmenaTacke dialog = new DlgIzmenaTacke();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgIzmenaTacke() {
		setTitle("Izmeni tacku");
		setBounds(100, 100, 300, 300);
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
		
		JLabel lblBoja = new JLabel("Boja:");
		
		btnBojaTacke = new JButton("");
		btnBojaTacke.setBackground(new Color(204, 153, 153));
		btnBojaTacke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp= JColorChooser.showDialog(null, "izaberite boju", boja);
	 			if(temp!=null){boja=temp;btnBojaTacke.setBackground(boja);}
			}
		});
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.setBackground(new Color(204, 153, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					korX=Integer.parseInt(txt_X.getText());
					korY=Integer.parseInt(txt_Y.getText());
					if(korX<0||korX<0)JOptionPane.showMessageDialog(null,"Unete vrednosti moraju biti vece od -1!", "Greska!",JOptionPane.ERROR_MESSAGE);
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
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBoja)
						.addComponent(lblKoordinataY)
						.addComponent(lblKoordinataX))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBojaTacke, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txt_Y, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(txt_X, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOdustani)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataX)
						.addComponent(txt_X, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY)
						.addComponent(txt_Y, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBoja)
						.addComponent(btnBojaTacke, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnOdustani))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	public void izmeniPostojecuTacku(int x,int y,Color boja)
	{
		setKorX(x);
		setKorY(y);
		setBoja(boja);
		txt_X.setText(Integer.toString(x));
		txt_Y.setText(Integer.toString(y));
		btnBojaTacke.setBackground(boja);
	}

	public int getKorX() {
		return korX;
	}

	public void setKorX(int korX) {
		this.korX = korX;
	}

	public int getKorY() {
		return korY;
	}

	public void setKorY(int korY) {
		this.korY = korY;
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
