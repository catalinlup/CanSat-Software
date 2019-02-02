package DataSender;
import DataManagement.AccelerationData;
import DataManagement.DataPackage;
import DataManagement.GyroscopeData;
import DataManagement.MagneticData;
import DataManagement.TemperatureData;
import processing.core.*;

//the Sensors class contains all the methods which return the data collected by the sensors
public class Sensors {
	private static final int millisToRun = 1;
	
	public static PApplet parent;
	
	private static MagneticData curM;
	private static TemperatureData curT;
	private static GyroscopeData curG;
	private static AccelerationData curA;
	
	private static boolean MagneticRun = false;
	private static boolean TemperatureRun = false;
	private static boolean GyroscopeRun = false;
	private static boolean AccelerationRun = false;
	
	
	
	
	public static DataPackage getData() {
		DataPackage ret = null;
		
		Thread tM = new Thread(new MagneticThread());
		Thread tT = new Thread(new TemperatureThread());
		Thread tG = new Thread(new GyroscopeThread());
		Thread tA = new Thread(new AccelerationThread());
		
		tM.start();
		tA.start();
		tT.start();
		tG.start();
		
		while(MagneticRun||AccelerationRun||TemperatureRun||GyroscopeRun) {
			System.out.println("DA");
		}
		
		ret = new DataPackage(curM,curA,curG,curT);
		
		return ret;
	}
	
	static class MagneticThread implements Runnable{
		
		public void run() {
			MagneticRun = true;
			curM = new MagneticData();
			int startTime = parent.millis();
			while(parent.millis()-startTime <= millisToRun) {
				//curM.add((int)(parent.random(100)));
			}
			MagneticRun = false;
		}
	}
	
	static class AccelerationThread implements Runnable{
		
		public void run() {
			AccelerationRun = true;
			curA = new AccelerationData();
			int startTime = parent.millis();
			while(parent.millis()-startTime <= millisToRun) {
				//curA.add((int)(parent.random(100)));
			}
			AccelerationRun = false;
		}
	}
	
	static class TemperatureThread implements Runnable{
		
		public void run() {
			TemperatureRun = true;
			curT = new TemperatureData();
			int startTime = parent.millis();
			while(parent.millis()-startTime <= millisToRun) {
				//curT.add((int)(parent.random(100)));
			}
			TemperatureRun = false;
		}
	}

	static class GyroscopeThread implements Runnable{
		
		public void run() {
			GyroscopeRun = true;
			curG = new GyroscopeData();
			int startTime = parent.millis();
			while(parent.millis()-startTime <= millisToRun) {
				//curG.add((int)(parent.random(100)));
			}
			GyroscopeRun = false;
		}
	}
	
	
	
}


