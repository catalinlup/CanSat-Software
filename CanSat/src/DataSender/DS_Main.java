package DataSender;

import java.io.IOException;
import processing.serial.*;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

import DataManagement.DataFunctions_Encoding_Decoding;
import DataManagement.DataSet;
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
		
		
	}
	
	
	public void draw() {
		logger.Run();
	}

}
