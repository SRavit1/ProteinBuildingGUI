import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class GUI extends JFrame {
	public static int next_x;
	public static int next_y;
	static Chain_AL chain = new Chain_AL ();
	
	public GUI() {
		super ();
	}
	public GUI(String string) {
		super (string);
	}
	
	static AminoAcid alanine		 = new AminoAcid ("ALANINE", "Nonpolar", 1.8, "Neutral");
	static AminoAcid arginine		 = new AminoAcid ("ARGININE", "Polar", -4.5, "Basic");
	static AminoAcid asparagine		 = new AminoAcid ("ASPARAGINE","Polar",-4.5,"Neutral");
	static AminoAcid AsparticAcid	 = new AminoAcid ("ASPARTIC ACID","Polar", -3.5,"Acidic");
	static AminoAcid cysteine 		 = new AminoAcid ("CYSTEINE","Polar",2.5,"Neutral");
	static AminoAcid GlutamicAcid 	 = new AminoAcid ("GLUTAMIC ACID","Polar",-3.5,"Acidic");
	static AminoAcid glutamine 		 = new AminoAcid ("GLUTAMINE","Polar",-3.5,"Neutral");
	static AminoAcid glycine 		 = new AminoAcid ("GLYCINE","Nonpolar",-0.4,"Neutral");
	static AminoAcid histidine  	 = new AminoAcid ("HISTIDINE","Polar",-3.2,"Basic");
	static AminoAcid isoleucine 	 = new AminoAcid ("ISOLEUCINE","Nonpolar",4.5,"Neutral");
	static AminoAcid leucine 		 = new AminoAcid ("LEUCINE","Nonpolar",3.8,"Neutral");
	static AminoAcid lysine 		 = new AminoAcid ("LYSINE","Polar",-3.9,"Basic");
	static AminoAcid methionine 	 = new AminoAcid ("METHIONINE","Nonpolar",1.9,"Neutral");
	static AminoAcid phenylalanine	 = new AminoAcid ("PHENYLALANINE","Nonpolar",2.8,"Neutral");
	static AminoAcid proline 		 = new AminoAcid ("PROLINE","Nonpolar",-1.6,"Neutral");
	static AminoAcid serine 		 = new AminoAcid ("SERINE","Polar",-0.8,"Neutral");
	static AminoAcid threonine		 = new AminoAcid ("THREONINE","Polar",-0.7,"Neutral");
	static AminoAcid tryptophan		 = new AminoAcid ("TRYPTOPHAN","Nonpolar",-0.9,"Neutral");
	static AminoAcid tyrosine 		 = new AminoAcid ("TYROSINE","Polar",-1.3,"Neutral");
	static AminoAcid valine			 = new AminoAcid ("VALINE","Nonpolar",4.2,"Neutral");
	
	public static void main(String[] args) { 
		//SETTING UP THE FRAME
		JFrame frame = new JFrame("Protein GUI");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1550, 700);
	    frame.setVisible(true);
	    
	    // CREATING PANELS THAT SPLIT THE FRAME 
	    JPanel bank = new JPanel();
	    bank.setBounds(0, 0, 1550, 250);
	    bank.setBackground(Color.WHITE);
	
	    JPanel workspace = new JPanel();
	    workspace.setBounds(0, 250, 1300, 450);
	    workspace.setBackground(Color.DARK_GRAY);
	    
	    JPanel stats = new JPanel();
	    stats.setBounds(1300, 250, 250, 450);
	    stats.setBackground(Color.PINK);
	    
	    //ADDING PANELS TO FRAME
	    frame.add(bank);
	    frame.add(workspace);
	    frame.add(stats);

	    //SETTING UP THE AMINO ACIDS
	    alanine.setup		(50,  0,   0,   50,   bank);
	    arginine.setup		(50,  50,  0,   125,  bank);
	    asparagine.setup	(255, 0,   0,   200,  bank);
	    AsparticAcid.setup	(50,  100, 50,  275,  bank);
	    cysteine.setup		(0,   0,   150, 350,  bank);
	    GlutamicAcid.setup	(0,   150, 0,   425,  bank);
	    glutamine.setup		(100, 75,  0,   500,  bank);
	    glycine.setup		(100, 0,   75,  575,  bank);
	    histidine.setup		(0,   0,   255, 650,  bank);
	    isoleucine.setup	(255, 255, 0,   725,  bank);
	    leucine.setup		(255, 140, 0,   800,  bank);
	    lysine.setup		(255, 20,  147, 875,  bank);
	    methionine.setup	(75,  0,   130, 950,  bank);
	    phenylalanine.setup	(255, 100, 255, 1025, bank);
	    proline.setup		(0,   255, 255, 1100, bank);
	    serine.setup		(205, 133, 63,  1175, bank);
	    threonine.setup		(0,   191, 255, 1250, bank);
	    tryptophan.setup	(123, 104, 238, 1325, bank);
	    tyrosine.setup		(178, 34,  34,  1400, bank);
	    valine.setup		(255, 222, 173, 1475, bank);
	}
	
	//CLASS THAT RESPONDS TO MOUSE ACTIONS ON BOX
	public static class box_dragged implements MouseMotionListener, MouseListener{
		public void mouseDragged(MouseEvent e) {
			int temp_x = e.getXOnScreen()-38;
			int temp_y = e.getYOnScreen()-75;
			
			AminoAcid orig = (AminoAcid) e.getSource();
			
			orig.mobile = true;
			if (orig.in_chain == false) {
				orig.setLocation(temp_x, temp_y);
			}
		}
		public void mouseClicked(MouseEvent e) {
			AminoAcid orig = (AminoAcid) e.getSource();
			if (orig.mobile == false) {
				System.out.println(orig);
				System.out.println(chain);
			}
		}
		public void mousePressed(MouseEvent e) {
			AminoAcid clone = ((AminoAcid) e.getSource()).clone();
			clone.mobile = false;
			clone.setup(clone.r, clone.g, clone.b, clone.x, clone.panel);
		}
		public void mouseReleased(MouseEvent e) {
			if (chain.size() == 0) {
				next_x = e.getXOnScreen()-38;
				next_y = e.getYOnScreen()-75;
			}
			
			AminoAcid orig = (AminoAcid) e.getSource();
			if (orig.mobile == true && orig.in_chain == false) {
				orig.setLocation(next_x, next_y);
				next_x += 55;
				chain.add(orig);
				orig.in_chain = true;
			}
		}
		public void mouseMoved(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}
