package DataManagement;

import java.util.ArrayList;
import java.util.List;

//class to store acceleration data
public class AccelerationData{
	private List data = new ArrayList();
	
	public void add(int value) {
		data.add(value);
	}
	public void add(int[] values) {
		for(int i=0;i<values.length;i++) {
			data.add(values[i]);
		}	
	}
}
