package crtanje;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import oblici.Oblik;

public class PnlCrtez extends JPanel {

	private ArrayList<Oblik> listaObjekata=new ArrayList<Oblik>();
	public PnlCrtez() {
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for (Oblik obl: listaObjekata) 
			obl.crtajSe(g);
		repaint();
	}
	public ArrayList<Oblik> getLista() {
		return listaObjekata;
	}

	public void setLista(ArrayList<Oblik> lista) {
		this.listaObjekata = lista;
	}

}
