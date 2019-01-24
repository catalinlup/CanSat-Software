package DataManagement;

import java.util.Date;

//the class representing a data package (data collected during the same time period)
public class DataPackage{
	private Date dateCreated;//the timestamp of the package
	private MagneticData mData;
	private AccelerationData aData;
	private GyroscopeData gData;
	private TemperatureData tData;
	
	public DataPackage(MagneticData mData, AccelerationData aData, GyroscopeData gData, TemperatureData tData) {
		dateCreated = new Date();
		this.mData = mData;
		this.aData = aData;
		this.gData = gData;
		this.tData = tData;
	}
}