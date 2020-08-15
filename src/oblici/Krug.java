package oblici;
import java.awt.Color;
import java.awt.Graphics;

import oblici.Tacka;
public class Krug extends PovrsinskiOblik{
	private Tacka centar;
	private int poluprecnik;

	public Krug() {}
	public Krug(Tacka centar, int poluprecnik) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
	}
	public Krug(Tacka centar, int poluprecnik, Color boja) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
		setBoja(boja);
	}
	public Krug(Tacka centar, int poluprecnik, Color boja,Color unutrasnjost) {
		this(centar, poluprecnik);
		setBoja(boja);
		setBojaUnutrasnjosti(unutrasnjost);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Krug) {
			Krug prosledjen = (Krug) obj;
			if(centar.equals(prosledjen.centar) && poluprecnik == prosledjen.poluprecnik)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void pomeriZa(int poX, int poY){
		centar.pomeriZa(poX, poY);
	}
	public void pomeriNa(int x, int y) {
		centar.pomeriNa(x, y);
	}
	
	public double obim() {
		return 2*poluprecnik*Math.PI;
	}
	public double povrsina() {
		return poluprecnik*poluprecnik*Math.PI;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawOval(centar.getX() - poluprecnik, centar.getY() - poluprecnik, 2*poluprecnik, 2*poluprecnik);
		popuniUnutrasnjost(g);
		if(isSelektovan())
			selektovan(g);
	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		new Linija(new Tacka(centar.getX(), centar.getY()-poluprecnik), 
				new Tacka(centar.getX(), centar.getY() + poluprecnik)).selektovan(g);
		new Linija(new Tacka(centar.getX()-poluprecnik, centar.getY()), 
				new Tacka(centar.getX()+poluprecnik, centar.getY())).selektovan(g);
	}
	public int compareTo(Object o) {
		if(o instanceof Krug){
			return (int) (this.poluprecnik-((Krug) o).poluprecnik);
		}
		else 
			return 0;
	}
	public void popuniUnutrasnjost(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillOval(centar.getX()-poluprecnik+1, centar.getY()-poluprecnik+1, 2*poluprecnik-2, 2*poluprecnik-2);
	}
	public boolean sadrzi(int x, int y) {
		if(new Tacka(x, y).udaljenost(getCentar()) <= poluprecnik)
			return true;
		else
			return false;
	}
	// centar kruga = (x,y), poluprecnik = r
	public String toString() {
		return "centar kruga = "+centar+", poluprecnik = "+poluprecnik;
	}

	public Tacka getCentar() {
		return centar;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

}
