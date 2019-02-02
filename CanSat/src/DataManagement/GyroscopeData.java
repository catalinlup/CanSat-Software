package DataManagement;

import java.util.ArrayList;
import java.util.List;

//class to store gyroscope data
public class GyroscopeData{
	private List data = new ArrayList();
	
	public void add(String value) {
		data.add(value);
	}
	public void add(int[] values) {
		for(int i=0;i<values.length;i++) {
			data.add(values[i]);
		}	
	}
}