package GUI;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Window {
	private PApplet parent;
	private List elements = new ArrayList();
	private List viewports = new ArrayList();
	private int r=125,g=125,b=125;
	
	public Window(PApplet parent) {
		this.parent = parent;
	}
	
	public void addElement(Element e) {
		elements.add(e);
	}
	
	public void addViewport(Viewport v) {
		viewports.add(v);
	}
	
	public void setBackColor(int r,int g,int b) {
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
	public void show() {
		parent.clear();
		parent.background(r,g,b);
		for(int i=0;i<viewports.size();i++) {
			((Viewport)viewports.get(i)).show();
			
		}
		for(int i=0;i<elements.size();i++) {
			((Element)elements.get(i)).show();
		}
			
	}
}
