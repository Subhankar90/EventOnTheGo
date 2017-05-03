package EventPackage;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterManager {
	static Twitter twitter = new TwitterFactory().getInstance();
	
	public static void addTweets() throws TwitterException {
		
		twitter.setOAuthConsumer("fS21rhhxj3jZJjzmjmlHDcuUL", "RLG322Syrln7CXn7fzgAGWFRXuH6ZXCPy8P0lPa4vEH7KmOObt");
		twitter.setOAuthAccessToken(new AccessToken("891795914-BzzsWNzDqPSmIok3QdnDyDfoPYWj6Wq7pnuq4NYN", "4fTMYxj8gGs8Br7ae7RsU71PO3XgIciwk7f9zYLsboeE4"));
		QueryResult result;
		Query query = null;
		for(EventClass event : EventManager.userlistevents) {
			query = new Query(HashTagGenerator(event.getName()));
			query.setCount(50);	       
	        result = twitter.search(query);
	        //System.out.println(result.getCount());
	        List<Status> tweets = result.getTweets();
	        List<String> tweetlist = new ArrayList<String>(); 
	        for (Status tweet : tweets)
	        		tweetlist.add("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	        event.setTweets(tweetlist);
		}	
	}
	
	public static String HashTagGenerator(String EventName ) {
		String HashTag = null;
		if(EventName.contains("#")) {
			HashTag = EventName.substring(EventName.indexOf("#"));
			if(HashTag.contains(" "))
				HashTag = HashTag.substring(0,HashTag.indexOf(" "));
		}
		else
			if(EventName.length() - EventName.replace(" ", "").length() > 1)
				if(EventName.indexOf(" ", EventName.indexOf(" ") + 1) != EventName.indexOf(" ") + 2)
					HashTag = "#" + EventName.substring(0, EventName.indexOf(" ", EventName.indexOf(" ") + 1)).replace(" ", "");	 
				else
					HashTag = "#" + EventName.substring(0, EventName.indexOf(" "));
			else
				HashTag = "#" + EventName.replace(" ", "");
		HashTag = HashTag.replace(":", "").replace("-", "").replace(".", "");
		return HashTag;
			
		}
	}
