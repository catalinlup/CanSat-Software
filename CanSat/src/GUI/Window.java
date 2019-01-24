package GUI;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Window {
	private PApplet parent;
	private List elements = new ArrayList();
	
	public Window(PApplet parent) {
		this.parent = parent;
	}
	
	public void addElement(Element e) {
		elements.add(e);
	}
	
	public void show() {
		parent.clear();
		for(int i=0;i<elements.size();i++) {
			((Element)elements.get(i)).show();
		}
			
	}
}
