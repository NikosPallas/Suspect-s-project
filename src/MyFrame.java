import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.transform.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class MyFrame extends JFrame{
	
//Δήλωση γραφικών συστατικών//
	private JButton button;
	private JTextField output;
	private JPanel panel;
	private JButton VisualizationButton;

	
	private static Suspect FoundSuspect;
	
	public static  Suspect getFoundSuspect(){
		return FoundSuspect;
	}
	
	public MyFrame() {
		button = new JButton("Find");
		output = new JTextField("Please enter suspect's name");
		VisualizationButton = new JButton("Visualize Network");
	
		
		//Υλοποίηση ακροατή//
		ButtonListener listener = new ButtonListener();
		ButtonListenerGraph listenerOfGraph = new ButtonListenerGraph();
		
		//Σύνδεση ακροατή με πηγή συμβάντων//
		button.addActionListener(listener);
		VisualizationButton.addActionListener(listenerOfGraph);
		
			
		panel = new JPanel();
		
		panel.add(output);
		panel.add(button);
		panel.add(VisualizationButton);
		

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
	 
	class ButtonListenerGraph implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			 SimpleGraphView sgv = new SimpleGraphView(); //We create our graph in here
			 Layout<Integer, String> layout = new CircleLayout(sgv.g);
			 layout.setSize(new Dimension(300,300)); 
			 BasicVisualizationServer<Integer,String> vv =
			 new BasicVisualizationServer<Integer,String>(layout);
			 vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

			 
			 //Δημιουργία HashMap για την "ετικετοποιήση" των κόμβων//
			 Map<Suspect, String> MapOfSuspectsLabels= new HashMap<Suspect,String>();
			 
			 for(int i=0;i<Registry.getListOfSuspects().size();i++) {
				 MapOfSuspectsLabels.put(Registry.getListOfSuspects().get(i),Registry.getListOfSuspects().get(i).getCodeName() );
				 
			 }				

			 vv.getRenderContext().setVertexLabelTransformer(k -> MapOfSuspectsLabels.get(Registry.getListOfSuspects().get(k-1)));
			 
			 
			 JFrame frame = new JFrame("Simple Graph View");
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.getContentPane().add(vv);
			 frame.pack();
			 frame.setVisible(true); 
			
		}
		
	}
}