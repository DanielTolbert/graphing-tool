package ClientAsisstants;

public class ClockTimer implements Runnable{

	static volatile int rawSeconds = 0;
	static volatile int realSeconds = 0;
	
	static volatile int rawMilis = 0;
	static volatile int realMilis = 0;
	
	public static void main(String [] args) {
		
		countMiliSeconds();
		
	}
	
	public static void countSeconds() {
		
		while(true) {
			if(rawSeconds != (int)System.currentTimeMillis()/1000%10) {
				realSeconds++;
				rawSeconds = (int)System.currentTimeMillis()/1000%10;
//			    System.out.println(realSeconds);
			    
			}
			
		}

	}
	
	public static void countMiliSeconds() {
		
		while(true) {
			if(rawMilis != (int)System.currentTimeMillis()/10%10) {
				realMilis++;
				rawMilis = (int)System.currentTimeMillis()/10%10;
//			    System.out.println(realMilis);
			    
			}
			
		}
		
	}

	@Override
	public void run() {
		
		countSeconds();
		countMiliSeconds();
		
	}
	
	public static int getSeconds() {
		return realSeconds;
	}
	
	public static int getMiliseconds() {
		return realMilis;
	}
	
	
}
