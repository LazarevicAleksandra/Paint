package oblici;
import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat {
private int visina;
	
	public Pravougaonik() {}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina) {
		this.goreLevo = goreLevo;
		stranica = sirina;
		this.visina = visina;
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja) {
		this(goreLevo, sirina, visina);
		setBoja(boja);
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja,Color unutrasnjost) {
		this(goreLevo, sirina, visina);
		setBoja(boja);
		setBojaUnutrasnjosti(unutrasnjost);
	}
	public double povrsina() {
		return stranica * this.visina;
	}
	public double obim() {
		return 2*stranica + 2*visina;
	}
	
	public String toString() {
		return "Tacka gore levo=" + goreLevo +  ", sirina =" + stranica + ", visina=" + visina;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Pravougaonik) {
			Pravougaonik prosledjen = (Pravougaonik) obj;
			if(goreLevo.equals(prosledjen.goreLevo) && 
					stranica == prosledjen.stranica && 
							visina == prosledjen.visina)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), visina, stranica);
		popuniUnutrasnjost(g);
		if (isSelektovan())
			selektovan(g);
	}
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+visina, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+visina, getGoreLevo().getY()),new Tacka(getGoreLevo().getX()+visina, getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica), new Tacka(getGoreLevo().getX()+visina, getGoreLevo().getY()+stranica)).selektovan(g);
	}
	public void popuniUnutrasnjost(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, visina-1, stranica-1);
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + visina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + stranica))
			return true;
		else 
			return false;
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
}
