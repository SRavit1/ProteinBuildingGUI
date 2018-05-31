import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
/**
 * This is the main class of the ProteinBuildingGui project.
 * @author Ravit Sharma, Rithvik Agastya
 * @version 1.5
 */

public class GUI extends JFrame {
	//These two fields control the placement of the next box after being dragged and released
	public static int next_x;
	public static int next_y;
	
	public static int last_x;
	public static int last_y;
	
	//The following is an instantiation of ArrayList, subclass of ArrayList, that contains the contents of the proteins in the workspace
	static ArrayList chain = new ArrayList ();
	
	static int polar_count = 0;
	static int nonpolar_count = 0;
	static int acidic_count = 0;
	static int basic_count = 0;
	static int neutral_count = 0;
	
	//The following are panels added to the frame
	static JPanel bank = new JPanel();
	static JPanel workspace = new JPanel();
	static JPanel stats = new JPanel();
	
	static Button fasta_button = new Button ("Obtain FASTA File");
	static Button undo_button = new Button ("Undo");
	static Button restart_button = new Button ("Restart");
	
	static Label bank_header = new Label ("BANK");
	static Label workspace_header = new Label ("WORKSPACE");
	
	//The following fields are the labels for statistics of AminoAcids
	static Label statsa_HEADER 		= new Label ("AMINO ACID STATISTICS");
	static Label statsa_name 		= new Label ("NAME: ");
	static Label statsa_polarity 	= new Label ("POLARITY: ");
	static Label statsa_hi 			= new Label ("HYDROPATHY INDEX: ");
	static Label statsa_scc 		= new Label ("SIDE CHAIN CHARGE: ");
	
	//The following fields are the labels for statistics of the chain created
	static Label statsb_HEADER 		= new Label ("PROTEIN STATISTICS");
	static Label statsb_count 		= new Label ("# OF AMINO ACIDS: " + chain.size());
	static Label statsb_polar 		= new Label ("# OF POLAR AMINO ACIDS: " + polar_count);
	static Label statsb_nonpolar	= new Label ("# OF NONPOLAR AMINO ACIDS: " + nonpolar_count);
	static Label statsb_acidic		= new Label ("# OF ACIDIC AMINO ACIDS: " + acidic_count);
	static Label statsb_basic 		= new Label ("# OF BASIC AMINO ACIDS: " + basic_count);
	static Label statsb_neutral		= new Label ("# OF NEUTRAL AMINO ACIDS: " + neutral_count);
	
	//The following fields are the twenty AminoAcid s to be placed in the bank
	static AminoAcid alanine		 = new AminoAcid ("ALANINE",	  	false, 	1.8, 	"Neutral", 	"ALA", "A");
	static AminoAcid arginine		 = new AminoAcid ("ARGININE", 	  	true, 	-4.5, 	"Basic", 	"ARG", "R");
	static AminoAcid asparagine		 = new AminoAcid ("ASPARAGINE",	  	true,	-4.5,	"Neutral",	"ASN", "N");
	static AminoAcid AsparticAcid	 = new AminoAcid ("ASPARTIC ACID",	true, 	-3.5,	"Acidic", 	"ASP", "D");
	static AminoAcid cysteine 		 = new AminoAcid ("CYSTEINE",	  	true,	2.5,	"Neutral",  "CYS", "C");
	static AminoAcid GlutamicAcid 	 = new AminoAcid ("GLUTAMIC ACID",	true,	-3.5,	"Acidic",  	"GLU", "E");
	static AminoAcid glutamine 		 = new AminoAcid ("GLUTAMINE",	    true,	-3.5,	"Neutral",  "GLN", "Q");
	static AminoAcid glycine 		 = new AminoAcid ("GLYCINE",		false,	-0.4,	"Neutral",  "GLY", "G");
	static AminoAcid histidine  	 = new AminoAcid ("HISTIDINE",		true,	-3.2,	"Basic", 	"HIS", "H");
	static AminoAcid isoleucine 	 = new AminoAcid ("ISOLEUCINE",		false,	4.5,	"Neutral",	"ILE", "I");
	static AminoAcid leucine 		 = new AminoAcid ("LEUCINE",		false,	3.8,	"Neutral",	"LEU", "L");
	static AminoAcid lysine 		 = new AminoAcid ("LYSINE",			true,	-3.9,	"Basic", 	"LYS", "K");
	static AminoAcid methionine 	 = new AminoAcid ("METHIONINE",		false,	1.9,	"Neutral", 	"MET", "M");
	static AminoAcid phenylalanine	 = new AminoAcid ("PHENYLALANINE",  false,	2.8,	"Neutral", 	"PHE", "F");
	static AminoAcid proline 		 = new AminoAcid ("PROLINE",		false,	-1.6,	"Neutral",	"PRO", "P");
	static AminoAcid serine 		 = new AminoAcid ("SERINE",			true,	-0.8,	"Neutral", 	"SER", "S");
	static AminoAcid threonine		 = new AminoAcid ("THREONINE",		true,	-0.7,	"Neutral",	"THR", "T");
	static AminoAcid tryptophan		 = new AminoAcid ("TRYPTOPHAN",		false,	-0.9,	"Neutral",	"TRP", "W");
	static AminoAcid tyrosine 		 = new AminoAcid ("TYROSINE",		true,	-1.3,	"Neutral", 	"TYR", "Y");
	static AminoAcid valine			 = new AminoAcid ("VALINE",			false,	4.2,	"Neutral",	"VAL", "V");
	
	
	public static void main(String[] args) { 
		//Setting up the frame
		JFrame frame = new JFrame("Protein GUI");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(100*2/3, 0*2/3, 1550*2/3, 700*2/3);
	    frame.setVisible(true);
	    
	    // Creating panels that split the frame, and giving them different colors
	    bank.setBounds(0, 0, 1550*2/3, 150*2/3);
	    bank.setBackground(Color.WHITE);
	
	    workspace.setBounds(0, 150*2/3, 1300*2/3, 600*2/3);
	    workspace.setBackground(Color.LIGHT_GRAY);
	    
	    stats.setBounds(1300*2/3, 150*2/3, 250*2/3, 600*2/3);
	    stats.setBackground(Color.PINK);
	    
	    //Adding panels created above to frame
	    frame.add(bank);
	    frame.add(workspace);
	    frame.add(stats);
	    
	    stats.add(fasta_button);
	    fasta_button.setBounds(25*2/3, 450*2/3, 200*2/3, 30*2/3);
	    fasta_button.setVisible(true);
	    fasta_button.addMouseListener(new fml());
	    
	    workspace.add(undo_button);
	    undo_button.setBounds (1100*2/3, 10*2/3, 200*2/3, 30*2/3);
	    undo_button.setVisible(true);
	    undo_button.addMouseListener(new uml());
	    
	    workspace.add(restart_button);
	    restart_button.setBounds(1100*2/3, 40*2/3,200*2/3,30*2/3);
	    restart_button.setVisible(true);
	    restart_button.addMouseListener(new rml());
	    
	    bank_header.setFont(new Font("ARIAL", Font.BOLD, 15));
		bank_header.setAlignment(Label.CENTER);
		bank_header.setBounds(0*2/3, 0*2/3, 1550*2/3, 30*2/3);
		bank.add(bank_header);
		
		workspace_header.setFont(new Font("ARIAL", Font.BOLD, 15));
		workspace_header.setAlignment(Label.CENTER);
		workspace_header.setBounds(575*2/3, 0*2/3, 150*2/3, 30*2/3);
		workspace.add(workspace_header);
	    
	    statsa_HEADER.setFont(new Font ("ARIAL", Font.PLAIN, 10));
	    statsa_name.setFont(new Font ("ARIAL", Font.PLAIN, 10));
	    statsa_hi.setFont(new Font ("ARIAL", Font.PLAIN, 10));
	    statsa_polarity.setFont(new Font ("ARIAL", Font.PLAIN, 10));
	    statsa_scc.setFont(new Font ("ARIAL", Font.PLAIN, 10));
	    
		//Adding Stats A labels to Stats panel
	    stats.add(statsa_HEADER);
	    stats.add(statsa_name);
		stats.add(statsa_hi);
		stats.add(statsa_polarity);
		stats.add(statsa_scc);
		
		//Setting up the font and alignment of Stats A Header
		statsa_HEADER.setFont(new Font("ARIAL", Font.BOLD, 13));
		statsa_HEADER.setAlignment(Label.CENTER);
		
		//Setting up the bounds of the Stats A labels
		statsa_HEADER.setBounds		(0*2/3, 0*2/3, 250*2/3, 50*2/3);
		statsa_name.setBounds		(0*2/3, 50*2/3, 250*2/3, 25*2/3);
		statsa_hi.setBounds			(0*2/3, 75*2/3, 250*2/3, 25*2/3);
		statsa_polarity.setBounds	(0*2/3, 100*2/3, 250*2/3, 25*2/3);
		statsa_scc.setBounds		(0*2/3, 125*2/3, 250*2/3, 25*2/3);
		
		statsb_HEADER.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_count.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_polar.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_nonpolar.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_acidic.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_basic.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		statsb_neutral.setFont(new Font ("ARIAL", Font.PLAIN, 10));
		
		//Adding Stats B labels to Stats panel
		stats.add(statsb_HEADER);
		stats.add(statsb_count);
		stats.add(statsb_polar);
		stats.add(statsb_nonpolar);
		stats.add(statsb_acidic);
		stats.add(statsb_basic);
		stats.add(statsb_neutral);
		
		//Setting up the font and alignment of Stats B Header
		statsb_HEADER.setFont(new Font("ARIAL", Font.BOLD, 13));
		statsb_HEADER.setAlignment(Label.CENTER);
		
		//Setting up the bounds of the Stats B labels
		statsb_HEADER.setBounds(0*2/3, 175*2/3, 250*2/3, 25*2/3);
		statsb_count.setBounds(0*2/3, 225*2/3, 250*2/3, 25*2/3);
		statsb_polar.setBounds(0*2/3, 275*2/3, 250*2/3, 25*2/3);
		statsb_nonpolar.setBounds(0*2/3, 300*2/3, 250*2/3, 25*2/3);
		statsb_acidic.setBounds(0*2/3, 350*2/3, 250*2/3, 25*2/3);
		statsb_basic.setBounds(0*2/3, 375*2/3, 250*2/3, 25*2/3);
		statsb_neutral.setBounds(0*2/3, 400*2/3, 250*2/3, 25*2/3);

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
	public static void undo () {
		if (chain.size() == 0) {
			return;
		}
		
		AminoAcid current = ((AminoAcid)chain.get(chain.size() - 1));
		
		current.setVisible(false);
		
		if (current.Polarity == true) {polar_count--; }
		else {nonpolar_count--; }
		
		if (current.SideChainCharge == "Acidic") {acidic_count--; }
		else if (current.SideChainCharge == "Basic") {basic_count--;}
		else {neutral_count--;}
		
		ArrayList temp = new ArrayList();
		for (int i = 0; i < chain.size() - 1; i++) {
			temp.add(chain.get(i));
		}
		chain = temp;
		
		update_statsb ();
		next_x -= 55/2;
	}
	
	public static void update_statsa (AminoAcid current) {
		statsa_name.setText("NAME: " + current.full_name);
		statsa_hi.setText("HYDROPATHY INDEX: " + current.HydropathyIndex);
		statsa_polarity.setText("POLARITY: " + (current.Polarity?"Polar":"Nonpolar"));
		statsa_scc.setText("SIDE CHAIN CHARGE: " + current.SideChainCharge);
	}
	public static void update_statsb () {
		statsb_count.setText("# OF AMINO ACIDS: " + (chain.size()));
		statsb_polar.setText("# OF POLAR AMINO ACIDS: " + polar_count);
		statsb_nonpolar.setText("# OF NONPOLAR AMINO ACIDS: " + nonpolar_count);
		statsb_acidic.setText("# OF ACIDIC AMINO ACIDS: " + acidic_count);
		statsb_basic.setText("# OF BASIC AMINO ACIDS: " + basic_count);
		statsb_neutral.setText("# OF NEUTRAL AMINO ACIDS: " + neutral_count);
	}
	
	//Restart Button Motion Listener
	public static class rml implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			for (int i = 0; i < chain.size(); i++) {
				((AminoAcid)chain.get(i)).setVisible(false);
			}
			chain = new ArrayList ();
			
			polar_count = 0;
			nonpolar_count = 0;
			acidic_count = 0;
			basic_count = 0;
			neutral_count = 0;
			
			update_statsb ();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	//Undo Mouse Listener
	public static class uml implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			undo();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	//FASTA Mouse Listener
	public static class fml implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			JFrame fasta = new JFrame();
			fasta.setBounds(500*2/3, 100*2/3, 500*2/3, 500*2/3);
			fasta.setTitle("FASTA File");
			
			String fasta_string = "";
			fasta_string += ">User's Sequence\n";
			for (int i = 0; i < chain.size(); i++) {
				fasta_string += ((AminoAcid) chain.get(i)).name_1letter;
			}
			
			TextArea ta = new TextArea();
			ta.setText(fasta_string);
			fasta.add(ta);
			fasta.setVisible(true);
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	//Class that responds to mouse actions on AminoAcid instances
	public static class box_mouselistener implements MouseMotionListener, MouseListener{
		//Following method is invoked when mouse is dragged
		public void mouseDragged(MouseEvent e) {
			int temp_x = e.getXOnScreen()-90;
			int temp_y = e.getYOnScreen()-60;
			
			AminoAcid orig = (AminoAcid) e.getSource();
			
			orig.mobile = true;
			if (chain.contains(orig) == false) {
				if (temp_x < 0) temp_x = 0;
				orig.setLocation(temp_x, temp_y);
			}
			
			//if (chain.size() != 0 && e.getY() > 225) {
			if (chain.size() != 0) {
				if (e.getYOnScreen() < 226) {
					temp_y = 150;
				}
				if (chain.get(chain.size() - 1) == orig) {
					if (temp_x < 0) temp_x = 0;
					orig.setLocation(temp_x, temp_y);
				}
				if (chain.contains(orig) && chain.get(chain.size() - 1) != orig) {
					temp_x = temp_x - (orig.getX() - ((AminoAcid)chain.get(0)).getX());
					for (int i = 0; i < chain.size(); i++) {
						AminoAcid ith = ((AminoAcid)chain.get(i));
						if (temp_x < 1250*2/3) {
							if (temp_x < 0) temp_x = 0;
							ith.setLocation(temp_x, temp_y);
							temp_x += 55*2/3;
						}
						else {
							temp_x = ((AminoAcid)chain.get(0)).getX();
							temp_y += 75*2/34;
							if (temp_x < 0) temp_x = 0;
							ith.setLocation(temp_x,temp_y);
							temp_x += 55*2/3;
						}
					}
				}
			}
			last_x = e.getXOnScreen();
			last_y = e.getYOnScreen();
		}
		
		//Following method is invoked when mouse button is clicked
		public void mouseClicked(MouseEvent e) {
			AminoAcid orig = (AminoAcid) e.getSource();
			update_statsa (orig);
		}
		
		//Following method is invoked when mouse button is pressed
		public void mousePressed(MouseEvent e) {
			AminoAcid clone = ((AminoAcid) e.getSource()).clone();
			clone.mobile = false;
			clone.setup(clone.r, clone.g, clone.b, clone.x, clone.panel);
			
			last_x = e.getXOnScreen();
			last_y = e.getYOnScreen();
		}
		
		//Following method is invoked when mouse button is released
		public void mouseReleased(MouseEvent e) {
			if (chain.size() == 0) {
				next_x = e.getXOnScreen()-90;
				next_y = e.getYOnScreen()-60;
			}
			else {
				next_x = ((AminoAcid)chain.get(chain.size() - 1)).getX() + 55*2/3;
				next_y = ((AminoAcid)chain.get(chain.size() - 1)).getY();
			}
			AminoAcid orig = (AminoAcid) e.getSource();
			if (orig.mobile == true && chain.contains(orig) == false && next_y > 225*2/3) {

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
				next_x += 55*2/3;
				chain.add(orig);
			}
			else if (orig.mobile == true && chain.contains(orig) == false && next_y < 226*2/3) {
				orig.setVisible(false);
			}
		}
		public void mouseMoved(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}

