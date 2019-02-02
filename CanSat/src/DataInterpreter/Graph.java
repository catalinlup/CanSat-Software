package DataInterpreter;
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
	private int offset = 10;
	
	public Graph(int width, int height, int[] xLimits, int[] yLimits, double[][] data, double fraction,Viewport vp) {
		this.vp = vp;
		this.width = width;
		this.height = height;
		this.xLimits = xLimits;
		this.yLimits = yLimits;
		this.data = data;
		this.fraction = fraction;
	}
	
	public void drawGraph(PApplet p) {
		vp.getObject().fill(255);
		vp.getObject().rect(0, 0, width, height);
		
		vp.getObject().rect(offset, offset, 1, height - 2 * offset);
		vp.getObject().rect(offset, height - offset, width - 2 * offset, 1);
		
		/*
		PFont font = new PFont();
		font = p.createFont("Arial", 16);
		p.textFont(font);
		p.text("hello world", vp.getX() + 10, vp.getY() + 10);
		Label l = new Label(p);
		*/
		//System.out.println(data.length);
		for(double i = 0; i * (1 / fraction) < data.length; i++) {
			vp.getObject().rect((int)(offset + data[(int)(i * (1 / fraction))][0]), (int)(vp.getHeight() - offset - data[(int)(i * (1 / fraction))][1]), 1, 1);
		}
	}
}
