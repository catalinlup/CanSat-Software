package DataManagement;

import java.util.Date;
import java.util.Formatter;

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
	
	public String getCSVRow() {
		

		StringBuilder sbuf = new StringBuilder();
		Formatter fmt = new Formatter(sbuf);
		fmt.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",dateCreated.toString(),
				mData.getXValueAvg(),mData.getYValueAvg(),mData.getZValueAvg(),
				aData.getXValueAvg(),mData.getYValueAvg(),mData.getZValueAvg(),
				gData.getXValueAvg(),gData.getYValueAvg(),mData.getZValueAvg(),
				tData.getTempAvg());
		
		return sbuf.toString();
	}
}