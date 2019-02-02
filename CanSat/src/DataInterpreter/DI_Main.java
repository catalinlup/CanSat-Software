package DataInterpreter;

import processing.core.*;
import processing.serial.*;
import cc.arduino.*;

import java.util.concurrent.Callable;

import GUI.*;

public class DI_Main extends PApplet{

	//The code below is just for testing purposes
	
	private Window window;
	private PApplet p = this;

	private Graph g;
	private double[][] data1;
	private double[][] data2;
	double fraction;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataInterpreter.DI_Main");
	}
	
	public void settings() {
		size(1000,1000,P3D);
	}
	
	public void setup() {
		window = new Window(this);
		window.setBackColor(255, 255, 255);
		
		fraction = 0.00001;
	    data1 = new double[(int)(50 * (1 / fraction))][2];
	    
	    for(double i = 0; i * (1 / fraction) < data1.length; i += fraction) {
	    		data1[(int)(i * (1 / fraction))][0] = i * 10;
	    		data1[(int)(i * (1 / fraction))][1] = i * (i / 2);
	    }
	    
	    data2 = new double[(int)(50 * (1 / fraction))][2];
	    
	    for(double i = 0; i * (1 / fraction) < data2.length; i += fraction) {
	    		data2[(int)(i * (1 / fraction))][0] = i * 5;
	    		data2[(int)(i * (1 / fraction))][1] = Math.sqrt(i) * 10;
	    }
		
	    int[] a = new int[2];
	    
		g = new Graph(10, 10, 500, 500, a, a, data1, fraction, this);
		window.addViewport(g.getViewport());
	}
	
	public void draw() {
		g.drawGraph(p);
		window.show();
	}
}
