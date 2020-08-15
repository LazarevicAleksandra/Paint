package oblici;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Pomerljiv,Comparable<Object>{
	private Color boja;
	private boolean selektovan;
	
	public Oblik() {}
	public Oblik(Color boja) {
		this.boja=boja;
	}
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x,int y);
	
	public static Color pronadjiBojuPoImenu(String boja) {
		if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		if (boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		if (boja.equalsIgnoreCase("siva"))
			return Color.GRAY;
		if (boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		if (boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		if (boja.equalsIgnoreCase("roze"))
			return Color.PINK;
		if (boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else 
			return Color.BLACK;
	}
	public static String pronadjiBoju(Color boja) {	
		if(boja==Color.BLUE)
			return "plava";
		else if(boja==Color.YELLOW)
			return"zuta";
		else if(boja==Color.GRAY)
			return"siva";
		else if(boja==Color.GREEN)
			return "zelena";
		else if(boja==Color.RED)
			return "crvena";
		else if(boja==Color.PINK)
			return "roze";
		else if(boja==Color.WHITE)
			return "bela";
		else 
			return "crna";
	}
	public Color getBoja() {
		return boja;
	}
	public void setBoja(Color boja) {
		this.boja=boja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan=selektovan;
	}

}
