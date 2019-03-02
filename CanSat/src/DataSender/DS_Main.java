package DataSender;

import java.io.IOException;
import processing.serial.*;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

import DataManagement.AccelerationData;
import DataManagement.DataFunctions_Encoding_Decoding;
import DataManagement.DataPackage;
import DataManagement.DataSet;
import DataManagement.GyroscopeData;
import DataManagement.MagneticData;
import DataManagement.TemperatureData;
import DataManagement.XYZValue;
import GUI.Button;
import GUI.Label;
import GUI.Textbox;
import GUI.Viewport;
import GUI.Window;
import processing.core.PApplet;


//the entry point for the program running on the CanSat
public class DS_Main extends PApplet{
	
	static {
		   
	    try {
	        System.load("/home/pi/JavaDLL/libjSSC-2.8.so");
	        System.out.println("Loaded library");
	        
	    } catch (UnsatisfiedLinkError e) {
	    	System.out.println("Error - Loading library");
	    	e.printStackTrace();
	    }
	}
	
	
	private KeyLogger logger;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataSender.DS_Main");
	}
	
	public void settings() {
		size(800,600,P3D);
	}
	
	public void setup() {
		
		Sensors.parent = this;
		
		logger = new KeyLogger(this);
		
		
		/*AccelerationData acc = new AccelerationData();
		acc.add(new XYZValue("15","20","25"));
		GyroscopeData gyr = new GyroscopeData();
		gyr.add(new XYZValue("12","18","11"));
		MagneticData mg = new MagneticData();
		mg.add(new XYZValue("25","76","43"));
		TemperatureData tm = new TemperatureData();
		DataPackage pk = new DataPackage(mg,acc,gyr,tm);
		DataSet dataSet = new DataSet();
		dataSet.add(pk);
		dataSet.add(pk);
		println(dataSet.getCSV());*/
	}
	
	
	public void draw() {
		logger.Run();
	}

}
