import java.util.Date;

public class Event implements Comparable<Event>{


public String eventTitle;
public String time;
public String location;
Date date;

LinkedList <Contact> Contactnames;


public Event() {
	this.eventTitle ="";
	this.time = "";
	this.location = "";
	this.date = null;
	
}

public Event( String eventTitle, String time, String location, Date date, LinkedList<Contact> c) {
	
	
	this.eventTitle = eventTitle;
	this.time = time;
	this.location = location;
	this.date = date;
	this.Contactnames = c;
}






public int compareTo(Event o) {
	
	return this.eventTitle.compareTo(o.eventTitle);
}
	

	

}
