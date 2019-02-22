package DataSender;
import processing.core.*;
import processing.serial.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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
			int val = 0;
			if(inByte!=null) {
				
				parent.println(inByte);
				inByte = inByte.replace("\n","");
				String[] parts = inByte.split(";");
				if(parts.length != 9)
					return;
				try {
					for(int i = 0;i<parts.length;i++) {
						Integer.parseInt(parts[i]);
					}
				}
				catch(Exception e){
					return;
				}
				parent.println(parts.length);
				AccelerationData acc = new AccelerationData();
				acc.add(new XYZValue(parts[0],parts[1],parts[2]));
				GyroscopeData gyr = new GyroscopeData();
				gyr.add(new XYZValue(parts[3],parts[4],parts[5]));
				MagneticData mg = new MagneticData();
				mg.add(new XYZValue(parts[6],parts[7],parts[8]));
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
		String[] data = dataSet.getCSV();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String dtSaved = dateFormat.format(date);
		PrintWriter writer = parent.createWriter(dtSaved+".csv");
		for(int i = 0; i< data.length;i++) {
			System.out.println(data[i]);
			writer.println(data[i]);
		}
		writer.flush();
		writer.close();
		parent.println("--> Data Saved");
	}

}
