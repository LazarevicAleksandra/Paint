package oblici;
import java.awt.Color;
import java.awt.Graphics;
public class Tacka extends Oblik{
	private int x;
	private int y;
	public Tacka() {}
	public Tacka(int x, int y) {
		this.x = x;
		this.y=y;
	}
	public Tacka(int x, int y, Color boja) {
		this(x, y);
		setBoja(boja);
	}

	public void pomeriNa(int x, int y) {
		this.x = x;
		this.y=y;
	}
	public void pomeriZa(int x, int y) {
		this.x += x;
		this.y +=y;
	}

	public double udaljenost(Tacka t) {
		int dX = x - t.x;
		int dY = y - t.y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object obj) {
		if(obj instanceof Tacka) {
			Tacka prosledjena = (Tacka)obj;
			if (this.x == prosledjena.getX() && this.y == prosledjena.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelektovan())
			selektovan(g);
	}
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}
	public int compareTo(Object o) {
		if(o instanceof Tacka) {
			Tacka pocetak = new Tacka(0, 0);
			return (int) (this.udaljenost(pocetak) - ((Tacka) o).udaljenost(pocetak));
		}
		else
			return 0;
	}
	public boolean sadrzi(int x, int y) {
		if(new Tacka(x,y).udaljenost(this) < 2 )
			return true;
		return false;
	}
	public int getX() {
		return x;
	}
	public void setX(int novoX) {
		x = novoX;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}


}
