import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class MySuspectFrame extends JFrame{
	
	private JPanel panel1;

	//Γραφικά συστατικά της περιοχής 1//
	private JTextField SuspectName;
	private JTextField SuspectCodeName;
	private JList<String> ListOfNumbers;
	private JPanel Box1;
	
	//Γραφικά συστατικά της περιοχής 2//
	private  JTextField NumberToInsert;
	private JTextArea AreaOfSMS;
	private JButton FindSMSButton;
	private JPanel Box2;

	
	//Γραφικά συστατικά της περιοχής 3//
	private JTextArea ListOfPartners;
	private ArrayList<String> ArrayToFillJList = new ArrayList<String>();
	private JLabel label;
	private JPanel Box3;

		
	//Γραφικά συστατικά της περιοχής 4//
	private ArrayList<String> ArrayToFillset2 = new ArrayList<String>();
	private JTextArea AreaOfSuggestedPartners;
	private JLabel label2;
	private JPanel Box4;

	
	//Γραφικά συστατικά της περιοχής 5//
	private JTextArea SuspectsFromSameCountry;
	private JPanel Box5;

	
	
	private JButton ResetButton;
	
	//Δημιουργία διασύνδεσης με την MyFrame ώστε να παίρνουμε τον Suspect που εισάγαμε (και όποια στοιχεία από αυτόν χρειαζόμαστε)//
	private MyFrame myMyFrame;
	
	public void setMyFrame(MyFrame m) {
		myMyFrame = m;
		
	}
	
	//Διασύνδεση με την SMS//
   private SMS myMySMS;	
   
   public void setMySMS(SMS s) {
		myMySMS = s;
		
	}

	public MySuspectFrame(Suspect FoundSuspect) {
		
		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Δημιουργία συστατικών περιοχής 1//
		SuspectName = new JTextField(MyFrame.getFoundSuspect().getName());
		
		c.gridx = 0;
		c.gridy = 0;
		
		Box1 = new JPanel();
		panel1.add(Box1, c);
		Box1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		Box1.add(SuspectName);//Προσθήκη στο panel1//
		
		SuspectCodeName = new JTextField(MyFrame.getFoundSuspect().getCodeName());
		Box1.add(SuspectCodeName);
		
		ListOfNumbers = new JList(MyFrame.getFoundSuspect().getSuspectCommunicationList().toArray());
		
		Box1.add(ListOfNumbers);
		 
		 //Δημιουργία συστατικών περιοχής 2//
		c.gridx = 0;
		c.gridy = 2;
		
		Box2 = new JPanel();
		panel1.add(Box2, c);
		Box2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		 NumberToInsert = new JTextField("Insert number");
  	     Box2.add(NumberToInsert);
  	     FindSMSButton = new JButton("FindSMS");
  	     AreaOfSMS = new JTextArea(8,12);
  	     
  	     //Υλοποίηση ακροατή
  	   ButtonListener2 listener2 = new ButtonListener2();
  	     
  	     Box2.add(AreaOfSMS);		 
		 Box2.add(FindSMSButton);
		 	 
		//Δημιουργία συστατικών περιοχής 3//
		 Box3 = new JPanel();
  	     label = new JLabel("Partners");
  	     
  	     c.gridx = 0;
	     c.gridy = 3;
	     panel1.add(Box3, c);
	     Box3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));	     
	     Box3.add(label);
  	     
	     JTextArea ListOfPartners = new JTextArea(5,5);
	    	 
		  for(int i=0;i<MyFrame.getFoundSuspect().getListOfPartners().size();i++) {	
	    	 ListOfPartners.append(MyFrame.getFoundSuspect().getListOfPartners().get(i).getName() + "," + MyFrame.getFoundSuspect().getListOfPartners().get(i).getCodeName() + "\n");
	    	
		  }
	    	 
	     
	     Box3.add(ListOfPartners);
		 	     
	   //Δημιουργία συστατικών panel4//
	     label2 = new JLabel("Suggested Partners----------------------->");
	     Box4 = new JPanel();
	     c.gridx = 0;
	     c.gridy = 4;
	     panel1.add(Box4,c);
	     Box4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	     Box4.add(label2);
	     
	     AreaOfSuggestedPartners = new JTextArea(5,5);
	     
	     
		   AreaOfSuggestedPartners.append(MyFrame.getFoundSuspect().getSuggestedPartners().toString());
	     
	     Box4.add(AreaOfSuggestedPartners);
	     
	     //Περιοχή 5//
	     Box5 = new JPanel();
	     c.gridx = 0;
	     c.gridy = 5;
	     panel1.add(Box5, c);
	     Box5.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	     
	     
	     
	     SuspectsFromSameCountry = new JTextArea(5,5);
			SuspectsFromSameCountry.append("Suspects coming from " + MyFrame.getFoundSuspect().getCountry() + "\n");
			SuspectsFromSameCountry.append(Registry.printSuspectsFromSameCountry().toString());
	     Box5.add(SuspectsFromSameCountry);
	     
		 
	     ResetButton = new JButton("Return to Search Screen");	     
	     c.gridx = 0;
	     c.gridy = 6;
	     panel1.add(ResetButton,c);
	     
	     //Υλοποίηση ακροατών//
		     
		     ButtonListener3 listener3 = new ButtonListener3();
		     
			
		//Σύνδεση ακροατών με πηγές συμβάντων(FindSMSButton-->listener2 & ResetButton-->listener3//
			   FindSMSButton.addActionListener(listener2);
	           ResetButton.addActionListener(listener3);
			   
		 this.setContentPane(panel1);
		 this.setSize(800, 1000);
		 this.setTitle("Suspect Page");
		 this.setVisible(true);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
	
	//Δημιουργία κλάση-ακροατή για το FindSMS//
 class ButtonListener2 implements ActionListener{
				
  public void actionPerformed(ActionEvent e) {
	
	 GridBagConstraints c = new GridBagConstraints();
	 
	 ArrayList<String> ArraylistOfSMS = new ArrayList<String>();
	 for(int i=0;i<MyFrame.getFoundSuspect().getSuspectCommunicationList().size();i++) {
		 Registry.getMessagesBetween(MyFrame.getFoundSuspect().getSuspectCommunicationList().get(i), NumberToInsert.getText());
	 }
	
	 for(int i=0;i<Registry.getListOfMessages().size();i++)
		AreaOfSMS.append(Registry.getListOfMessages().get(i).getSMSText() + "\n");
     
  }

 }
 
 class ButtonListener3 implements ActionListener{
		
	  public void actionPerformed(ActionEvent v) {
		  if(v.getSource() == ResetButton) {
			  MySuspectFrame.this.dispose();
		  }
		  new MyFrame();
	      }
    }

 
 
}