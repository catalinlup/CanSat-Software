package DataManagement;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPOutputStream;
import java.util.zip.*;

public class DataFunctions_Encoding_Decoding {
	
	//compressing function
	public static byte[] compress(String str) throws IOException{
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(str.length());
		GZIPOutputStream gzip = new GZIPOutputStream(bos);
		gzip.write(str.getBytes());
		gzip.close();
		byte[] compressed = bos.toByteArray();
		bos.close();
		return compressed;
		
	}
	
	//decompressing function
	public static String decompress(byte[] str) throws IOException{
		ByteArrayInputStream bis = new ByteArrayInputStream(str);
		GZIPInputStream gis = new GZIPInputStream(bis);
		BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		gis.close();
		bis.close();
		return sb.toString();
	}
}
