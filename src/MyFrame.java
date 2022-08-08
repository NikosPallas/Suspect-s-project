import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{
	
//Δήλωση γραφικών συστατικών//
	private JButton button;
	private JTextField output;
	private JPanel panel;
	
	private static Suspect FoundSuspect;
	
	public static  Suspect getFoundSuspect(){
		return FoundSuspect;
	}
	
	public MyFrame() {
		button = new JButton("Find");
		output = new JTextField("Please enter suspect's name");
	
		
		//Υλοποίηση ακροατή//
		ButtonListener listener = new ButtonListener();
		
		//Σύνδεση ακροατή με πηγή συμβάντων//
		button.addActionListener(listener);
			
		panel = new JPanel();
		
		panel.add(output);
		panel.add(button);
		//panel.add(test);

		  this.setContentPane(panel);
		  this.pack();
		  this.setSize(300, 300);
		  this.setTitle("Find Suspect");
		  this.setVisible(true);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	

	 class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
		
				boolean flag2=false;
				
				for(int i=0;i<Registry.getListOfSuspects().size();i++) {
					
					if(Registry.getListOfSuspects().get(i).getName().equals(output.getText())) {
						 flag2=true;
  				         FoundSuspect=Registry.getListOfSuspects().get(i);
					   }			
				  }
				if(flag2) {
					new MySuspectFrame(FoundSuspect);
				}
				else {
		           JOptionPane.showMessageDialog(null,"Suspect " + output.getText() + " Not Found"); 				
				 }
				
				}
		
		


	}
}
