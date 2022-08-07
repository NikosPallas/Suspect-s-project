import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Communication {
	private ArrayList<PhoneCall> ListOfPhoneCalls;
	
	private String Num1;
	private String Num2;
	private int Day;
	private int Month;
	private int Year;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
	
	public Communication(String number1, String number2, int day, int month, int year) {
		Num1 = number1;
		Num2 = number2;
		Day = day;
		Month = month;
		Year = year;
		
	}
	
	public String getNumber1() {
		return Num1;
		
	}
	
	public String getNumber2() {
		return Num2;
		
	}
	
	public int getDay(){
		return Day;
	}
	
	public int getMonth(){
		return Month;
	}
	
	public int getYear(){
		return Year;
	}
	
	public int getDuration() {
		return 0;
	}
	
	public String getSMSText() {
		return "";
		
	}
	

	public void printInfo() {
		System.out.println("This phone call has the following info ");
		System.out.println("Between " + Num1 + "---" +Num2);
		String date = dateFormat.format(new Date(getYear()-1900,getMonth(),getDay()));//Αφαιρώ το 1900 από το πεδίο του έτους λόγω της ημιτελούς κλάσης Date//
		System.out.println("on " + date);
		
	}
}
