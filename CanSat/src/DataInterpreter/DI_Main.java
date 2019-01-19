package DataInterpreter;

import processing.core.*;

public class DI_Main extends PApplet{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataInterpreter.DI_Main");
	}
	
	public void settings() {
		size(300,300);
	}
	
	public void setup() {
		fill(120,20,50);
	}
	
	public void draw() {
		ellipse(width/2,height/2,second(),second());
	}

}
