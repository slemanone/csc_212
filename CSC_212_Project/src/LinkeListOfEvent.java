import java.text.SimpleDateFormat;
import java.util.Date;

public class LinkedListOfEvent {
	private Node<Event> head;
	private Node<Event> current;
	private int length;

	// parameterized constructor
	public LinkedListOfEvent() {
		this.head = null;
		this.current = null;
		this.length = 0;
	}

	public LinkedListOfEvent searchEventTitile(String title) {
		// this (if) check if the Linkedlist is empty
		if (length == 0) {
			return null;
		}
		current = head;
		LinkedListOfEvent temp = new LinkedListOfEvent();
		// (for) it check all the linkedlist nods for the entered title
		for (int i = 0; i < length; i++) {
			if (current.getData().getEventTitle().equalsIgnoreCase(title))
				temp.addEvent(current.getData());

			current = current.getNext();
		}

		return temp;

	}

	public LinkedListOfEvent searchEventName(String name) {
		// this (if) check if the Linkedlist is empty
		if (length == 0) {
			return null;
		}
		current = head;
		LinkedListOfEvent temp = new LinkedListOfEvent();
		// this (for) it check all the linkedlist nods for the entered Contact name
		for (int i = 0; i < length; i++) {
			if (current.getData().getContactName().equalsIgnoreCase(name))
				temp.addEvent(current.getData());

			current = current.getNext();
		}

		return temp;

	}

	public boolean addEvent(Event e) {
		current = head;
		Node<Event> n = new Node<Event>(e);
		// this (if) will put the Event in the head node if the linkedlist is empty
		if (length == 0) {
			head = n;
			length++;
			return true;
		}

		// this loop will check if the time is duplicate 
		for (int i = 0; i < length; i++) {
			String currentD = this.current.getData().getDate_time();
			String eD = e.getDate_time();
			String currentDate = currentD.split(" ")[0];
			String eDate = eD.split(" ")[0];
			
			if (currentDate.equalsIgnoreCase(eDate)) {
				int currentH = Integer.parseInt(currentD.split(" ")[1].split(":")[0]);
				int eH = Integer.parseInt(eD.split(" ")[1].split(":")[0]);
				int currentM = Integer.parseInt(currentD.split(" ")[1].split(":")[1]);
				int eM = Integer.parseInt(eD.split(" ")[1].split(":")[1]);
				
				if ((currentH == eH || (currentH + 1) == eH || (currentH-1) == eH)
						&& !current.getData().getEventTitle().equalsIgnoreCase(e.getEventTitle())) {
					int m = 0;
					if ((currentH + 1) == eH) {
						while (m != 30) {
							currentM++;
							m++;
							if (currentM >= 60)
								currentM = 0;
							if (currentM == eM)
								return false;
						}
					} else if ( (currentH-1) == eH ) {
						while (m == 30) {
							eM++;
							m++;
							if (currentM >= 60) {
								currentM = 0;
								}
							 if (currentM == eM)
								return false;
						}
					} else if (currentH == eH) {
						if (currentM < eM) {
							while (m >= 30) {
								currentM++;
								m++;
								if (currentM == eM) {
									return false;
									}
							}
						} else if (eM < currentM) {
							while (m >= 30) {
								eM++;
								m++;
								if (currentM == eM) {
									return false;}
							}
						}else
								return false;
					}
				}
			}
			current = current.getNext();
		}

		Node<Event> temp = null;
		current = head;
		// this (if) will check if the new Event should be added before the head
		if (current.getData().compareTo(e) == 1) {
			n.setNext(head);
			head = n;
			length++;
			return true;
		}
		// this loop will check where to place the new Event using our comparaTo()
		// method
		for (int i = 0; i < length; i++) {
			if (current.getData().compareTo(e) == 1) {
				n.setNext(current);
				temp.setNext(n);
				length++;
				return true;
			}
			if (current.getData().compareTo(e) == -1) {
				temp = current;
				current = current.getNext();

				if (current == null) {
					temp.setNext(n);
					length++;
					return true;
				}
			}

		}
		return false;
	}

	public void deleteByContactName(String name) {int x = searchEventName(name).length;
            if (x == 0) {
                return;
            }
            int l = length;
            current = head;
            Node<Event> temp = null;
            for (int i = 0 ; i < length && i < l;i++){
                if(current==null)
                    return;
                if (current.getData().getContactName().equalsIgnoreCase(name) && current.equals(head)) {
                    head = head.getNext();
                    current.setNext(null);
                    length--;
                    
                }
                else if (current.getData().getContactName().equalsIgnoreCase(name)) {
                    temp.setNext(current.getNext());
                    current.setNext(null);
                    length--;
                }
                temp = current;
                current = current.getNext();
            }
	}

	public boolean correctDate_Time(String dateT) {
    // this method will insure the date and time in the correct format 
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:ss");
		f.setLenient(false);
	
		try {
			Date dateTime = f.parse(dateT);

			int month = Integer.parseInt(dateT.split(" ")[0].split("/")[0]);
			int day = Integer.parseInt(dateT.split(" ")[0].split("/")[1]);
			int year = Integer.parseInt(dateT.split(" ")[0].split("/")[2]);
			
			int hour = Integer.parseInt(dateT.split(" ")[1].split(":")[0]);
			int minute = Integer.parseInt(dateT.split(" ")[1].split(":")[1]);

			if ((day >= 1 && day <= 31 )
			 && (month >= 1 && month <= 12 )
			 && (year >= 2023 && year <= 2029)
			 && (hour >= 1&& hour <= 24)
			 && (minute >= 1 && minute <= 60)){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}

	}

	public void Print(LinkedListOfEvent e) {
		// this for will print all Contact in the entered linkedlist
		e.current = e.head;
		for (int i = 0; i < e.length; i++) {
			e.current.getData().printEvent();
			e.current = e.current.getNext();
		}

	}

	public void PrintAll() {
		// this method will print all Event information
		this.current = this.head;
		for (int i = 0; i < this.length; i++) {
			this.current.getData().printEvent();
			System.out.println("");
			this.current = this.current.getNext();
		}

	}

	public int getLength() {
		return length;
	}

}

