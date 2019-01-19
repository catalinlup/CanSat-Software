package DataInterpreter;

import processing.core.*;
import processing.serial.*;
import cc.arduino.*;

public class DI_Main extends PApplet{

	Arduino arduino;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataInterpreter.DI_Main");
	}
	
	public void settings() {
		size(300,300);
	}
	
	public void setup() {
		fill(120,20,50);
		
		System.out.println(Arduino.list());
		
		arduino = new Arduino(this,Arduino.list()[0],57600);
		arduino.pinMode(13, Arduino.OUTPUT);
	}
	
	public void draw() {
		
		
		arduino.digitalWrite(13,Arduino.HIGH);
	}

}
