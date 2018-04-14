import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
/**
 * This is the main class of the ProteinBuildingGui project.
 * @author Ravit Sharma, Rithvik Agastya
 * @version 1.5
 */

public class GUI extends JFrame {
	
	//These two fields control the placement of the next box after being dragged and released
	public static int next_x;
	public static int next_y;
	
	//The following is an instantiation of Chain_AL, subclass of ArrayList, that contains the contents of the proteins in the workspace
	static Chain_AL chain = new Chain_AL ();
	
	static int polar_count = 0;
	static int nonpolar_count = 0;
	static int acidic_count = 0;
	static int basic_count = 0;
	static int neutral_count = 0;
	
	//The following are panels added to the frame
	static JPanel bank = new JPanel();
	static JPanel workspace = new JPanel();
	static JPanel stats = new JPanel();
	
	static Label bank_header = new Label ("BANK");
	static Label workspace_header = new Label ("WORKSPACE");
	
	//The following fields are the labels for statistics of AminoAcid s
	static Label statsa_HEADER 		= new Label ("AMINO ACID STATISTICS");
	static Label statsa_name 		= new Label ("NAME: ");
	static Label statsa_polarity 	= new Label ("POLARITY: ");
	static Label statsa_hi 			= new Label ("HYDROPATHY INDEX: ");
	static Label statsa_scc 		= new Label ("SIDE CHAIN CHARGE: ");
	
	//The following fields are the labels for statistics of the chain created
	static Label statsb_HEADER 		= new Label ("PROTEIN STATISTICS");
	static Label statsb_count 		= new Label ("# OF AMINO ACIDS: 0");
	static Label statsb_polar 		= new Label ("# OF POLAR AMINO ACIDS: 0");
	static Label statsb_nonpolar	= new Label ("# OF NONPOLAR AMINO ACIDS: 0");
	static Label statsb_acidic		= new Label ("# OF ACIDIC AMINO ACIDS: 0");
	static Label statsb_basic 		= new Label ("# OF BASIC AMINO ACIDS: 0");
	static Label statsb_neutral		= new Label ("# OF NEUTRAL AMINO ACIDS: 0");
	
	//The following fields are the twenty AminoAcid s to be placed in the bank
	static AminoAcid alanine		 = new AminoAcid ("ALANINE",	  	false, 	1.8, 	"Neutral", 	"ALA");
	static AminoAcid arginine		 = new AminoAcid ("ARGININE", 	  	true, 	-4.5, 	"Basic", 	"ARG");
	static AminoAcid asparagine		 = new AminoAcid ("ASPARAGINE",	  	true,	-4.5,	"Neutral",	"ASN");
	static AminoAcid AsparticAcid	 = new AminoAcid ("ASPARTIC ACID",	true, 	-3.5,	"Acidic", 	"ASP");
	static AminoAcid cysteine 		 = new AminoAcid ("CYSTEINE",	  	true,	2.5,	"Neutral",  "CYS");
	static AminoAcid GlutamicAcid 	 = new AminoAcid ("GLUTAMIC ACID",	true,	-3.5,	"Acidic",  	"GLU");
	static AminoAcid glutamine 		 = new AminoAcid ("GLUTAMINE",	    true,	-3.5,	"Neutral",  "GLN");
	static AminoAcid glycine 		 = new AminoAcid ("GLYCINE",		false,	-0.4,	"Neutral",  "GLY");
	static AminoAcid histidine  	 = new AminoAcid ("HISTIDINE",		true,	-3.2,	"Basic", 	"HIS");
	static AminoAcid isoleucine 	 = new AminoAcid ("ISOLEUCINE",		false,	4.5,	"Neutral",	"ILE");
	static AminoAcid leucine 		 = new AminoAcid ("LEUCINE",		false,	3.8,	"Neutral",	"LEU");
	static AminoAcid lysine 		 = new AminoAcid ("LYSINE",			true,	-3.9,	"Basic", 	"LYS");
	static AminoAcid methionine 	 = new AminoAcid ("METHIONINE",		false,	1.9,	"Neutral", 	"MET");
	static AminoAcid phenylalanine	 = new AminoAcid ("PHENYLALANINE",  false,	2.8,	"Neutral", 	"PHE");
	static AminoAcid proline 		 = new AminoAcid ("PROLINE",		false,	-1.6,	"Neutral",	"PRO");
	static AminoAcid serine 		 = new AminoAcid ("SERINE",			true,	-0.8,	"Neutral", 	"SER");
	static AminoAcid threonine		 = new AminoAcid ("THREONINE",		true,	-0.7,	"Neutral",	"THR");
	static AminoAcid tryptophan		 = new AminoAcid ("TRYPTOPHAN",		false,	-0.9,	"Neutral",	"TRP");
	static AminoAcid tyrosine 		 = new AminoAcid ("TYROSINE",		true,	-1.3,	"Neutral", 	"TYR");
	static AminoAcid valine			 = new AminoAcid ("VALINE",			false,	4.2,	"Neutral",	"VAL");
	
	
	public static void main(String[] args) { 
		//Setting up the frame
		JFrame frame = new JFrame("Protein GUI");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1550, 700);
	    frame.setVisible(true);
	    
	    // Creating panels that split the frame, and giving them different colors
	    bank.setBounds(0, 0, 1550, 150);
	    bank.setBackground(Color.WHITE);
	
	    workspace.setBounds(0, 150, 1300, 600);
	    workspace.setBackground(Color.LIGHT_GRAY);
	    
	    stats.setBounds(1300, 150, 250, 600);
	    stats.setBackground(Color.PINK);
	    
	    //Adding panels created above to frame
	    frame.add(bank);
	    frame.add(workspace);
	    frame.add(stats);
	    
		bank_header.setFont(new Font("ARIAL", Font.BOLD, 15));
		bank_header.setAlignment(Label.CENTER);
		bank_header.setBounds(0, 0, 1550, 30);
		bank.add(bank_header);
		
		workspace_header.setFont(new Font("ARIAL", Font.BOLD, 15));
		workspace_header.setAlignment(Label.CENTER);
		workspace_header.setBounds(575, 0, 150, 30);
		workspace.add(workspace_header);
	    
	    //Adding Stats A labels to Stats panel
	    stats.add(statsa_HEADER);
	    stats.add(statsa_name);
		stats.add(statsa_hi);
		stats.add(statsa_polarity);
		stats.add(statsa_scc);
		
		//Setting up the font and alignment of Stats A Header
		statsa_HEADER.setFont(new Font("ARIAL", Font.BOLD, 15));
		statsa_HEADER.setAlignment(Label.CENTER);
		
		//Setting up the bounds of the Stats A labels
		statsa_HEADER.setBounds		(0, 0, 250, 50);
		statsa_name.setBounds		(0, 50, 250, 25);
		statsa_hi.setBounds			(0, 75, 250, 25);
		statsa_polarity.setBounds	(0, 100, 250, 25);
		statsa_scc.setBounds		(0, 125, 250, 25);
		
		//Adding Stats B labels to Stats panel
		stats.add(statsb_HEADER);
		stats.add(statsb_count);
		stats.add(statsb_polar);
		stats.add(statsb_nonpolar);
		stats.add(statsb_acidic);
		stats.add(statsb_basic);
		stats.add(statsb_neutral);
		
		//Setting up the font and alignment of Stats B Header
		statsb_HEADER.setFont(new Font("ARIAL", Font.BOLD, 15));
		statsb_HEADER.setAlignment(Label.CENTER);
		
		//Setting up the bounds of the Stats B labels
		statsb_HEADER.setBounds(0, 175, 250, 25);
		statsb_count.setBounds(0, 225, 250, 25);
		statsb_polar.setBounds(0, 275, 250, 25);
		statsb_nonpolar.setBounds(0, 300, 250, 25);
		statsb_acidic.setBounds(0, 350, 250, 25);
		statsb_basic.setBounds(0, 375, 250, 25);
		statsb_neutral.setBounds(0, 400, 250, 25);

	    //Setting up AminoAcid s
	    alanine.setup		(255, 0,   0,   50,   bank);
	    arginine.setup		(100, 100, 100, 125,  bank);
	    asparagine.setup	(0  , 255, 0,   200,  bank);
	    AsparticAcid.setup	(100, 200, 100, 275,  bank);
	    cysteine.setup		(200, 200, 250, 350,  bank);
	    GlutamicAcid.setup	(255, 150, 255, 425,  bank);
	    glutamine.setup		(200, 75,  200, 500,  bank);
	    glycine.setup		(200, 150, 75,  575,  bank);
	    histidine.setup		(100, 100, 255, 650,  bank);
	    isoleucine.setup	(255, 255, 0,   725,  bank);
	    leucine.setup		(255, 140, 0,   800,  bank);
	    lysine.setup		(255, 20,  147, 875,  bank);
	    methionine.setup	(175, 100, 230, 950,  bank);
	    phenylalanine.setup	(255, 100, 255, 1025, bank);
	    proline.setup		(0,   150, 150, 1100, bank);
	    serine.setup		(150, 150, 50,  1175, bank);
	    threonine.setup		(0,   255, 255, 1250, bank);
	    tryptophan.setup	(255, 100, 100, 1325, bank);
	    tyrosine.setup		(178, 34,  34,  1400, bank);
	    valine.setup		(255, 222, 173, 1475, bank);
	}
	
	//Class that responds to mouse actions on AminoAcid instances
	public static class box_mouselistener implements MouseMotionListener, MouseListener{
		//Following method is invoked when mouse is dragged
		public void mouseDragged(MouseEvent e) {
			int temp_x = e.getXOnScreen()-38;
			int temp_y = e.getYOnScreen()-75;
			
			AminoAcid orig = (AminoAcid) e.getSource();
			
			orig.mobile = true;
			if (orig.in_chain == false) {
				orig.setLocation(temp_x, temp_y);
			}
		}
		
		//Following method is invoked when mouse button is clicked
		public void mouseClicked(MouseEvent e) {
			AminoAcid orig = (AminoAcid) e.getSource();
			statsa_name.setText("NAME: " + orig.name);
			statsa_hi.setText("HYDROPATHY INDEX: " + orig.HydropathyIndex);
			statsa_polarity.setText("POLARITY: " + (orig.Polarity?"Polar":"Nonpolar"));
			statsa_scc.setText("SIDE CHAIN CHARGE: " + orig.SideChainCharge);
		}
		
		//Following method is invoked when mouse button is pressed
		public void mousePressed(MouseEvent e) {
			AminoAcid clone = ((AminoAcid) e.getSource()).clone();
			clone.mobile = false;
			clone.setup(clone.r, clone.g, clone.b, clone.x, clone.panel);
		}
		
		//Following method is invoked when mouse button is released
		public void mouseReleased(MouseEvent e) {
			if (chain.size() == 0) {
				next_x = e.getXOnScreen()-38;
				next_y = e.getYOnScreen()-75;
			}
			
			AminoAcid orig = (AminoAcid) e.getSource();
			if (orig.mobile == true && orig.in_chain == false && next_y > 150 && next_x < 1275) {
				if (orig.Polarity == true) {polar_count++; }
				else {nonpolar_count++; }
				
				if (orig.SideChainCharge == "Acidic") {acidic_count++; }
				else if (orig.SideChainCharge == "Basic") {basic_count++;}
				else {neutral_count++;}
				
				statsb_count.setText("# OF AMINO ACIDS: " + (chain.size()+1));
				statsb_polar.setText("# OF POLAR AMINO ACIDS: " + polar_count);
				statsb_nonpolar.setText("# OF NONPOLAR AMINO ACIDS: " + nonpolar_count);
				statsb_acidic.setText("# OF ACIDIC AMINO ACIDS: " + acidic_count);
				statsb_basic.setText("# OF BASIC AMINO ACIDS: " + basic_count);
				statsb_neutral.setText("# OF NEUTRAL AMINO ACIDS: " + neutral_count);
				
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
