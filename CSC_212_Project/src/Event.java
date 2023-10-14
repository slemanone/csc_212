import java.util.Date;
public class Event implements Comparable<Event>{


private String eventTitle;
private String time;
private String location;
Date date;

LinkedList <Contact> Contactsnames;



// dafault constructer 
public Event( String eventTitle, String time, String location, Date date, LinkedList<Contact> c) {
	
	
	this.eventTitle = eventTitle;
	this.time = time;
	this.location = location;
	this.date = date;
	this.Contactsnames = c;
}



public String getEventTitle() {
	
	return eventTitle;
}


public void setEventTitle(String eventTitle) {
	
	this.eventTitle = eventTitle;
}

public String getTime() {
	
	return time;
}

public void setTime(String time) {
	
	this.time = time;
}

public String getLocation() {
	
	return location;
}

public void setLocation(String location) {
	
	this.location = location;
}

public Date getDate() {

	return date;
}

public void setDate(Date date) {
	this.date = date;
 }










public int compareTo(Event o) {
	
	return 0;
}




}
