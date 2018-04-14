import java.awt.*;
import javax.swing.*;

public class AminoAcid extends Label{
	
	public boolean mobile;
	
	public String full_name;
	public String name_3letter;
	public String name_1letter;
	
	public boolean Polarity;
	public double HydropathyIndex;
	public String SideChainCharge;
	
	int r;
	int g;
	int b;
	int x;
	JPanel panel;
	
	AminoAcid (String full_name, Boolean Polarity, double HydropathyIndex, String SideChainCharge, String name_3letter, String name_1letter) {
		//This constructor sets the fields of the object according to the parameters
		this.full_name = full_name;
		this.Polarity = Polarity;
		this.HydropathyIndex = HydropathyIndex;
		this.SideChainCharge = SideChainCharge;
		
		this.name_3letter = name_3letter;
		this.name_1letter = name_1letter;
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
		this.setText(name_3letter);
	}
	public AminoAcid clone () {
		//This method creates and returns a new AminoAcid with most of the same fields
		AminoAcid clone = new AminoAcid(full_name, Polarity, HydropathyIndex, SideChainCharge, name_3letter, name_1letter);
		clone.r = r;
		clone.g = g;
		clone.b = b;
		clone.x = x;
		clone.panel = panel;
		return clone;
	}
}
