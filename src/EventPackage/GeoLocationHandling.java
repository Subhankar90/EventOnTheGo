package EventPackage;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GeoLocationHandling {
	
	public static String getPlace(String Latitude,String Longitude) throws IOException {
		
		String address = null;
		String googleURL = "http://maps.google.com/maps/api/geocode/xml?latlng=" + Latitude + "," + Longitude + "&sensor=true"; 
		try {
			DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documnetbuilder = documentfactory.newDocumentBuilder();
			Document dom = documnetbuilder.parse(googleURL);
			Element documentElement = dom.getDocumentElement();
			NodeList nodelist = documentElement.getElementsByTagName("result");
			if (nodelist.getLength() > 0 && nodelist != null){
				address=((Element)nodelist.item(0)).getElementsByTagName("formatted_address").item(0).getTextContent();
			}
		} 
		catch (Exception ex) {
			address = "None";
		}
		
		address = address.substring(address.indexOf(",") + 2);
		address = address.substring(0, address.indexOf(","));		
		return address;
	}

}
