package DataSender;
import processing.core.*;
import processing.serial.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import DataManagement.*;

public class KeyLogger {
	
	private PApplet parent;
	private Serial port;
	private DataSet dataSet;
	private final int SaveTimeInterval = 20;
	
	public KeyLogger(PApplet parent) {
		this.parent = parent;
		parent.println(Serial.list());
		Scanner reader = new Scanner(System.in);
		System.out.println("Type port: ");
		int i = reader.nextInt();
		System.out.println(Serial.list()[i]);
		port = new Serial(parent,Serial.list()[i],9600);
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
				parent.println(inByte);
				inByte = inByte.replace("\n","");
				String[] parts = inByte.split(";");
				if(parts.length < 10)
					return;
				//parent.println(parts.length);
				AccelerationData acc = new AccelerationData();
				acc.add(new XYZValue(parts[1],parts[2],parts[3]));
				GyroscopeData gyr = new GyroscopeData();
				gyr.add(new XYZValue(parts[4],parts[5],parts[6]));
				MagneticData mg = new MagneticData();
				mg.add(new XYZValue(parts[7],parts[8],parts[9]));
				TemperatureData tm = new TemperatureData();
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
		String data = dataSet.getCSV();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = new Date();
		try {
			StringBuilder build = new StringBuilder();
			Formatter fmt = new Formatter(build);
			fmt.format("%s.csv", dateFormat.toString());
			PrintWriter writer = new PrintWriter(build.toString(),"UTF-8");
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
