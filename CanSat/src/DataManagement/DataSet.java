package DataManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//The DataSet class stores the data to be sent to the ground
//the DataSet consists of a set of data packages
//each package contains data collected during the same period of time
public class DataSet{
	
	public static DataSet createFromJson(String json) {
		Gson gson = new Gson();
		DataSet ret = gson.fromJson(json, DataSet.class);
		return ret;
	}
	
	private List data = new ArrayList();
	
	public void add(DataPackage value) {
		data.add(value);
	}
	
	public void add(DataPackage[] values) {
		for(int i=0;i<values.length;i++) {
			data.add(values[i]);
		}
			
	}
	
	//returns the data in json format
	public String getJson() {
		Gson gson = new Gson();
		
		return gson.toJson(this);
	}
	
	public String getJsonPretty() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(this);
	}
	
	//format timeStamp, mX,mY,mZ,aX,aY,aZ,gX,gY,gZ
	public String getCSV() {
		
		String header = "Time,"
				+ "MagneticX,MagneticY,MagneticZ,"
				+ "AccelerationX,AcclerationY,AcclerationZ,"
				+ "GyroscopeX,GyroscopeY,GyroscopeZ";
		
		String csvDoc = "";
		
		csvDoc+=header+"\n";
		
		for(int i=0;i<data.size();i++) {
			DataPackage pkg = (DataPackage)(data.get(i));
			csvDoc+=pkg.getCSVRow()+"\n";
		}
		
		return csvDoc;
	}
}










