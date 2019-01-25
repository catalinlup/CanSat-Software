package DataInterpreter;

import processing.core.*;
import processing.serial.*;
import cc.arduino.*;

import java.util.concurrent.Callable;

import GUI.*;

public class DI_Main extends PApplet{

	//The code below is just for testing purposes
	
	private Window window;
	private Viewport viewport;
	private Button addAngle;
	private Button subtractAngle;
	private Label angleLbl;
	private float angle = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("DataInterpreter.DI_Main");
	}
	
	public void settings() {
		size(600,400,P3D);
	}
	
	public void setup() {
		window = new Window(this);
		viewport = new Viewport(this,400,300,10,10);
		viewport.setBackColor(255, 0, 0);
		addAngle = new Button(this);
		subtractAngle = new Button(this);
		
		addAngle.setPosition(450, 50);
		addAngle.setText("Add");
		subtractAngle.setPosition(450,100);
		subtractAngle.setText("Subtract");
		
		addAngle.onClickAction(new Callable<Integer>() {
			public Integer call() {
				angle+=0.1f;
				return 0;
			}
		});
		
		subtractAngle.onClickAction(new Callable<Integer>() {
			public Integer call() {
				angle-=0.1f;
				return 0;
			}
		});
		
		window.addViewport(viewport);
		window.addElement(addAngle);
		window.addElement(subtractAngle);
	}
	
	public void draw() {
		
		
		viewport.addDrawAction(new Callable<Integer>() {
			public Integer call() {
				float fov = PI/3.0f; 
			    float cameraZ = (300/2.0f) / tan(fov/2.0f); 
			    viewport.getObject().noFill();
			    viewport.getObject().perspective(fov, (float)(400/300), cameraZ/2.0f, cameraZ*2.0f);
			    viewport.getObject().translate(400/2, 300/2, -10);
			    viewport.getObject().rotateX(-PI/6); 
			    viewport.getObject().rotateY(angle); 
			    viewport.getObject().box(160); 
				return 0;
			}
		});
		
		window.show();
		
	}
	
	
}
