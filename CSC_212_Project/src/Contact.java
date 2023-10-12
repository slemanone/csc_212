import java.util.Date;



public class Contact implements Comparable<Contact>{
private String name;
private String notes;
private String address;
private int phone_number;
private String email_address;
Date birthday;
LinkedList <Event> events;
 



public Contact(String name, String notes, String address, int phone_number, String email_address, Date birthday) {
	
	this.name = name;
	this.notes = notes;
	this.address = address;
	this.phone_number = phone_number;
	this.email_address = email_address;
	this.birthday = birthday;
}





































































@Override
public int compareTo(Contact o) {
	
	return 0;
}


}
