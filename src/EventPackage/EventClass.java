package EventPackage;
import java.util.Date;
import java.util.List;

public class EventClass {
	
	private String token;
	private String Id;
	private String Name;
	private String Description;
	private EventPlace Place;
	private Date Starttime;
	private Date Endtime;
	private List<String> tweets;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public EventPlace getPlace() {
		return Place;
	}
	public void setPlace(EventPlace place) {
		Place = place;
	}
	public Date getStarttime() {
		return Starttime;
	}
	public void setStarttime(Date starttime) {
		Starttime = starttime;
	}
	public Date getEndtime() {
		return Endtime;
	}
	public void setEndtime(Date endtime) {
		Endtime = endtime;
	}	
	public List<String> getTweets() {
		return tweets;
	}
	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}
	
	
	

}
