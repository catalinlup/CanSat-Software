package GUI;

import java.util.concurrent.Callable;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class Button implements Element{
	private PApplet parent;
	private String text="Click me!";
	private float x=0,y=0;
	private float width=100,height=50;
	private int tr=255,tg=0,tb=0;
	private int br=255,bg=255,bb=255;
	private PFont font;
	private boolean mouseWasOver = false;
	private Callable hoverAction = new Callable<Integer>() {
		public Integer call() {
			
			if(mouseWasOver)
				return 0;
			
			tr = 255-tr;
			tg = 255-tg;
			tb = 255-tb;
			
			br = 255-br;
			bg = 255-bg;
			bb = 255-bb;
			
			mouseWasOver = true;
			return 0;
		}
	};
	private Callable clickAction;
	private Callable leaveAction = new Callable<Integer>() {
		public Integer call() {
			
			if(!mouseWasOver)
				return 0;
			
			
			tr = 255-tr;
			tg = 255-tg;
			tb = 255-tb;
			
			br = 255-br;
			bg = 255-bg;
			bb = 255-bb;
			
			mouseWasOver = false;
			
			return 0;
		}
	};
	
	public Button(PApplet parent) {
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
		
		float threshX = parent.abs(width-parent.textWidth(text))/2;
		float threshY = parent.abs(height-parent.textDescent())/1.5f;
		parent.text(text,threshX+x,threshY+y);
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
		else {
			try {
				if(leaveAction!=null)
					leaveAction.call();
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

	@Override
	public void onLeaveAction(Callable<Integer> action) {
		// TODO Auto-generated method stub
		leaveAction = action;
	}
}
