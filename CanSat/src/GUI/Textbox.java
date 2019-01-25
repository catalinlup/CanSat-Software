package GUI;

import java.util.concurrent.Callable;

import processing.core.*;

public class Textbox implements Element{

	private PApplet parent;
	private String text="Write here...";
	private float x=0,y=0;
	private float width=300,height=50;
	private int tr=255,tg=0,tb=0;
	private int br=255,bg=255,bb=255;
	private PFont font;
	private boolean selected = false;
	private Callable hoverAction;
	private Callable clickAction = new Callable<Integer>() {
		public Integer call() {
			if(selected)
				return 0;
			selected = true;
			
			return 0;
		}
	};
	private Callable leaveAction = new Callable<Integer>() {
		public Integer call() {
			
			if(!selected)
				return 0;
			
			selected = false;
			
			return 0;
		}
	};;
	
	public Textbox(PApplet parent) {
		this.parent = parent;
		font = parent.createFont("Arial", 16);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		if(selected) {
			if(parent.keyPressed) {
				if(parent.key == parent.BACKSPACE) {
					if(text.length()>0)
						text = text.substring(0,text.length()-1);
				}
				else if(parent.key != parent.CODED)
					text+=parent.key;
				parent.delay(150);
			}
		}
		
		parent.fill(br,bg,bb);
		parent.rect(x,y,width,height);
		parent.noFill();
		
		parent.fill(tr,tg,tb);
		parent.textFont(font);
		
		float threshX = (width-parent.textWidth(text))/2;
		
		String cuttedText = text;
		
		while(threshX<0) {
			cuttedText = cuttedText.substring(0, cuttedText.length()-1);
			
			threshX = (width-parent.textWidth(cuttedText))/2;
		}
		
		float threshY = parent.abs(height-parent.textDescent())/1.5f;
		
		
		
		
		if(selected)	
			parent.text(cuttedText+"|",threshX+x,threshY+y);
		else
			parent.text(cuttedText,threshX+x,threshY+y);
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
	public void onLeaveAction(Callable<Integer> action) {
		// TODO Auto-generated method stub
		
		leaveAction = action;
		
	}

	@Override
	public void setText(String str) {
		// TODO Auto-generated method stub
		
		text = str;
		
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
	public void setTextFont(PFont font) {
		// TODO Auto-generated method stub
		this.font = font;
		
	}

	@Override
	public void setTextColor(int r, int g, int b) {
		// TODO Auto-generated method stub
		this.tr = r;
		this.tg = g;
		this.tb = b;
	}

	@Override
	public void setBackColor(int r, int g, int b) {
		// TODO Auto-generated method stub
		this.br = r;
		this.bg = g;
		this.bb = b;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
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
	public boolean Hovering() {
		// TODO Auto-generated method stub
		if(parent.mouseX>=x&&parent.mouseX<=x+width&&parent.mouseY>=y&&parent.mouseY<=y+height)
			return true;
		return false;
	}

	@Override
	public boolean Clicking() {
		// TODO Auto-generated method stub
		if(parent.mousePressed) {
			if(parent.mouseX>=x&&parent.mouseX<=x+width&&parent.mouseY>=y&&parent.mouseY<=y+height)
				return true;
		}
		return false;
	}

}
