
public class Phonebook {

	LinkedListOfContact contacts;
	LinkedListOfEvent events;
	Scanner scanner = new Scanner(System.in);
	int first = 0;

	public Phonebook() {
		contacts = new LinkedListOfContact();
		events = new LinkedListOfEvent();
	}

	public int addContacts() {
		String o1;
		int i =0;
		String number = null;
		String eAddress= null;
		String birthday= null;
		try {
			
			System.out.print("Enter the contact's name: ");

			if (this.contacts.getLength() == 0)
				o1 = this.scanner.nextLine();
			String name = this.scanner.nextLine();
			while(i==0) {
			System.out.print("Enter the contact's Phone Number: ");
			number = this.scanner.nextLine();
			if(this.contacts.correctPhoneNumber(number))
				i++;
			else
				System.out.println("Please Enter a Correct value(only Saudi number , 10 digit) for the contact's Phone Number: ");
			}
			i--;
			while(i==0) {
			System.out.print("Enter the contact's Email Address: ");
			eAddress = this.scanner.nextLine();
			if(this.contacts.correctEmail(eAddress))
				i++;
				else
				System.out.println("Please Enter a Correct value for the contact's email: ");
			}
			i--;
			System.out.print("Enter the contact's Address: ");
			String address = this.scanner.nextLine();
			while(i==0) {
			System.out.print("Enter the contact's Birthday(MM/DD/yyyy): ");
			birthday = this.scanner.nextLine();
			if(this.contacts.correctBirthday(birthday))
				i++;
			else
				System.out.println("Please Enter a Correct value for the contact's Birthday: ");
			}
			i--;
			System.out.print("Enter any notes for the contact: ");
			String note = this.scanner.nextLine();
			Contact c = new Contact(name, number, eAddress, address, birthday, note);
			if (this.contacts.add(c)) {
				System.out.println("");
				System.out.println("the Contact has been added successfully");
			}
			else
				System.out.println("sorry the Contact is already  exists");
			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!");
			System.out.println("");
			String o6 = this.scanner.nextLine();
			return -1;
		}
		return -1;

	}

	public int searchContact() {
		if (this.contacts.getLength() == 0) {
			System.out.println("Sorry you do not have any Contact!!");
			System.out.println("you should add a Contact first");
			return -1;
		}

		int i = 0;
		int choose = 0;
		try {
			System.out.println("");
			System.out.println("Enter search criteria:");
			System.out.println("1.Name ");
			System.out.println("2.Phone Number ");
			System.out.println("3.Email Address");
			System.out.println("4.Address");
			System.out.println("5.Birthday");

			while (i == 0) {
				System.out.println("");
				System.out.print("Enter your choice: ");

				choose = this.scanner.nextInt();
				System.out.println("");
				System.out.println("");
				if (choose > 0 && choose < 6) {
					i++;
				} else {
					System.out.println("Plaese Enter a Correct Input!!");
					System.out.println("");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!");
			String o7 = this.scanner.nextLine();
			System.out.println("");
			return -1;
		}
		switch (choose) {
		case 1:
			try {
				System.out.print("Enter the contact's name: ");
				String o1 = this.scanner.nextLine();

				String name = this.scanner.nextLine();
				Contact c = this.contacts.searchName(name);
				if(c == null) {
					System.out.println("sorry this contact dose not exists");
					return -1;
				}
				this.contacts.printContact(c);
					

			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!2");
				System.out.println("");
				return -1;
			}
			break;
		case 2:
			System.out.print("Enter the contact's Phone Number:");
			String o2 = this.scanner.nextLine();
			try {
				String phone = this.scanner.nextLine();
				Contact c = this.contacts.searchPhone(phone);
				if(c == null) {
					System.out.println("sorry this contact dose not exists");
					return -1;
				}
				this.contacts.printContact(c);

			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!2");
				System.out.println("");
				return -1;
			}
			break;
		case 3:
			System.out.print("Enter the contact's Email Address:");
			String o3 = this.scanner.nextLine();
			try {
				String email = this.scanner.nextLine();
				LinkedListOfContact c = this.contacts.searchEmail(email);
				if(c == null) {
					System.out.println("sorry this contact dose not exists");
					return -1;
				}
				this.contacts.printContact(c);

			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!2");
				System.out.println("");
				return -1;
			}
			break;
		case 4:
			System.out.print("Enter the contact's Address:");
			String o4 = this.scanner.nextLine();
			try {
				String address = this.scanner.nextLine();
				LinkedListOfContact c = this.contacts.searchAddress(address);
				if(c == null) {
					System.out.println("sorry this contact is not exists");
					return -1;
				}
				this.contacts.printContact(c);

			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!2");
				System.out.println("");
				return -1;
			}
			break;
		case 5:
			System.out.print("Enter the contact's Birthday:");
			String o5 = this.scanner.nextLine();
			try {
				String birthday = this.scanner.nextLine();
				LinkedListOfContact c = this.contacts.searchBirthday(birthday);
				if(c == null) {
					System.out.println("sorry this contact is not exists");
					return -1;
				}
				this.contacts.printContact(c);

			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!2");
				System.out.println("");
				return -1;
			}
			break;

		}
		return -1;

	}

	public int deleteContact() {
		if (this.contacts.getLength() == 0) {
			System.out.println("Sorry you do not have any Contact to delete!!");

			return -1;
		}
		int i = 0;
		int choose = 0;
		try {
			System.out.println("");
			System.out.println("Enter delete criteria:");
			System.out.println("1.Name ");
			System.out.println("2.Phone Number ");

			while (i == 0) {
				System.out.println("");
				System.out.print("Enter your choice: ");

				choose = this.scanner.nextInt();
				String o = this.scanner.nextLine();
				System.out.println("");
				System.out.println("");
				if (choose > 0 && choose < 3) {
					i++;
				} else {
					System.out.println("Plaese Enter a Correct Input!!");
					System.out.println("");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!2");
			String o1 = this.scanner.nextLine();
			System.out.println("");
			return -1;
		}
		if (choose == 1) {
			System.out.print("Enter the contact's name: ");
			String name = this.scanner.nextLine();
			this.events.deleteByContactName(name);
			if (this.contacts.deleteContact(name))
				System.out.println("the Contact has been delete successfully");
			else
				System.out.println("sorry this contact is not exists");
			return -1;
		} else {
			System.out.print("Enter the Phone Number: ");
			String phone = this.scanner.nextLine();
			Contact c = this.contacts.searchPhone(phone);
			if (c == null) {
				System.out.println("sorry this contact is not exists");
				return -1;
				}
			this.events.deleteByContactName(c.getName());
			this.contacts.deleteContact(c.getName());
				System.out.println("the Contact has been deleted successfully");
			
			return -1;
		}
	}

	public int addEvent() {
		Event e1 = null;
		String o1;
		int i =0;
		String date1 = null;
		try {
			System.out.println("");
			System.out.print("Enter event title: ");
			String title = this.scanner.nextLine();
			System.out.print("Enter contact name: ");
			String name = this.scanner.nextLine();
			while(i==0) {
			System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
			date1 = this.scanner.nextLine();
			if(this.events.correctDate_Time(date1)) {
				i++;}
			else
				System.out.println("Please Enter a Correct value for the Event's date and time: ");
			}
			System.out.print("Enter event location: ");
			String location = this.scanner.nextLine();
			System.out.print("");
			e1 = new Event(title, name, date1, location);
		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!");
			System.out.println("");
			return -1;
		}
		if (contacts.searchName(e1.getContactName()) != null) {
			if (this.events.addEvent(e1)) {
				System.out.println("");
				System.out.print("Event scheduled successfully! ");
				System.out.println("");
			} else {
				System.out.print("Sorry you have an Event in the same time!! ");
			}
		} else {
			System.out.print("Please add the Contact first!!");
		}
		return -1;

	}

	public int PrintEvent() {
		if (this.events.getLength() == 0) {
			System.out.println("Sorry you do not have any Event!!");
			System.out.println("you should add an Event first");
			return -1;
		}
		int i = 0;
		int choose = 0;
		try {
			System.out.println("");
			System.out.println("Enter search criteria:");
			System.out.println("1.contact Name ");
			System.out.println("2.Event title ");

			while (i == 0) {
				System.out.println("");
				System.out.print("Enter your choice: ");

				choose = this.scanner.nextInt();
				String o1 = this.scanner.nextLine();
				System.out.println("");
				System.out.println("");
				if (choose > 0 && choose < 3) {
					i++;
				} else {
					System.out.println("Plaese Enter a Correct Input!!");
					System.out.println("");
				}
			}

			if (choose == 1) {
				System.out.print(" Enter contact Name: ");
				String name = this.scanner.nextLine();
				LinkedListOfEvent e = events.searchEventName(name);
				if(e.getLength() == 0) {
					System.out.println("sorry this contact does not have an Event");
				}
				this.events.Print(e);
			} else {
				System.out.print(" Enter Event title: ");
				String title = this.scanner.nextLine();
				LinkedListOfEvent e = events.searchEventTitile(title);
				if(e.getLength() ==0) {
					System.out.println("sorry there is no Event title with this name  ");
				}
				this.events.Print(this.events.searchEventTitile(title));
			}

		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!");
			String o1 = this.scanner.nextLine();
			System.out.println("");
			return -1;
		}
		return -1;

	}

	public int PrintContactByFirstName() {
		if (this.contacts.getLength() == 0) {
			System.out.println("Sorry you do not have any Contact!!");
			System.out.println("you should add an Contact first");
			return -1;
		}

		try {
			System.out.println("");
			System.out.print(" Enter contact Name: ");
			String name = this.scanner.nextLine();

			this.contacts.printContact(this.contacts.equalsFirstName(name));

		} catch (InputMismatchException e) {
			System.out.println("Plaese Enter a Correct Input!!");
			System.out.println("");
			return -1;
		}
		return -1;

	}

	public int printEventAlphabetically() {
		if (this.events.getLength() == 0) {
			System.out.println("Sorry you do not have any Event!!");
			System.out.println("you should add an Event first");
			return -1;
		}
		this.events.PrintAll();
		return -1;
	}

	public int Exit() {
		return 1;
	}

	public int start() {
		int i = 0;
		int choose = 0;
		while (i == 0) {
			try {
				if (first < 1) {
					System.out.println("");
					System.out.println("*************************************");
					System.out.println("");
					System.out.println("Welcome to the LinkedList Phonebook! ");
					System.out.println("");
					System.out.println("Please choose an option:");
					System.out.println("1.Add a contact");
					System.out.println("2.Search for a contact");
					System.out.println("3.Delete a contact");
					System.out.println("4.Schedule an event");
					System.out.println("5.Print event details");
					System.out.println("6.Print contacts by first name");
					System.out.println("7.Print all events alphabetically");
					System.out.println("8.Exit");
					System.out.println("");
					System.out.println("*************************************");
					System.out.println("");

					System.out.print("Enter your choice: ");
					first++;

					choose = this.scanner.nextInt();

					System.out.println("");
				
					if (choose > 0 && choose < 9) {
						i++;
					} else {
						System.out.println("Plaese Enter a Correct Input!!");
						System.out.println("");
					}

				} else {
					System.out.println("");
					System.out.println("*************************************");
					System.out.println("");
					System.out.println("Please choose an option:");
					System.out.println("1.Add a contact");
					System.out.println("2.Search for a contact");
					System.out.println("3.Delete a contact");
					System.out.println("4.Schedule an event");
					System.out.println("5.Print event details");
					System.out.println("6.Print contacts by first name");
					System.out.println("7.Print all events alphabetically");
					System.out.println("8.Exit");
					System.out.println("");
					System.out.println("*************************************");
					System.out.println("");

					System.out.print("Enter your choice: ");
					

					choose = this.scanner.nextInt();
					String o = this.scanner.nextLine();
					System.out.println("");
					if (choose > 0 && choose < 9) {
						i++;
					} else {
						System.out.println("Plaese Enter a Correct Input!!");
						System.out.println("");

					}

				}
			} catch (InputMismatchException e) {
				System.out.println("Plaese Enter a Correct Input!!");
				System.out.println("");
				scanner.nextLine();
				continue;
			}
		}
		switch (choose) {
		case 1:
			return addContacts();
		case 2:
			return searchContact();
		case 3:
			return deleteContact();
		case 4:
			return addEvent();
		case 5:
			return PrintEvent();
		case 6:
			return PrintContactByFirstName();
		case 7:
			return printEventAlphabetically();
		case 8:
			return Exit();

		}
		return 1;

	}
}
