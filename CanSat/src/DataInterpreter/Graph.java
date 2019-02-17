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

	private Viewport vp;
	private PApplet parent;
	
	private int offset = 20;
	
	public Graph(int x, int y, int width, int height, int[] xLimits, int[] yLimits, double[][] data, PApplet parent) {
		this.parent = parent;
		this.vp = new Viewport(parent, width, height, x, y);
		this.width = width;
		this.height = height;
		this.xLimits = xLimits;
		this.yLimits = yLimits;
		this.data = data;
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
				
				PFont font = new PFont();
				font = p.createFont("Arial", 16);
				vp.getObject().textFont(font, 10);
				vp.getObject().fill(0);
				vp.getObject().text(xLimits[0], offset, height - offset + 10);
				vp.getObject().text(xLimits[1], width - offset - 10, height - offset + 10);
				
				vp.getObject().text(yLimits[0], 14, height - offset);
				vp.getObject().text(yLimits[1], offset, 16);
				
				vp.getObject().noFill();
				vp.getObject().stroke(255, 0, 0);
				
				double thetaX = (width - 2 * offset) / xLimits[1];
				double thetaY = (height - 2 * offset) / yLimits[1];
				
				for(int i = 0; i < data.length - 1; i++) {
					vp.getObject().line((int)(offset + data[i][0] * (width - 2 * offset) / xLimits[1]), 
							(int)(vp.getHeight() - offset - data[i][1] * (height - 2 * offset) / yLimits[1]), 
							(int)(offset + data[i + 1][0] * (width - 2 * offset) / xLimits[1]),
							(int)(vp.getHeight() - offset - data[i + 1][1] * (height - 2 * offset) / yLimits[1]));
				}
				return 0;
			}
		});
	}
	
	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}
}
