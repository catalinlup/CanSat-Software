package DataInterpreter;
import java.util.concurrent.Callable;

import GUI.*;
import processing.core.*;


public class Graph {
	private int width;
	private int height;
	private int[] xLimits;
	private int[] yLimits;
	private double[][] data;
	double fraction;
	private Viewport vp;
	private PApplet parent;
	
	private int offset = 20;
	
	public Graph(int x, int y, int width, int height, int[] xLimits, int[] yLimits, double[][] data, double fraction, PApplet parent) {
		this.parent = parent;
		this.vp = new Viewport(parent, width, height, x, y);
		this.width = width;
		this.height = height;
		this.xLimits = xLimits;
		this.yLimits = yLimits;
		this.data = data;
		this.fraction = fraction;
	}
	
	public Viewport getViewport() {
		return vp;
	}
	
	public void drawGraph(PApplet p) {
		vp.addDrawAction(new Callable<Integer>(){
			public Integer call() {
				vp.getObject().fill(255);
				vp.getObject().rect(0, 0, width, height);
				
				vp.getObject().rect(offset, offset, 1, height - 2 * offset);
				vp.getObject().rect(offset, height - offset, width - 2 * offset, 1);
				
				/*PFont font = new PFont();
				font = p.createFont("Arial", 16);
				vp.getObject().textFont(font, 36);
				vp.getObject().fill(0);
				vp.getObject().text("hello world", 300, 300);*/
				
				for(double i = 0; i * (1 / fraction) < data.length; i++) {
					vp.getObject().rect((int)(offset + data[(int)(i * (1 / fraction))][0]), (int)(vp.getHeight() - offset - data[(int)(i * (1 / fraction))][1]), 1, 1);
				}
				
				return 0;
			}
		});
	}
}
