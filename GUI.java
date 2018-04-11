import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
 
public class GUI extends JFrame {
	public GUI() {
		super ();
	}
	public GUI(String string) {
		super (string);
	}
	
	static AminoAcid alanine = new AminoAcid ("ALANINE", "Nonpolar", 1.8, "Neutral");
	static AminoAcid arginine = new AminoAcid ("ARGININE", "Polar", -4.5, "Basic");
	static AminoAcid asparagine = new AminoAcid ("ASPARAGINE","Polar",-4.5,"Neutral");
	static AminoAcid AsparticAcid = new AminoAcid ("ASPARTIC ACID","Polar", -3.5,"Acidic");
	static AminoAcid cysteine = new AminoAcid ("CYSTEINE","Polar",2.5,"Neutral");
	static AminoAcid GlutamicAcid = new AminoAcid ("GLUTAMIC ACID","Polar",-3.5,"Acidic");
	static AminoAcid glutamine = new AminoAcid ("GLUTAMINE","Polar",-3.5,"Neutral");
	static AminoAcid glycine = new AminoAcid ("GLYCINE","Nonpolar",-0.4,"Neutral");
	static AminoAcid histidine = new AminoAcid ("HISTIDINE","Polar",-3.2,"Basic");
	static AminoAcid isoleucine = new AminoAcid ("ISOLEUCINE","Nonpolar",4.5,"Neutral");
	static AminoAcid leucine = new AminoAcid ("LEUCINE","Nonpolar",3.8,"Neutral");
	static AminoAcid lysine = new AminoAcid ("LYSINE","Polar",-3.9,"Basic");
	static AminoAcid methionine = new AminoAcid ("METHIONINE","Nonpolar",1.9,"Neutral");
	static AminoAcid phenylalanine = new AminoAcid ("PHENYLALANINE","Nonpolar",2.8,"Neutral");
	static AminoAcid proline = new AminoAcid ("PROLINE","Nonpolar",-1.6,"Neutral");
	static AminoAcid serine = new AminoAcid ("SERINE","Polar",-0.8,"Neutral");
	static AminoAcid threonine = new AminoAcid ("THREONINE","Polar",-0.7,"Neutral");
	static AminoAcid tryptophan = new AminoAcid ("TRYPTOPHAN","Nonpolar",-0.9,"Neutral");
	static AminoAcid tyrosine = new AminoAcid ("TYROSINE","Polar",-1.3,"Neutral");
	static AminoAcid valine = new AminoAcid ("VALINE","Nonpolar",4.2,"Neutral");
	
	public static void main(String[] args) { 
		//SETTING UP THE FRAME
		JFrame frame = new JFrame("Protein GUI");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(2000, 1000);
	    frame.setVisible(true);
	    
	    //ADDING PANEL TO FRAME
	   /* JPanel panel = new JPanel();
	    frame.add(panel);
	    JPanel panel2 = new JPanel(); 
	    panel2.setPreferredSize(new Dimension(200,100)); 
	   
	    frame.add(panel2, BorderLayout.CENTER); */ 
	   
	    
	    //CREATING AND ADDING BUTTON TO PANEL
	    /* JButton button = new JButton("RUN"); 
	    button.setPreferredSize(new Dimension (100,100));
	    panel.add(button); */ 
	    
	    //ADDING ACTION LISTENER TO BUTTON - SEE button_clicked
	    /* button.addActionListener(new button_clicked());*/ 
	   
	    JPanel panel = new JPanel();
	       panel.setSize(2000, 250);
	       panel.setBackground(Color.WHITE);
	       panel.setVisible(true);

	       JPanel panel2 = new JPanel();
	       panel2.setSize(2000, 750);
	       panel2.setBackground(Color.PINK);
	       panel2.setVisible(true);

	       JSplitPane splitPane = new JSplitPane();
	       splitPane.setSize(2000, 1000);
	       splitPane.setDividerSize(0);
	       splitPane.setDividerLocation(50);
	       splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	       splitPane.setLeftComponent(panel);
	       splitPane.setRightComponent(panel2);
	       
	       frame.add(panel); 
	       frame.add(panel2); 

	    alanine.setup(50, 0, 0, 50, panel);
	    arginine.setup(50, 50, 0, 150, panel);
	    asparagine.setup(255, 0, 0, 250, panel);
	    AsparticAcid.setup(50, 100, 50, 350, panel);
	    cysteine.setup(0, 0, 150, 450, panel);
	    GlutamicAcid.setup(0, 150, 0, 550, panel);
	    glutamine.setup(100, 75, 0, 650, panel);
	    glycine.setup(100, 0, 75, 750, panel);
	    histidine.setup(0, 0, 255, 850, panel);
	    isoleucine.setup(255, 255, 0, 950, panel);
	    leucine.setup(255, 140, 0, 1050, panel);
	    lysine.setup(255, 20, 147, 1150, panel);
	    methionine.setup(75, 0, 130, 1250, panel);
	    phenylalanine.setup(255, 215, 0, 1350, panel);
	    proline.setup(0, 255, 255, 1450, panel);
	    serine.setup(205, 133, 63, 1550, panel);
	    threonine.setup(0,191,255,1650,panel);
	    tryptophan.setup(123, 104, 238, 1750, panel);
	    tyrosine.setup(178,34,34, 1850, panel);
	    valine.setup(255,222, 173, 1950, panel);
	}
	
	//CLASS THAT RESPONDS TO BUTTON CLICKS
	public static class button_clicked implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			System.out.println("Button Clicked.");
		}
	}
	
	//CLASS THAT RESPONDS TO BOX DRAGS
	public static class box_dragged implements MouseMotionListener, MouseListener{
		AminoAcid clone;
		public void mouseDragged(MouseEvent e) {
			int new_x = e.getXOnScreen()-40;
			int new_y = e.getYOnScreen()-75;
			AminoAcid orig = (AminoAcid) e.getSource();
			
			int i = 0;
			int new_red = orig.r + i > 255?orig.r - i:orig.r + i;
			int new_green = orig.g + i > 255?orig.g - i:orig.g + i;
			int new_blue = orig.b + i > 255?orig.b - i:orig.b + i;
			
			orig.setBackground(new Color(new_red, new_green, new_blue));
			orig.setLocation(new_x, new_y);
		}
		
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getSource());
		}
		public void mouseMoved(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			clone = ((AminoAcid) e.getSource()).clone();
			clone.setup(clone.r, clone.g, clone.b, clone.x, clone.panel);
		}
		public void mouseReleased(MouseEvent e) {
			//Goal: Make the AminoAcid snap if it lines up with an AminoAcid
		}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}
