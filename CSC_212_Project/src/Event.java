
public class Event implements Comparable<Event> {
	private String eventTitle;
	private String contactName;
	private String date_time;
	private String location;
	// parameterized constructor
	public Event(String eventTitle, String contactName, String date_time, String location) {
		this.eventTitle = eventTitle;
		this.contactName = contactName;
		this.date_time = date_time;
		this.location = location;
	}
    // copy constructor
	public Event(Event e) {
		this.eventTitle = e.eventTitle;
		this.date_time = e.date_time;
		this.location = e.location;
		this.contactName = e.contactName;
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

	public void printEvent() {
		 // prints all Event information
		System.out.println("Event found! ");
		System.out.println("Event title: " + this.eventTitle);
		System.out.println("Contact name: " + this.contactName);
		System.out.println("Event date and time (MM/DD/YYYY HH:MM): " + this.date_time);
		System.out.println("Event location: " + this.location);
	}

	@Override
	public int compareTo(Event e) {
		// this (if) check if the title are equal
		//if (this.eventTitle.equalsIgnoreCase(e.eventTitle))
		//	return 0;
		
		if(this.eventTitle.equalsIgnoreCase(e.eventTitle) &&
				!this.contactName.equalsIgnoreCase(e.contactName))
			return 1;
		
		int max = 0;
		//this (if) takes the the smallest length of the titles
		if (this.eventTitle.length() < e.eventTitle.length()) {
			max = this.eventTitle.length();
		} else {
			max = e.eventTitle.length();
		}
		int i = 0;
		//this (while) will compare each char of title 
		while ( i < max) {
			String f = "" + this.eventTitle.charAt(i);
			String s = "" + e.eventTitle.charAt(i);
			if (f.compareToIgnoreCase(s) < 0)
				return -1;
			else if (f.compareToIgnoreCase(s) > 0)
				return 1;
			i++;
		}
		return 0;
	}

	

}
