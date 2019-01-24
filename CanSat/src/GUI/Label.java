package GUI;

import java.util.concurrent.Callable;

import processing.core.*;

public class Label implements Element{
	private PApplet parent;
	private String text="label";
	private float x=0,y=0;
	private float width=100,height=100;
	private int tr=255,tg=0,tb=0;
	private int br=255,bg=255,bb=255;
	private PFont font;
	private Callable hoverAction;
	private Callable clickAction;
	
	public Label(PApplet parent) {
		this.parent = parent;
		font = parent.createFont("Arial", 16);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		parent.fill(br,bg,bb);
		parent.rect(x,y,width,height);
		parent.noFill();
		
		parent.fill(tr,tg,tb);
		parent.textFont(font);
		parent.text(text,x,y);
		parent.noFill();
		
		if(Hovering()) {
			try {
				if(hoverAction!=null)
					hoverAction.call();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(Clicking()) {
			try {
				if(clickAction!=null)
					clickAction.call();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onHoverAction(Callable<Integer> action) {
		// TODO Auto-generated method stub
		hoverAction = action;
		
	}

	@Override
	public void onClickAction(Callable<Integer> action) {
		// TODO Auto-generated method stub
		clickAction = action;
	
	}

	@Override
	public void setText(String str) {
		// TODO Auto-generated method stub
		this.text = str;
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.text;
	}

	@Override
	public PVector getPosition() {
		// TODO Auto-generated method stub
		return new PVector(x,y);
	}

	@Override
	public PVector getDim() {
		// TODO Auto-generated method stub
		return new PVector(width,height);
	}
	@Override
	public void setTextFont(PFont font) {
		// TODO Auto-generated method stub
		this.font = font;
		
	}
	@Override
	public void setTextColor(int r, int g, int b) {
		// TODO Auto-generated method stub
		tr = r;
		tg = g;
		tb = b;
		
	}
	@Override
	public void setBackColor(int r, int g, int b) {
		// TODO Auto-generated method stub
		br = r;
		bg = g;
		bb = b;
		
	}

	@Override
	public boolean Hovering() {
		if(parent.mouseX>=x&&parent.mouseX<=x+width&&parent.mouseY>=y&&parent.mouseY<=y+height)
			return true;
		return false;
	}

	@Override
	public boolean Clicking() {
		if(parent.mousePressed) {
			if(parent.mouseX>=x&&parent.mouseX<=x+width&&parent.mouseY>=y&&parent.mouseY<=y+height)
				return true;
		}
		return false;
	}

	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void setDim(float width, float height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
	}
}
