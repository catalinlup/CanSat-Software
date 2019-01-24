package GUI;

import java.util.concurrent.Callable;

import processing.core.*;

public interface Element {
	
	
	public void show();
	
	public void onHoverAction(Callable<Integer> action);
	public void onClickAction(Callable<Integer> action);
	
	public void setText(String str);
	public void setPosition(float x,float y);
	public void setDim(float width, float height);
	public void setTextFont(PFont font);
	public void setTextColor(int r,int g,int b);
	public void setBackColor(int r,int g,int b);
	
	public String getText();
	public PVector getPosition();
	public PVector getDim();
	
	public boolean Hovering();
	public boolean Clicking();
	
}
