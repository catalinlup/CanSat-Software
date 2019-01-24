package DataSender;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

import DataManagement.DataFunctions_Encoding_Decoding;
import DataManagement.DataSet;
import GUI.Label;
import GUI.Window;
import processing.core.PApplet;


//the entry point for the program running on the CanSat
public class DS_Main extends PApplet{

	private Window window;
	private Label lbl1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataSender.DS_Main");
	}
	
	public void settings() {
		size(800,600);
	}
	
	public void setup() {
		Sensors.parent = this;
		window = new Window(this);
		lbl1 = new Label(this);
		window.addElement(lbl1);
		
		lbl1.setText("Hellow World");
		lbl1.setTextColor(255,0,0);
		lbl1.setBackColor(0, 255, 0);
		lbl1.setPosition(width/2, height/2);
		lbl1.onHoverAction(new Callable<Integer>() {
			public Integer call() {
				lbl1.setBackColor(0,0,255);
				return 0;
			}
		});
		
	}
	
	public void draw() {
		window.show();
	}

}
