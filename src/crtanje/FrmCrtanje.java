package crtanje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oblici.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCrtanje extends JFrame {

	private JPanel contentPane;
	private PnlCrtez panel = new PnlCrtez();
	JButton btnIzmeni, btnObrisi, btnSelektuj, btnBojaIvice, btnBojaUnutrasnjosti, btnKliknuto;
	private ArrayList<Oblik> iscrtaniOblici = new ArrayList<Oblik>();
	private Oblik selektovanOblik = null;
	private Color izabranaBojaIvice = Color.BLACK;
	private Color izabranaBojaUnutrasnjosti = Color.WHITE;
	private Tacka prvaTacka;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrtanje frame = new FrmCrtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCrtanje() {
		setTitle("IT 53-2016 Lazarevic Aleksandra - Crtanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblDodavanje = new JLabel("Dodavanje");

		JButton btnTacka = new JButton("Tacka");
		btnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skiniSelekciju();
				btnKliknuto = btnTacka;
			}
		});
		btnTacka.setBackground(new Color(204, 153, 153));

		JButton btnLinija = new JButton("Linija");
		btnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skiniSelekciju();
				btnKliknuto = btnLinija;
			}
		});
		btnLinija.setBackground(new Color(204, 153, 153));

		JButton btnKrug = new JButton("Krug");
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skiniSelekciju();
				btnKliknuto = btnKrug;

			}
		});
		btnKrug.setBackground(new Color(204, 153, 153));

		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skiniSelekciju();
				btnKliknuto = btnKvadrat;
			}
		});
		btnKvadrat.setBackground(new Color(204, 153, 153));

		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skiniSelekciju();
				btnKliknuto = btnPravougaonik;
			}
		});
		btnPravougaonik.setBackground(new Color(204, 153, 153));

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JLabel lblModeliranje = new JLabel("Modeliranje  ");

		btnSelektuj = new JButton("Selektuj");
		btnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selektovanOblik != null) {
					skiniSelekciju();
					btnKliknuto = null;
				} else
					btnKliknuto = btnSelektuj;

			}
		});
		btnSelektuj.setBackground(new Color(204, 153, 153));

		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selektovanOblik != null) {
					if (selektovanOblik instanceof Tacka) {
						DlgIzmenaTacke prozor = new DlgIzmenaTacke();
						Tacka tacka = (Tacka) selektovanOblik;
						prozor.izmeniPostojecuTacku(tacka.getX(), tacka.getY(), tacka.getBoja());
						prozor.setVisible(true);
						tacka.setX(prozor.getKorX());
						tacka.setY(prozor.getKorY());
						tacka.setBoja(prozor.getBoja());

					} else if (selektovanOblik instanceof Linija) {
						DlgIzmenaLinije prozor = new DlgIzmenaLinije();
						Linija linija = (Linija) selektovanOblik;
						prozor.izmeniPostojecuLiniju(linija.getPocetna().getX(), linija.getPocetna().getY(),
								linija.getKrajnja().getX(), linija.getKrajnja().getY(), linija.getBoja());
						prozor.setVisible(true);

						linija.getPocetna().setX(prozor.getPocetnaX());
						linija.getPocetna().setY(prozor.getPocetnaY());
						linija.getKrajnja().setX(prozor.getKrajnjaX());
						linija.getKrajnja().setY(prozor.getKrajnjaY());
						linija.setBoja(prozor.getBoja());

					} else if (selektovanOblik instanceof Pravougaonik) {
						DlgDodavanjePravougaonika prozor = new DlgDodavanjePravougaonika();
						Pravougaonik pravo = (Pravougaonik) selektovanOblik;
						prozor.izmeniPostojeciPravougaonik(pravo.getGoreLevo().getX(), pravo.getGoreLevo().getY(),
								pravo.getVisina(), pravo.getStranica(), pravo.getBoja(), pravo.getBojaUnutrasnjosti());
						prozor.setVisible(true);

						pravo.getGoreLevo().setX(prozor.getX());
						pravo.getGoreLevo().setY(prozor.getY());
						pravo.setVisina(prozor.getVisina());
						pravo.setStranica(prozor.getSirina());
						pravo.setBoja(prozor.getBojaIvice());
						pravo.setBojaUnutrasnjosti(prozor.getBojaUnutrasnjosti());

					} else if (selektovanOblik instanceof Kvadrat) {
						DlgDodavanjeKvadrata prozor = new DlgDodavanjeKvadrata();
						Kvadrat kvadrat = (Kvadrat) selektovanOblik;
						prozor.izmeniPostojeciKvadrat(kvadrat.getGoreLevo().getX(), kvadrat.getGoreLevo().getY(),
								kvadrat.getStranica(), kvadrat.getBoja(), kvadrat.getBojaUnutrasnjosti());
						prozor.setVisible(true);

						kvadrat.getGoreLevo().setX(prozor.getX());
						kvadrat.getGoreLevo().setY(prozor.getY());
						kvadrat.setStranica(prozor.getStranica());
						kvadrat.setBoja(prozor.getBojaIvice());
						kvadrat.setBojaUnutrasnjosti(prozor.getBojaUnutrasnjosti());

					} else if (selektovanOblik instanceof Krug) {
						DlgDodavanjeKruga prozor = new DlgDodavanjeKruga();
						Krug krug = (Krug) selektovanOblik;
						prozor.izmeniPostojeciKrug(krug.getCentar().getX(), krug.getCentar().getY(),
								krug.getPoluprecnik(), krug.getBoja(), krug.getBojaUnutrasnjosti());
						prozor.setVisible(true);

						krug.getCentar().setX(prozor.getX());
						krug.getCentar().setY(prozor.getY());
						krug.setPoluprecnik(prozor.getPoluprecnik());
						krug.setBoja(prozor.getBojaIvice());
						krug.setBojaUnutrasnjosti(prozor.getBojaUnutrasnjosti());

					}

				}

			}
		});
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		btnIzmeni.setBackground(new Color(204, 153, 153));
		btnIzmeni.setEnabled(false);

		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgBrisanje prozor = new DlgBrisanje();
				prozor.setVisible(true);
				if (prozor.getPotvrdi() == true) {
					iscrtaniOblici.remove(selektovanOblik);
					panel.getLista().remove(selektovanOblik);
					skiniSelekciju();
				}
			}

		});
		btnObrisi.setBackground(new Color(204, 153, 153));
		btnObrisi.setEnabled(false);

		btnBojaIvice = new JButton("");
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "izaberite boju", izabranaBojaIvice);
				if (temp != null) {
					izabranaBojaIvice = temp;
					btnBojaIvice.setBackground(izabranaBojaIvice);
				}

			}
		});
		btnBojaIvice.setBackground(new Color(0, 0, 0));

		btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color temp = JColorChooser.showDialog(null, "izaberite boju", izabranaBojaUnutrasnjosti);
				if (temp != null) {
					izabranaBojaUnutrasnjosti = temp;
					btnBojaUnutrasnjosti.setBackground(izabranaBojaUnutrasnjosti);
				}
			}
		});
		btnBojaUnutrasnjosti.setBackground(new Color(255, 255, 255));

		JLabel lblIvica = new JLabel(" ivica");
		JLabel lblUnutra = new JLabel("unutra");

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnKliknuto == btnTacka) {
					Tacka trenutna = new Tacka(e.getX(), e.getY(), izabranaBojaIvice);
					panel.getLista().add(trenutna);
					iscrtaniOblici.add(0, trenutna);
				} else if (btnKliknuto == btnLinija) {
					if (prvaTacka == null) {

						prvaTacka = new Tacka(e.getX(), e.getY(), izabranaBojaIvice);
					} else {
						Tacka drugaTacka = new Tacka(e.getX(), e.getY(), izabranaBojaIvice);
						Linija trenutna = new Linija(prvaTacka, drugaTacka, izabranaBojaIvice);
						panel.getLista().add(trenutna);
						iscrtaniOblici.add(0, trenutna);
						prvaTacka = null;
					}

				} else if (btnKliknuto == btnKrug) {
					DlgDodavanjeKruga prozor = new DlgDodavanjeKruga();
					prozor.dodajKrug(e.getX(), e.getY(), izabranaBojaIvice, izabranaBojaUnutrasnjosti);
					prozor.setVisible(true);
						btnBojaIvice.setBackground(prozor.getBojaIvice());
						izabranaBojaIvice = btnBojaIvice.getBackground();
						btnBojaUnutrasnjosti.setBackground(prozor.getBojaUnutrasnjosti());
						izabranaBojaUnutrasnjosti = btnBojaUnutrasnjosti.getBackground();
					Krug trenutni = new Krug(new Tacka(prozor.getX(), prozor.getY()), prozor.getPoluprecnik(),
							prozor.getBojaIvice(), prozor.getBojaUnutrasnjosti());
					panel.getLista().add(trenutni);
					iscrtaniOblici.add(0, trenutni);

				} else if (btnKliknuto == btnKvadrat) {
					DlgDodavanjeKvadrata prozor = new DlgDodavanjeKvadrata();
					prozor.dodajKvadrat(e.getX(), e.getY(), izabranaBojaIvice, izabranaBojaUnutrasnjosti);
					prozor.setVisible(true);
						btnBojaIvice.setBackground(prozor.getBojaIvice());
						izabranaBojaIvice = btnBojaIvice.getBackground();
						btnBojaUnutrasnjosti.setBackground(prozor.getBojaUnutrasnjosti());
						izabranaBojaUnutrasnjosti = btnBojaUnutrasnjosti.getBackground();
					Kvadrat trenutni = new Kvadrat(new Tacka(prozor.getX(), prozor.getY()), prozor.getStranica(),
							prozor.getBojaIvice(), prozor.getBojaUnutrasnjosti());
					panel.getLista().add(trenutni);
					iscrtaniOblici.add(0, trenutni);

				} else if (btnKliknuto == btnPravougaonik) {
					DlgDodavanjePravougaonika prozor = new DlgDodavanjePravougaonika();
					prozor.dodajPravougaonik(e.getX(), e.getY(), izabranaBojaIvice, izabranaBojaUnutrasnjosti);
					prozor.setVisible(true);
						btnBojaIvice.setBackground(prozor.getBojaIvice());
						izabranaBojaIvice = btnBojaIvice.getBackground();
						btnBojaUnutrasnjosti.setBackground(prozor.getBojaUnutrasnjosti());
						izabranaBojaUnutrasnjosti = btnBojaUnutrasnjosti.getBackground();
					Pravougaonik trenutni = new Pravougaonik(new Tacka(prozor.getX(), prozor.getY()),
							prozor.getSirina(), prozor.getVisina(), prozor.getBojaIvice(),
							prozor.getBojaUnutrasnjosti());
					panel.getLista().add(trenutni);
					iscrtaniOblici.add(0, trenutni);

				} else if (btnKliknuto == btnSelektuj) {
					Iterator<Oblik> it = iscrtaniOblici.iterator();
					while (it.hasNext()) {
						Oblik oblik = it.next();
						if (oblik.sadrzi(e.getX(), e.getY())) {
							if (selektovanOblik != null) {
								selektovanOblik.setSelektovan(false);
								selektovanOblik = null;
							}
							oblik.setSelektovan(true);
							selektovanOblik = oblik;
							btnIzmeni.setEnabled(true);
							btnObrisi.setEnabled(true);
							break;
						}
					}
				}
			}
		});

		panel.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnTacka)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLinija)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnKrug)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnKvadrat)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPravougaonik)
							.addGap(48))
						.addComponent(lblDodavanje)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIvica)
									.addGap(19))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnBojaIvice, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnutra)
								.addComponent(btnBojaUnutrasnjosti)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnObrisi, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnIzmeni, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSelektuj, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addComponent(lblModeliranje)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblDodavanje)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnTacka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLinija, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnKrug, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnKvadrat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPravougaonik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnBojaUnutrasnjosti, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
								.addComponent(btnBojaIvice, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIvica)
								.addComponent(lblUnutra))
							.addGap(30)
							.addComponent(lblModeliranje)
							.addGap(18)
							.addComponent(btnSelektuj)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnIzmeni)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnObrisi))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void skiniSelekciju() {
		if (selektovanOblik != null) {
			selektovanOblik.setSelektovan(false);
			selektovanOblik = null;
			btnIzmeni.setEnabled(false);
			btnObrisi.setEnabled(false);
		}
	}

}
