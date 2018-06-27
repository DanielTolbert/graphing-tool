import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ClientAsisstants.ClockTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Graph extends Application {
	
	static Scanner s = new Scanner(System.in);
	static ArrayList<Number> values = new ArrayList<Number>();
	static XYChart.Series series1 = new XYChart.Series();
	static XYChart.Series series2 = new XYChart.Series();
	static ClockTimer clock = new ClockTimer();
	
	int rawSeconds = 0;
	int realSeconds = 0;

	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override public void start(Stage stage) {
	        stage.setTitle("Just Some Values");
//	        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
//	        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
	        final NumberAxis xAxis = new NumberAxis(0, clock.getSeconds(), 1);
	        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);        
	        final LineChart<Number,Number> sc = new
	            LineChart<Number,Number>(xAxis,yAxis);
	        xAxis.setLabel("x value");                
	        yAxis.setLabel("y value");
	        sc.setTitle("Investment Overview");
	       
	        series1.setName("Values");
	        
	        sc.getData().addAll(series1, series2);
	        Scene scene  = new Scene(sc, 500, 400);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    public static void main(String[] args) {
	    	
	    	ExecutorService exc = Executors.newCachedThreadPool();
	    	exc.execute(new ClockTimer());
	    	
	    	String information = "";
	    	boolean start = false;
	    	
	    	do {
	    		System.out.println("input x coordinate: ");

	    		try {
	    			values.add(s.nextInt());
	    			System.out.println("input y coordinate: ");
	    			values.add(s.nextInt());
	    		}catch(Exception e) {
	    			if(s.next().contains("done")) {
	    				start = true;
	    				continue;
	    			} else
	    			System.out.println("LOL make sure it's a friggin number");
	    		}
	    		
	    	}while(!start);
	    	
	    	for(int i = 0; i<values.size(); i+=2) {
	    		
	    		series1.getData().add(new XYChart.Data(values.get(i), values.get(i + 1)));
	    		
	    	}
	    	launch(args);
	    	
	    	
//				if(rawSeconds != (int)System.currentTimeMillis()/1000%10) {
//					realSeconds++;
//					rawSeconds = (int)System.currentTimeMillis()/1000%10;
//				}
//				System.out.println(realSeconds);
	//
//			}
	    	
	    }

}
