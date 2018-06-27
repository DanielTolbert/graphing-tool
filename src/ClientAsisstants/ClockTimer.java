package ClientAsisstants;

public class ClockTimer implements Runnable{

	static volatile int rawSeconds = 0;
	static volatile int realSeconds = 0;
	
	public static void main(String [] args) {
		
//		countSeconds();
		
	}
	
	public static void countSeconds() {
		
		while(true) {
			if(rawSeconds != (int)System.currentTimeMillis()/1000%10) {
				realSeconds++;
				rawSeconds = (int)System.currentTimeMillis()/1000%10;
			    System.out.println(realSeconds);
			}
			
		}

		
	}

	@Override
	public void run() {
		
		countSeconds();
		
	}
	
	public static int getSeconds() {
		
		return realSeconds;
		
	}
	
	
}
