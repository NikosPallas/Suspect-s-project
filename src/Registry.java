
import java.util.ArrayList;

public class Registry {
	
	private static ArrayList<Communication> comms = new ArrayList<Communication>();
	private static ArrayList<Suspect> ListOfSuspects = new ArrayList<Suspect>();
	private ArrayList<SMS> listOfMessages = new ArrayList<SMS>();

	
	private Suspect mySuspect;
	private Communication myCommunication;
	
	
	//Σύνδεση της κλάσης Regisrty με την κλάση Communication//
	public void setMyCommunication(Communication aCommunication) {
		myCommunication = aCommunication;
	}
	
	
	//Σύνδεση της κλάσης Regisrty με την κλάση Suspect//
	public void setMySuspect(Suspect s) {
		mySuspect = s;
	}
	
	//Μέθοδος προσθήκης υπόπτου//
	public void addSuspect(Suspect s) {
		ListOfSuspects.add(s);
		}
	
	//Μέθοδος προσθήκης μίας επικοινωνίας ή ενός συνεργάτη υπόπτου με τους αντίστοιχους αριθμούς//
	public void addCommunication(Communication c) {
		comms.add(c);
			
		for(int i=0;i<ListOfSuspects.size();i++) {
		 for(int j = 0;j<ListOfSuspects.get(i).getSuspectCommunicationList().size();j++){
				
		  if(c.getNumber1()==ListOfSuspects.get(i).getSuspectCommunicationList().get(j)) {
			  
			  for(int k=0;k<ListOfSuspects.size();k++) {
			   for(int x = 0;x<ListOfSuspects.get(k).getSuspectCommunicationList().size();x++){
				   
                   if(c.getNumber2()==ListOfSuspects.get(k).getSuspectCommunicationList().get(x))
			        ListOfSuspects.get(i).addPartner(ListOfSuspects.get(k));
			       }
		      }
			  }
		    }
		  
		  }
		}
	  
		
	//Μέθοδος προσθήκης ύποπτου μηνύματος στην αντίστοιχη λίστα//
	public void addDangerousSMS(SMS s) {
		listOfMessages.add(s);
		}
	
	
	//Μέθοδος για την επιστροφή του υπόπτου με τους περισσότερους συνεργάτες//
	public Suspect getSuspectWithMostPartners() {
		
		Suspect topSuspect=ListOfSuspects.get(0);
		
		for(int i=0; i<ListOfSuspects.size();i++) {
			
			int b=ListOfSuspects.get(i).getListOfPartners().size();
			
			  if(b>topSuspect.getListOfPartners().size()){
				  topSuspect=ListOfSuspects.get(i);
				  			   }
            }
		
		 return topSuspect;	
	 }
	
	
	//Μέθοδος επιστροφής της μεγαλύτερης σε διάρκεια κλήσης//
	public PhoneCall getLongestPhoneCallBetween(String number1,String number2) {
		
		int MaxDurationOfPhoneCall = comms.get(0).getDuration();
		

		PhoneCall longestCall = new PhoneCall(comms.get(0).getNumber1(),comms.get(0).getNumber2(),comms.get(0).getDay(),comms.get(0).getMonth(),comms.get(0).getYear(),comms.get(0).getDuration());
	
		
		 for(int i=0;i<comms.size();i++) {
			 
			 if(comms.get(i).getNumber1()==number1 && comms.get(i).getNumber2()==number2) {
				 
				 if(comms.get(i).getDuration()>MaxDurationOfPhoneCall) {//σε λιστα αντι πινακα?//
					 
					 longestCall = new PhoneCall(comms.get(i).getNumber1(),comms.get(i).getNumber2(),comms.get(i).getDay(),comms.get(i).getMonth(),comms.get(i).getYear(),comms.get(i).getDuration());
				 }
			 } 
				 
		 }
		 return longestCall;
	}

	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {	
		
		for(int i=0;i<comms.size();i++) {
			
		  if(comms.get(i).getNumber1()==number1 && comms.get(i).getNumber2()==number2) {
			  
			if(comms.get(i).getSMSText().contains("Bomb")||comms.get(i).getSMSText().contains("Attack")||comms.get(i).getSMSText().contains("Explosives")||comms.get(i).getSMSText().contains("Gun")) {
				
				listOfMessages.add(new SMS(comms.get(i).getNumber1(),comms.get(i).getNumber2(),comms.get(i).getDay(),comms.get(i).getMonth(),comms.get(i).getYear(),comms.get(i).getSMSText()));
			   }
					
		     }
		  }
		return listOfMessages;
	}
	
	
	public void printSuspectsFromCountry(String country) {
		
		System.out.println("Suspects coming from " + country + ":");

		for(int i=0;i<ListOfSuspects.size();i++) {
			if(ListOfSuspects.get(i).getCountry()==country) {
				System.out.println(""+ListOfSuspects.get(i).getName() + "("+ListOfSuspects.get(i).getCodeName()+")");
			  }			
		   }
			
	}
	
	  public static ArrayList<Communication> getComms() {
		 return comms;
	   }
	  
	  public static ArrayList<Suspect> getListOfSuspects() {
			 return ListOfSuspects;
		   }
	
		
	}
	

