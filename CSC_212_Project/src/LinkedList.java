
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
	 return current.data;	 }


public void findfirst() {
	head = current;	
}

public boolean empty() {
	 return head == null;	
}
	
public boolean last() {
	return current.next==null;
}


public void insertSortred(T val) {
	Node <T> tmp;
	if(empty()) { 
		current = head =new Node<T> (val);	
	}
	else {
		if(head.getData().compareTo(val)>0) {
			tmp= new Node(val);
		    tmp.setNext(head);
		    head=tmp;	
		}
		else {
			if(head.getData().compareTo(val)<0) {
				tmp= new Node(val);
				current = head.next;
				head.next =tmp;
				tmp.setNext(current);	
			}
			else {
				if(head.getData().compareTo(val)== 0) {
					tmp=new Node(val);
					current = head.next;
					head.next =tmp;
					tmp.setNext(current);
	}
	 }	
}
	}
	
}

public boolean Search(T val) {
	current=head;
	Node <T> tmp;
	if(empty())
		return false;
	while (current!=null && current.getData().compareTo(val)!=0)
		current=current.getNext();
	if(current.getData().compareTo(val)==0) {
		tmp = current;
		return true;
	}
return false;	
}	
	
	
	
	
	
	
	
	

}
