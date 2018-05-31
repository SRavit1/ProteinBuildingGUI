import java.awt.*;
import javax.swing.*;

public class AminoAcid extends Label{
	
	//Creation of fields
	public boolean mobile;
	
	public String name_1letter;
	public String name_3;
	public String full_name;
	
	public boolean Polarity;
	public double HydropathyIndex;
	public String SideChainCharge;
	
	int r;
	int g;
	int b;
	int x;
	JPanel panel;
	
	AminoAcid (String full_name, Boolean Polarity, double HydropathyIndex, String SideChainCharge, String name_3, String name_1letter) {
		//This constructor sets the fields of the object according to the parameters
		this.name_1letter = name_1letter;
		this.name_3 = name_3;
		this.full_name = full_name;
		
		this.Polarity = Polarity;
		this.HydropathyIndex = HydropathyIndex;
		this.SideChainCharge = SideChainCharge;
	}
	
	public void setup (int r, int g, int b, int x, JPanel panel) {
		//Setting the value of the fields of AminoAcid equal to the parameters passed in
		this.r = r;
		this.g = g;
		this.b = b;
		this.x = x;
		this.panel = panel;
		
		//Setting the bounds and color of the object according to the parameters
		setBounds(x*2/3, 50*2/3, 50*2/3, 50*2/3);
		setBackground(new Color(r, g, b));
		panel.add(this);
		
		//Adding mouse listener and mouse motion listener to AminoAcid
		addMouseMotionListener(new GUI.box_mouselistener());
		addMouseListener(new GUI.box_mouselistener());
		
		//Labeling the AminoAcid with its abbreviation
		this.setAlignment(Label.CENTER);
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		this.setText(name_3);
	}
	
	public AminoAcid clone () {
		//This method creates and returns a new AminoAcid with most of the same fields
		AminoAcid clone = new AminoAcid(full_name, Polarity, HydropathyIndex, SideChainCharge, name_3, name_1letter);
		clone.setup(r, g, b, x, panel);
		return clone;
	}
}
