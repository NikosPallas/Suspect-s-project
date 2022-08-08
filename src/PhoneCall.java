
public class PhoneCall extends Communication{
	
private  int DurationOfCall;
	
	public PhoneCall(String number1, String number2, int day, int month, int year,int duration) {
		super(number1,number2,day,month,year);
		DurationOfCall = duration;
	}
	
	public  int getDuration() {
		return DurationOfCall;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.println("Duration:" + DurationOfCall);
		
	}

}
