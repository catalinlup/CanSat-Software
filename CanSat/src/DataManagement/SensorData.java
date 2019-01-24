package DataManagement;

import java.util.List;

//interface for sensorData
public interface SensorData {
	public boolean isActive();
	public void loadData(float data);
	public String getDataString();
	
}
