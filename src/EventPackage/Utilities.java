package EventPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Utilities {
	
	public static String readUrl(String urlString) throws Exception {
	    BufferedReader bufferReader = null;
	    try {
	        URL url = new URL(urlString);
	        bufferReader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer stringBuffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        
	        while ((read = bufferReader.read(chars)) != -1)
	        	stringBuffer.append(chars, 0, read); 

	        return stringBuffer.toString();
	    } 
	    finally {
	        if (bufferReader != null)
	        	bufferReader.close();
	    }
	}
	
	// Used Orthodrome for Distance Calculation
	// Reference: https://en.wikipedia.org/wiki/Great-circle_distance
	public static double distanceCalculator(double eventLatitude, double eventLongitude, double baseLatitude, double baseLongitude) {
		double theta = eventLongitude - baseLongitude;
		double distance = Math.sin(degeeToradian(eventLatitude)) 
				* Math.sin(degeeToradian(baseLatitude)) 
				+ Math.cos(degeeToradian(eventLatitude)) 
				* Math.cos(degeeToradian(baseLatitude)) 
				* Math.cos(degeeToradian(theta));
		return  Math.acos(distance) * 60 * 1.1515;
	}
	
	public static double degeeToradian(double degree) {
        return (degree * Math.PI / 180.0);
      }
	public static double radianTodegree(double radian) {
		return (radian * 180.0 / Math.PI);
      }
}
