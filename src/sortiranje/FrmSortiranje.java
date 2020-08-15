package sortiranje;

import oblici.Kvadrat;
import oblici.Oblik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stek.DlgDodajNaStek;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class FrmSortiranje extends JFrame {

	private JPanel contentPane;
	private ArrayList<Kvadrat> listaKvadrata=new ArrayList<Kvadrat>();
	JList<Kvadrat> lst_KvadratiZaSortiranje = new JList<Kvadrat>();
	DefaultListModel<Kvadrat> listModel = new DefaultListModel<>();
///////////////////////////	scrollPane_1.setViewportView(lstObicna);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSortiranje frame = new FrmSortiranje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmSortiranje() {
		setTitle("IT 53-2016 Lazarevic Aleksandra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		lst_KvadratiZaSortiranje.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btn_Obrisi = new JButton("Obrisi");
		btn_Obrisi.setBackground(new Color(204, 153, 153));
		btn_Obrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indeks=lst_KvadratiZaSortiranje.getSelectedIndex();
				if(indeks>=0)
				{
					Kvadrat trenutni=listaKvadrata.get(indeks);
					DlgDodajNaStek prozor=new DlgDodajNaStek();
					prozor.izbrisiKvadrat(trenutni.getGoreLevo().getX(),trenutni.getGoreLevo().getY(),trenutni.getStranica(),
							Oblik.pronadjiBoju(trenutni.getBoja()),Oblik.pronadjiBoju(trenutni.getBojaUnutrasnjosti()));
					prozor.setVisible(true);
					if(prozor.getPotvrdi()==true) {
						listaKvadrata.remove(indeks);
						IspisiListu();
					}
				}else {
					 JOptionPane.showMessageDialog(null,"Niste selektovali kvadrat iz liste!");
				}
			}
		});
		
		JButton btn_Sortiraj = new JButton("Sortiraj");
		btn_Sortiraj.setBackground(new Color(204, 153, 153));
		btn_Sortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sortiranje(listaKvadrata);
			}
		});
		
		JButton btn_Dodaj = new JButton("Dodaj kvadrat");
		btn_Dodaj.setBackground(new Color(204, 153, 153));
		btn_Dodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDodajNaStek prozorDodaj = new DlgDodajNaStek();
				prozorDodaj.setVisible(true);
				if (prozorDodaj.getPotvrdi() == true) {
					Kvadrat trenutni = prozorDodaj.getKreiraniKvadrat();
					listaKvadrata.add(trenutni);
					prozorDodaj.setPotvrdi(false);
					IspisiListu();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		lst_KvadratiZaSortiranje.setModel(listModel);
		scrollPane.setViewportView(lst_KvadratiZaSortiranje);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Dodaj)
							.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
							.addComponent(btn_Sortiraj)
							.addGap(18)
							.addComponent(btn_Obrisi, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Obrisi)
						.addComponent(btn_Dodaj)
						.addComponent(btn_Sortiraj))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void Sortiranje(ArrayList<Kvadrat>lista) {
		lista.sort(null);
		Iterator<Kvadrat> it=lista.iterator();
		listModel.removeAllElements();
		while(it.hasNext())
			listModel.addElement(it.next());
		
	}
	
	public void IspisiListu() {
		Iterator<Kvadrat> it=listaKvadrata.iterator();
		listModel.removeAllElements();
		while(it.hasNext())
			listModel.addElement(it.next());
	}
}
