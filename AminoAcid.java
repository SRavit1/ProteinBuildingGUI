import java.awt.*;
import javax.swing.JPanel;

public class AminoAcid extends Canvas{ 
	public boolean mobile;
	
	public String name;
	public String Polarity;
	public double HydropathyIndex;
	public String SideChainCharge;
	
	int r;
	int g;
	int b;
	int x;
	JPanel panel;
	
	AminoAcid (String name, String Polarity, double HydropathyIndex, String SideChainCharge) {
		this.name = name;
		this.Polarity = Polarity;
		this.HydropathyIndex = HydropathyIndex;
		this.SideChainCharge = SideChainCharge;
	}
	public String toString () {
		return name + "\nPolarity: " + Polarity +
				"\nHydropathy Index: " + HydropathyIndex +
				"\nSide Chain Charge: " + SideChainCharge + "\n";
	}
	public void setup (int r, int g, int b, int x, JPanel panel) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.panel = panel;
		setBounds(x, 50, 50, 50);
		setBackground(new Color(r, g, b));
		panel.add(this);
		addMouseMotionListener(new GUI.box_dragged());
		addMouseListener(new GUI.box_dragged());
	}
	public AminoAcid clone () {
		AminoAcid clone = new AminoAcid(name, Polarity, HydropathyIndex, SideChainCharge);
		clone.r = r;
		clone.g = g;
		clone.b = b;
		clone.x = x;
		clone.panel = panel;
		return clone;
	}
}
