package EventPackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Event;
import com.restfb.types.Likes;

public class EventManager {
	public static List<EventClass> userlistevents = new ArrayList<EventClass>();
	public static FacebookClient facebookclient;
	
	public static void getUserEvents(String token, String Latitude,String Longitude) throws Exception {
		facebookclient = new DefaultFacebookClient(token, Version.LATEST);		
		Connection<Event> eventlist = facebookclient.fetchConnection("me/events", Event.class);
		listConversion(eventlist,token);		
		
		eventlist = facebookclient.fetchConnection("search", Event.class, Parameter.with("q", GeoLocationHandling.getPlace(Latitude,Longitude)), Parameter.with("type", "event"));
		listConversion(eventlist, token);
		
		List<String> preferencelist = getUserPreferencelist(token);
		
		for(int i=0; i<preferencelist.size(); i++) {
			eventlist = facebookclient.fetchConnection(preferencelist.get(i)+"/events", Event.class);			
			listConversion(eventlist, token);	
		}	
			
	}
	
	public static List<String> getUserPreferencelist(String token) throws Exception {
		List<String> preferencelist = new ArrayList<String>();
		facebookclient = new DefaultFacebookClient(token, Version.LATEST);	
		Connection<Likes> list = facebookclient.fetchConnection("me/likes", Likes.class, Parameter.with("limit","50"));
	    Gson gson = new Gson();        
	    Likes preference = gson.fromJson(Utilities.readUrl(list.getNextPageUrl()), Likes.class);
	    for(int i = 0; i<preference.getData().size();i++)  {
	    	preferencelist.add(preference.getData().get(i).getId()); 	
	    	
	    }
	    return preferencelist;
	    
	}
	
	public static void listConversion(Connection<Event> eventlist, String token) {
		Date currentDate = new Date();
		for(int i = 0; i<eventlist.getData().size();i++) {
			if(eventlist.getData().get(i).getStartTime().after(currentDate)) {
				EventClass eventObj = new EventClass();
				eventObj.setToken(token);
				eventObj.setId(eventlist.getData().get(i).getId());
				eventObj.setName(eventlist.getData().get(i).getName());
				eventObj.setDescription(eventlist.getData().get(i).getDescription());
				eventObj.setStarttime(eventlist.getData().get(i).getStartTime());
				eventObj.setEndtime(eventlist.getData().get(i).getEndTime());
				
				
				if(eventlist.getData().get(i).getPlace() != null) {
					EventPlace placeObj = new EventPlace();
					placeObj.setName(eventlist.getData().get(i).getPlace().getName());
					if(eventlist.getData().get(i).getPlace().getLocation() != null) {
						placeObj.setStreet(eventlist.getData().get(i).getPlace().getLocation().getStreet());
						placeObj.setCity(eventlist.getData().get(i).getPlace().getLocation().getCity());
						placeObj.setState(eventlist.getData().get(i).getPlace().getLocation().getState());
						placeObj.setCountry(eventlist.getData().get(i).getPlace().getLocation().getCountry());
						placeObj.setZip(eventlist.getData().get(i).getPlace().getLocation().getZip());
						placeObj.setLatitude(eventlist.getData().get(i).getPlace().getLocation().getLatitude());
						placeObj.setLongitude(eventlist.getData().get(i).getPlace().getLocation().getLongitude());
					}
					else
						return;
					eventObj.setPlace(placeObj);
				}
				else
					return;
				userlistevents.add(eventObj);
			}
		}
		
	}

}
