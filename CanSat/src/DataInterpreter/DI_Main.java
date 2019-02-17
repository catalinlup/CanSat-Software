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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataInterpreter.DI_Main");
	}
	
	public void settings() {
		size(1030, 520, P3D);
	}
	
	public void setup() {
		window = new Window(this);
		window.setBackColor(255, 255, 255);
		
	    data1 = new double[200][2];
		
	    int[] limX = new int[2];
	    limX[0] = 0;
	    limX[1] = 200;
	    
	    int[] limY = new int[2];
	    limY[0] = 0;
	    limY[1] = 15;
	    
		g = new Graph(10, 10, 1000, 500, limX, limY, data1, this);
		window.addViewport(g.getViewport());
	}
	
	float i = 0;
	
	public void draw() {
		for(int j = 0; j < data1.length; j++) {
    			data1[j][0] = j;
    			data1[j][1] = Math.sqrt(data1[j][0]);
		}
	
		g.drawGraph(p);
		
		if(i >= Math.PI * 2) {
			i = 0;
		}
		
		i += 0.01;
		
		window.show();
	}
}
