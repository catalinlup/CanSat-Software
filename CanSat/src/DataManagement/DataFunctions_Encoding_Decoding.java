package DataManagement;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.*;

public class DataFunctions_Encoding_Decoding {
	
	//compressing function
	public static String compress(String str) throws IOException{
		
		if(str == null || str.length() == 0)
			return str;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		
		return out.toString("ISO-8859-1");
		
	}
}
