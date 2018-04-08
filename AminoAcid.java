import java.awt.*;

import javax.swing.JPanel;

public class AminoAcid extends Canvas{ 
	public String name;
	
	public String Polarity;
	public double HydropathyIndex;
	public String SideChainCharge;
	
	int r;
	int g;
	int b;
	int x;
	int y = 50;
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
	    
		setBounds(x, y, 75, 75);
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

	public boolean snap (int test_x, int test_y) {
		//PURPOSE: TEST ON A CASE BY CASE BASIS WHETHER A SET OF POINTS ARE CLOSE ENOUGH TO BE SNAPPED TO THE EXISTING AMINO ACID
		boolean can_snap = false;
		if (test_x < x + 70 && test_x > x && test_y > y && test_y < y+50) {
			can_snap = true;
		}
		return can_snap;
	}
	public int snapx (int test_x, int test_y) {
		//PURPOSE: IF TWO POINTS ARE SNAPPABLE TO THE EXISTING AMINO ACID, PROVIDE THE SNAPPED X VALUE
		int new_x = test_x;
		if (snap(test_x, test_y) == true) {
			new_x = x + 40;
		}
		return new_x;
	}
	public int snapy (int test_x, int test_y) {
		//PURPOSE: IF TWO POINTS ARE SNAPPABLE TO THE EXISTING AMINO ACID, PROVIDE THE SNAPPED Y VALUE
		int new_y = test_y;
		if (snap(test_x, test_y) == true) {
			new_y = y;
		}
		return new_y;
	}
}
