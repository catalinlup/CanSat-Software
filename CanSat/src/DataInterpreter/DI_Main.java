package DataInterpreter;

import processing.core.*;
import processing.serial.*;
import cc.arduino.*;

import java.util.concurrent.Callable;

import GUI.*;

public class DI_Main extends PApplet{

	//The code below is just for testing purposes
	
	private Window window;
	private Viewport viewportGraph1;
	private Viewport viewportGraph2;
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
	    data1 = new double[(int)(100 * (1 / fraction))][2];
	    
	    for(double i = 0; i * (1 / fraction) < data1.length; i += fraction) {
	    		data1[(int)(i * (1 / fraction))][0] = i * 10;
	    		data1[(int)(i * (1 / fraction))][1] = i * (i / 2);
	    }
	    
	    data2 = new double[(int)(100 * (1 / fraction))][2];
	    
	    for(double i = 0; i * (1 / fraction) < data2.length; i += fraction) {
	    		data2[(int)(i * (1 / fraction))][0] = i * 5;
	    		data2[(int)(i * (1 / fraction))][1] = Math.sqrt(i) * 10;
	    }
		
		viewportGraph1 = new Viewport(this, 500, 500, 10, 10);
		viewportGraph1.setBackColor(255, 0, 0);
		
		viewportGraph2 = new Viewport(this, 400, 300, 520, 10);
		viewportGraph2.setBackColor(255, 0, 0);
		
		window.addViewport(viewportGraph1);
		window.addViewport(viewportGraph2);
	}
	
	public void draw() {
		viewportGraph1.addDrawAction(new Callable<Integer>() {
			public Integer call() {
			    int[] limit = new int[2];
			    limit[0] = 10;
			    limit[1] = 10;
			    
			    g = new Graph(viewportGraph1.getWidth(), viewportGraph1.getHeight(), limit, limit, data1, fraction,viewportGraph1);
			    g.drawGraph(p);
				return 0;
			}
		});
		
		viewportGraph2.addDrawAction(new Callable<Integer>() {
			public Integer call() {
			    int[] limit = new int[2];
			    limit[0] = 10;
			    limit[1] = 10;
			    
			    g = new Graph(viewportGraph2.getWidth(), viewportGraph2.getHeight(), limit, limit, data2, fraction,viewportGraph2);
			    g.drawGraph(p);
				return 0;
			}
		});
		
		window.show();
		
	}
	
	
}
