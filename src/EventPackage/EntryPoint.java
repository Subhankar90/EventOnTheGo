package EventPackage;

public class EntryPoint {

	public static void main(String[] args) throws Exception {
		
		
		try {
		
		String AccessToken = args[0];		
		EventManager.getUserEvents(AccessToken, args[1], args[2]);		
		TwitterManager.addTweets();
		EventManager.HotnessCalculator();
		System.out.println(EventManager.userlistevents.size());
		//testResults();
		}
		catch (Exception ex) {
		}
	}
	
	@SuppressWarnings("unused")
	private static void testResults() {
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
			
			System.out.println("Tweet Size : " + e.getTweets().size());
			System.out.println(e.getHotness());
			
			System.out.println(" ");		
		}
	}

}
