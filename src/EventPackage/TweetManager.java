package EventPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TweetManager {
	
	public static void TestTwitter() throws TwitterException {
		ConfigurationBuilder configBuild = new ConfigurationBuilder();
		configBuild.setDebugEnabled(true)
			.setOAuthConsumerKey("fS21rhhxj3jZJjzmjmlHDcuUL")
			.setOAuthConsumerSecret("RLG322Syrln7CXn7fzgAGWFRXuH6ZXCPy8P0lPa4vEH7KmOObt")
			.setOAuthAccessToken("891795914-BzzsWNzDqPSmIok3QdnDyDfoPYWj6Wq7pnuq4NYN")
			.setOAuthAccessTokenSecret("4fTMYxj8gGs8Br7ae7RsU71PO3XgIciwk7f9zYLsboeE4");
		
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("fS21rhhxj3jZJjzmjmlHDcuUL", "RLG322Syrln7CXn7fzgAGWFRXuH6ZXCPy8P0lPa4vEH7KmOObt");
		twitter.setOAuthAccessToken(new AccessToken("891795914-BzzsWNzDqPSmIok3QdnDyDfoPYWj6Wq7pnuq4NYN", "4fTMYxj8gGs8Br7ae7RsU71PO3XgIciwk7f9zYLsboeE4"));
		
		/*
		TwitterFactory twitterfactory = new TwitterFactory(configBuild.build());
		twitter4j.Twitter twitter = twitterfactory.getInstance();
		List<Status> status = twitter.getHomeTimeline();
		for(Status st : status) {
			System.out.println(st.getUser().getName()+"........"+ st.getText());
		}
		*/
		
		/*
		try {
			Query query = new Query("#IPL");
	        QueryResult result;
	        result = twitter.search(query);
	        List<Status> tweets = result.getTweets();
	        for (Status tweet : tweets) {
	            System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	        }
		}
		catch(Exception e) {
			
		}
		*/
		
		try {
			Query query = new Query("PAB Presents: ");
	        QueryResult result  = twitter.search(query);
	        List<Status> tweets = result.getTweets();
	        System.out.println(tweets.size());
	        
	        
	        for (Status tweet : tweets) {
	            System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	        }
	        
		}
		catch(Exception e) {
			
		}
		
		
		
	}
	
	
	
	

}
