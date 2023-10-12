
public class LinkedList<T> {
	
private Node<T> head;
private Node<T> current;
 
public LinkedList() {
	head = current = null;
}


public boolean full() {
	return false;	
}

public T retrive() {
	 return current.data;	 
}

public void findfirst() {
	head = current;	
}

public boolean empty() {
	 return head == null;	
}
	
public boolean last() {
	return current.next==null;
}


	
	
	
	
	
	
	
	
	
	
	

}
