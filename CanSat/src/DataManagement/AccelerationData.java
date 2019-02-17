package DataManagement;

import java.util.ArrayList;
import java.util.List;

//class to store acceleration data
public class AccelerationData{
	private List data = new ArrayList();
	
	public void add(XYZValue value) {
		data.add(value);
	}
	public void add(XYZValue[] values) {
		for(int i=0;i<values.length;i++) {
			data.add(values[i]);
		}	
	}
	
	public String getXValueAvg() {
		if(data.size()==0)
			return "NULL";
		int avgX = 0;
		for(int i=0;i<data.size();i++) {
			XYZValue val = (XYZValue)(data.get(i));
			avgX += val.getIntX();
		}
		avgX/=data.size();
		
		return Integer.toString(avgX);
	}
	
	public String getYValueAvg() {
		if(data.size()==0)
			return "NULL";
		int avgY = 0;
		for(int i=0;i<data.size();i++) {
			XYZValue val = (XYZValue)(data.get(i));
			avgY += val.getIntY();
		}
		avgY/=data.size();
		
		return Integer.toString(avgY);
	}
	
	public String getZValueAvg() {
		if(data.size()==0)
			return "NULL";
		int avgZ = 0;
		for(int i=0;i<data.size();i++) {
			XYZValue val = (XYZValue)(data.get(i));
			avgZ += val.getIntZ();
		}
		avgZ/=data.size();
		
		return Integer.toString(avgZ);
	}
}
