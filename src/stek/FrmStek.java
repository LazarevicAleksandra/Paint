package stek;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import oblici.Kvadrat;
import oblici.Oblik;

import java.util.Iterator;
import java.util.Stack;
import javax.swing.DefaultListModel;
import java.awt.Color;

public class FrmStek extends JFrame {

	private JPanel contentPane;
	private Stack<Kvadrat> stekKvadrata = new Stack<Kvadrat>();
	private DefaultListModel<Kvadrat> dlm = new DefaultListModel<Kvadrat>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStek frame = new FrmStek();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmStek() {
		setBackground(new Color(204, 153, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT 53-2016 Lazarevic Aleksandra");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnDodajNaStek = new JButton("Dodaj na stek");
		btnDodajNaStek.setBackground(new Color(204, 153, 153));
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgDodajNaStek prozorDodaj = new DlgDodajNaStek();
				prozorDodaj.setVisible(true);
				if (prozorDodaj.getPotvrdi() == true) {
					Kvadrat trenutni = prozorDodaj.getKreiraniKvadrat();
					stekKvadrata.push(trenutni);
					prozorDodaj.setPotvrdi(false);
					ispisi();
				}
			}
		});

		JButton btnSkiniSaSteka = new JButton("Skini sa steka");
		btnSkiniSaSteka.setBackground(new Color(204, 153, 153));
		btnSkiniSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stekKvadrata.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nema nijednog elementa za brisanje!");
				} else {
					DlgDodajNaStek prozorUkloni = new DlgDodajNaStek();
					prozorUkloni.izbrisiKvadrat(stekKvadrata.peek().getGoreLevo().getX(),
							stekKvadrata.peek().getGoreLevo().getY(), stekKvadrata.peek().getStranica(),
							Oblik.pronadjiBoju(stekKvadrata.peek().getBoja()),Oblik.pronadjiBoju(stekKvadrata.peek().getBojaUnutrasnjosti()));
							prozorUkloni.setVisible(true);
					if (prozorUkloni.getPotvrdi() == true) {
						stekKvadrata.pop();
						prozorUkloni.setPotvrdi(false);
						ispisi();
					}
				}
			}
		});
		

		JScrollPane scrollPane = new JScrollPane();
		JList<Kvadrat> lista = new JList<Kvadrat>();
		lista.setModel(dlm);
		scrollPane.setViewportView(lista);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(28).addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(171, Short.MAX_VALUE)
										.addComponent(btnDodajNaStek).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnSkiniSaSteka)))
						.addGap(17)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnDodajNaStek).addComponent(btnSkiniSaSteka))
								.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
	public void ispisi() {
		Iterator<Kvadrat> it=stekKvadrata.iterator();
		dlm.removeAllElements();
		while(it.hasNext())
			dlm.add(0,it.next());
	}
}
