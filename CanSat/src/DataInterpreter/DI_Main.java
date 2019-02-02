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
	private Viewport viewport;

	private Graph g;
	private double[][] data1;
	double fraction;
	
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
		
		fraction = 0.00001;
	    data1 = new double[(int)(30 * (1 / fraction))][2];
	    
	    for(double i = 0; i * (1 / fraction) < data1.length; i += fraction) {
	    		data1[(int)(i * (1 / fraction))][0] = i * 10;
	    		data1[(int)(i * (1 / fraction))][1] = i * (i / 2);
	    }
		
	    int[] a = new int[2];
	    
	    viewport = new Viewport(this, 500, 500, 520, 10);
		g = new Graph(10, 10, 500, 500, a, a, data1, fraction, this);
		window.addViewport(viewport);
		window.addViewport(g.getViewport());
	}
	
	float i = 0;
	
	public void draw() {
		g.drawGraph(p);
		
		viewport.addDrawAction(new Callable<Integer>(){
			public Integer call() {
				viewport.getObject().background(100);
				viewport.getObject().noFill();
				viewport.getObject().stroke(0, 255, 0);
				
				viewport.getObject().pushMatrix();
				viewport.getObject().translate(250, 250);
				viewport.getObject().rotateX(i);
				viewport.getObject().rotateY(i);
				viewport.getObject().rotateZ(i);
				
				int sides = 10;
				
				float angle = 360 / sides;
			    beginShape();
			    for (int i = 0; i < sides; i++) {
			        float x = cos( radians( i * angle ) ) * r;
			        float y = sin( radians( i * angle ) ) * r;
			        vertex( x, y );        
			    }
			    endShape(CLOSE);
				
				//viewport.getObject().box(100);
				viewport.getObject().popMatrix();
				
				return 0;
			}
		});
		
		if(i >= Math.PI * 2) {
			i = 0;
		}
		
		i += 0.01;
		
		window.show();
	}
}
