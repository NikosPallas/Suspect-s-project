import java.util.Date;


public class SMS extends Communication{
	
private  String SMStext;
	
	public SMS(String number1, String number2, int day, int month, int year, String smstext) {
		super(number1,number2,day,month,year);
		SMStext = smstext;
	
	}
	
	public String getSMSText() {
		return SMStext;
	}
	
	public void printInfo() {
		System.out.println("This SMS has the following info");
		System.out.println("Between "+ getNumber1() + "---" +getNumber2());
		String date = dateFormat.format(new Date(getYear()-1900,getMonth(),getDay()));//Αφαιρώ το 1900 από το πεδίο του έτους λόγω της ημιτελούς κλάσης Date//
		System.out.println("on " + date);
		System.out.println("Text: " + SMStext) ;
		
		
	}

	

}
