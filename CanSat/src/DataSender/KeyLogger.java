package DataSender;
import processing.core.*;
import processing.serial.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import DataManagement.*;

public class KeyLogger {
	
	private PApplet parent;
	private Serial port;
	private DataSet dataSet;
	private final int SaveTimeInterval = 20;
	
	public KeyLogger(PApplet parent) {
		this.parent = parent;
		port = new Serial(parent,Serial.list()[0],9600);
		port.bufferUntil('\n');
		dataSet = new DataSet();
	}
	
	public void resetDataSet() {
		dataSet = new DataSet();
	}
	
	public void Run() {
		
		
		
		if(port.available() > 0) {
			String inByte = port.readStringUntil('\n');
			if(inByte!=null) {
				//parent.println(inByte);
				String[] parts = inByte.split(";");
				if(parts.length < 10)
					return;
				//parent.println(parts.length);
				AccelerationData acc = new AccelerationData();
				acc.add("X: "+parts[1]+" Y: "+parts[2]+" Z: "+parts[3]);
				GyroscopeData gyr = new GyroscopeData();
				gyr.add("X: "+parts[4]+" Y: "+parts[5]+" Z: "+parts[6]);
				MagneticData mg = new MagneticData();
				mg.add("X: "+parts[7]+" Y: "+parts[8]+" Z: "+parts[9]);
				TemperatureData tm = new TemperatureData();
				tm.add("NULL");
				DataPackage pk = new DataPackage(mg,acc,gyr,tm);
				dataSet.add(pk);
			}
		}
		
		int currentTime = parent.millis()/1000;
		
		if(currentTime % 20 == 0) {
			parent.delay(2000);
			Save();
			resetDataSet();
			
		}
	}
	
	public void Save() {
		String data = dataSet.getJsonPretty();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = new Date();
		try {
			PrintWriter writer = new PrintWriter((new Integer(parent.minute()).toString())+(new Integer(parent.millis()).toString())+".json","UTF-8");
			writer.write(data);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parent.println("--> Data Saved");
	}

}
