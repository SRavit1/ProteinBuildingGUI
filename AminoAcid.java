import java.awt.*;
import javax.swing.*;

public class AminoAcid extends Label{
	
	public boolean mobile;
	public boolean in_chain;
	
	public String name;
	public String short_name;
	public boolean Polarity;
	public double HydropathyIndex;
	public String SideChainCharge;
	
	int r;
	int g;
	int b;
	int x;
	JPanel panel;
	
	AminoAcid (String name, Boolean Polarity, double HydropathyIndex, String SideChainCharge, String short_name) {
		//This constructor sets the fields of the object according to the parameters
		this.name = name;
		this.Polarity = Polarity;
		this.HydropathyIndex = HydropathyIndex;
		this.SideChainCharge = SideChainCharge;
		
		this.short_name = short_name;
	}
	
	public void setup (int r, int g, int b, int x, JPanel panel) {
		//Setting the value of the fields of AminoAcid equal to the parameters passed in
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.panel = panel;
		
		//Setting the bounds and color of the object according to the parameters
		setBounds(x, 50, 50, 50);
		setBackground(new Color(r, g, b));
		panel.add(this);
		
		//Adding mouse listener and mouse motion listener to AminoAcid
		addMouseMotionListener(new GUI.box_mouselistener());
		addMouseListener(new GUI.box_mouselistener());
		
		//Labeling the AminoAcid with its abbreviation
		Font font = new Font("Arial", Font.CENTER_BASELINE, 14);
		this.setAlignment(Label.CENTER);
		this.setFont(font);
		this.setText(short_name);
	}
	public AminoAcid clone () {
		//This method creates and returns a new AminoAcid with most of the same fields
		AminoAcid clone = new AminoAcid(name, Polarity, HydropathyIndex, SideChainCharge, short_name);
		clone.r = r;
		clone.g = g;
		clone.b = b;
		clone.x = x;
		clone.panel = panel;
		return clone;
	}
}
