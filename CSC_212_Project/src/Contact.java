import java.util.Date;

public class Contact implements Comparable<Contact>{
	
public String name;
	
public String notes;
	
public String address;
	
public int phone_number;
	
public String email_address;
	
Date birthday;
	
LinkedList <Event> event;

public Contact() {
	this.address="";
	this.name = "";
	this.notes ="" ;
	this.phone_number = 0;
	this.email_address = "";
	this.birthday = null;
	this.event = new LinkedList<Event>();
	
}
 
public Contact(String name, String notes, String address, int phone_number, String email_address, Date birthday,
		LinkedList<Event> events) {
	
	this.name = name;
	this.notes = notes;
	this.address = address;
	this.phone_number = phone_number;
	this.email_address = email_address;
	this.birthday = birthday;
	this.event =new LinkedList<Event>();
}

public boolean addEvent(Event events) {
	if(event.empty())
		event.insertSortred(events);
	else {
		event.findfirst();
	 for(int i = 0; i < event.length; i++ ) {
		 if((event.retrive().date.compareTo(events.date)==0) && (event.retrive().time.compareTo(events.time)==0)) {
			 return false;	 
		 } 
	 }	
	}
	 return true;
}

public boolean removeEvent(String EventTitle) {
	if (event.empty())
		return false;
	Event newEvent = new Event();
	newEvent.eventTitle = EventTitle;
	  if(event.Search(newEvent)) {
		event.remove(newEvent);	;
		return true;
	  }		
	return false;	
}


public int compareTo(Contact o) {
	
	return this.name.compareTo(o.name);
}


}
