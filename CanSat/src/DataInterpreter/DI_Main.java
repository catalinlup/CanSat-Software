package DataInterpreter;

import processing.core.*;
import processing.serial.*;
import cc.arduino.*;

public class DI_Main extends PApplet{

	//The code below is just for testing purposes
	//This is an example of how threading can be used on arduino
	
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
		arduino.pinMode(2, Arduino.OUTPUT);
		arduino.pinMode(3, Arduino.OUTPUT);
		
		thread("blinkLed2");
		thread("blinkLed3");
	}
	
	public void draw() {
		
		
		arduino.digitalWrite(13,Arduino.HIGH);
	}
	
	public void blinkLed2() {
		int initTime = millis();
		
		while(millis()-initTime < 5000) {
			arduino.digitalWrite(2,Arduino.HIGH);
			delay(500);
			arduino.digitalWrite(2,Arduino.LOW);
			delay(500);
		}
	}
	
	public void blinkLed3() {
		
		int initTime = millis();
		
		while(millis()-initTime < 5000) {
			arduino.digitalWrite(3,Arduino.HIGH);
			delay(500);
			arduino.digitalWrite(3,Arduino.LOW);
			delay(500);
		}
	}

}
