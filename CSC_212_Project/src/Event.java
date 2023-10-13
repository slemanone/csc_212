
public class Event implements Comparable<Event>{
	private String contactName;
	private String eventTitle;
	private String date_time;
	private String location;


	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	

}
