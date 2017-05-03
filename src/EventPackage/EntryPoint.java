package EventPackage;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Start of Program");
		//TweetManager.TestTwitter();
		
		String AccessToken = args[0];		
		EventManager.getUserEvents(AccessToken, args[1], args[2]);
		System.out.println(EventManager.userlistevents.size());
		
		/* For Testing
		for(EventClass e : EventManager.userlistevents)
		{
			System.out.println(e.getToken());
			System.out.println(e.getId());
			
			System.out.println(e.getName());
			System.out.println(e.getDescription());
			System.out.println(e.getStarttime());
			System.out.println(e.getEndtime());
			
			System.out.println(e.getPlace().getName());
			System.out.println(e.getPlace().getStreet());
			System.out.println(e.getPlace().getCity());
			System.out.println(e.getPlace().getState());
			System.out.println(e.getPlace().getCountry());
			System.out.println(e.getPlace().getZip());
			System.out.println(e.getPlace().getLatitude());
			System.out.println(e.getPlace().getLongitude());
			
			System.out.println(" ");
		
		}
		*/
	}

}
