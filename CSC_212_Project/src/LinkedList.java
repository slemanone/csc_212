public class LinkedList<T extends Comparable<T>> {
	
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

public void findnext(){
	current = current.next;
}
	

public void insertSortred(T val) {
	Node <T> tmp;
	Node <T> prevoius = null ;
	if(empty()) { 
		current = head =new Node<T> (val);	
	}
	else {  // insertion at first
		if(head.getData().compareTo(val)>0) {
			tmp= new Node(val);
		    tmp.setNext(head);
		    head=tmp;	
		}
		else {   // insertion at middle
			current = head;
			while(current!=null && current.getData().compareTo(val)<=0) {
				prevoius = current;
				current = current.getNext();
			}
			tmp = new Node(val);
			prevoius.next= tmp;
			tmp.setNext(current);
			current = tmp;		
		}
		 // insertion at the end when current = null;
			prevoius.next= tmp;
	}
}
 




public boolean Search(T val) {
	if(empty())
		return false;
	current=head;
	Node <T> tmp;
	while (current!=null && current.getData().compareTo(val)!=0)
		current=current.getNext();
	if(current.getData().compareTo(val)==0) {
		tmp = current;
		return true;
	}
	current= head;
return false;	
}	
	

public void remove(T val) {
	findfirst();
	Node<T> previous = null ;
	if (head.getData().compareTo(val)==0) // delete first
		head = head.next;
	else {
		while(current.getData().compareTo(val)!=0) {
			previous = current;
			current = current.next;
		}
		  previous.setNext(current.next);
		  current.setNext(null);
	}
	 if (current.next== null)
		 current = head;
	 else 
		 current = current.next;
}









	
	
	
	
	
	
	

}
