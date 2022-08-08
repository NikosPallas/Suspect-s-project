import java.util.ArrayList;
import java.util.HashSet;


public class Suspect {
	private String name;
	private String Codename;
	private String Country;
	private String town;
	private ArrayList<String> SuspectCommunicationList = new ArrayList<String>();
	private  ArrayList<Suspect> ListOfPartners = new ArrayList<Suspect>() ;
	private ArrayList<Suspect> CommonPartners = new ArrayList<Suspect>() ;
	
	private static ArrayList<String> ListOfSuggestedPartners = new ArrayList<String>() ;

	
    private Registry myRegistry;
    
    public void setMyRegistry(Registry aRegistry) {
		myRegistry = aRegistry;
	}
    
	//Constructor//
	public Suspect(String text1, String nickname, String text2, String text3) {
	
		name = text1;
		Codename = nickname;
		Country = text2;
		town = text3;
		
	}
	
	
	//Getters//
	public  ArrayList<String> getSuspectCommunicationList() {
		return SuspectCommunicationList;
	}
	

	public  ArrayList<Suspect> getListOfPartners() {
		return ListOfPartners;
	}
	
	public String getCountry(){
		return Country;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCodeName() {
		return Codename;
	}
	
	
	
	//Μέθοδος εισαγωγής αριθμού στην λίστα των αριθμών που χρησιμοποιεί ο Ύποπτος//
	public void addNumber(String number) {
		SuspectCommunicationList.add(number);
		
		}
	
	//Μέθοδος εισαγωγής συνεργάτη//
	public void addPartner(Suspect aPartner) {
		
		boolean flag = true;
	
		for(int i=0 ;i<ListOfPartners.size(); i++) {
			if(aPartner == ListOfPartners.get(i)) 
			 flag = false;	       
	          }
		if(flag){
		     ListOfPartners.add(aPartner);
		}
	}
		         
	
	//Μέθοδος ελέγχου σύνδεσης ενός υπόπτου με έναν άλλο ύποπτο//
	public boolean isConnectedTo(Suspect aSuspect) {
		   boolean Connection = false;
		   
		   
		for(int i=0;i<aSuspect.SuspectCommunicationList.size(); i++) {
			
			for(int j=0;j<14; j++) {
				
				if(aSuspect.SuspectCommunicationList.get(i)==Registry.getComms().get(j).getNumber1()||aSuspect.SuspectCommunicationList.get(i)==Registry.getComms().get(j).getNumber2())
				{
					Connection = true;
					}
			}	
		}
		return Connection;
	}
	
	//Μέθοδος επιστροφής της λίστας των κοινών συνεργατών//
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect){
			
		for(int i=0;i<ListOfPartners.size(); i++) {
			for(int j=0;j<aSuspect.ListOfPartners.size(); j++) {	
				Suspect a=aSuspect.ListOfPartners.get(j);
				Suspect b=ListOfPartners.get(i);
				if(a==b)
				 {
				   CommonPartners.add(aSuspect.ListOfPartners.get(j));
			     }			
			  }
		   }
		
		
		return CommonPartners;
		
	}
	
	//Μέθοδος εκτύπωσης των στοιχείων των συνεργατών//
	public void printInfo(Suspect aSuspect) {
		for(int i=0;i<ListOfPartners.size();i++){
			
			if(ListOfPartners.get(i).getCountry() == aSuspect.getCountry()){

			 System.out.println("Name of partner: " + ListOfPartners.get(i).getName());
			 System.err.println("CodeName: " + ListOfPartners.get(i).getCodeName() + "*");
			      }
			 else
			 {
				 System.out.println("Name of partner: " + ListOfPartners.get(i).getName());
			     System.err.println("CodeName: " + ListOfPartners.get(i).getCodeName());
			 }
		}
		
	}
	
	public static HashSet<String> getSuggestedPartners(){
			
	
	HashSet<String> h = new HashSet<String>(); 
	
	//MyFrame.getFoundSuspect().getListOfPartners().get(0)
		
		for(int i=0;i<MyFrame.getFoundSuspect().getListOfPartners().size();i++) {
			h.add(MyFrame.getFoundSuspect().getListOfPartners().get(i).getName());
		}
		
		for(int i=0;i<MyFrame.getFoundSuspect().getListOfPartners().size();i++) {
			for(int j=0;j<MyFrame.getFoundSuspect().getListOfPartners().get(i).getListOfPartners().size();j++) {
				if(h.contains(MyFrame.getFoundSuspect().getListOfPartners().get(i).getListOfPartners().get(j).getName())||MyFrame.getFoundSuspect().getListOfPartners().get(i).getListOfPartners().get(j).getName()==MyFrame.getFoundSuspect().getName())
				{
					h.remove(MyFrame.getFoundSuspect().getListOfPartners().get(i).getListOfPartners().get(j).getName());
				}
				else
					h.add(MyFrame.getFoundSuspect().getListOfPartners().get(i).getListOfPartners().get(j).getName());
				
			}
			
		}
		
		for(int i=0;i<MyFrame.getFoundSuspect().getListOfPartners().size();i++) {
			h.remove(MyFrame.getFoundSuspect().getListOfPartners().get(i).getName());
		}
		
		return h;
	}


}
