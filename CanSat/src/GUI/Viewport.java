package GUI;
import java.util.concurrent.Callable;

import processing.core.*;

public class Viewport {
	
	private PApplet parent;
	private PGraphics pg;
	int width, height;
	int x,y;
	int r=125,g=125,b=125;
	
	Callable drawAction;
	
	public Viewport(PApplet parent,int width,int height,int x,int y) {
		this.parent = parent;
		this.width = width;
		this.height = height;
		this.x=x;
		this.y=y;
		pg = parent.createGraphics(width,height,parent.P3D);
	}
	
	public void show() {
		pg.beginDraw();
		pg.background(r,g,b);
	
		if(drawAction!=null)
			try {
				drawAction.call();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		pg.endDraw();
		
		parent.image(pg, x, y); 
	}
	
	public void setBackColor(int r,int g,int b) {
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
	public void addDrawAction(Callable<Integer> action) {
		drawAction = action;
	}
	
	public PGraphics getObject() {
		
		return pg;
	}
}
