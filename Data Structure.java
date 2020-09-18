//====================================================
//Data Structure
//====================================================

import java.util.*

public class Stock{
	// Protected access allows subclass to modify the method / fields, but prevents non-subclass from accessing it
	// protected String ticker = symbol;
	// protected Integer price = curPrice;

	// Private access restricts the method / fields from being access from outside of a class. A getter method is needed to access private method / fields
	private String ticker;
	private Integer price;

	public Stock(String symbol, Integer curPrice){
		this.ticker = symbol;
		this.price = curPrice;
	}

	String getTicker(){
		return this.ticker;
	}

	Integer getPrice(){
		return this.price;
	}
}

//====================================================
// Hash Map
// Similar to Dictionary in Python, however, <Key, Value> pair must be specified during declaration.
// Note: HashMap is Asynchronous, whereas HashTable is Synchronous
// O(1) Access time (High Probability)
// put(Key, Value)
// get(Key)
// remove(Key)
// clear()
// size()
// containsKey(Key)
//====================================================

public HashMap<String, Integer> stockMap(Stock [] stocks){
	HashMap<String, Integer> map = new HasMap<String, Integer>();
	for(Stock s: stocks) map.put(s.getTicker(), s.getPrice());
	return map;
}

public void Class{

	public static void main(String [] args){
		// Pretend we have an array of Stock Objects called stocks
		HashMap<String, Integer> market = stockMap(stocks);

		// Use keySet() to iterate through all the Key in the HashMap
		for (String tick: market.keySet()) System.out.println(tick);
	}
}

//====================================================
// ArrayList
// Dynamically Resizing Array. Once the capacity has been reached, the array will double in size.
// Typical implementation is using a vector
// O(1) Access time; O(n) doubling time, but amortized to O(1) since it happens rarely
// add(item)
// get(index)
// set(index, item)
// remove(index)
//====================================================

public ArrayList<String> merge(String [] a, String [] b){
	ArrayList<String> array = new ArrayList<String>();
	for(String s: a) array.add(s);
	for(String s: b) array.add(s);
	return array;
}

//====================================================
// StringBuffer
// Similar to a String, but the StringBuffer is mutable.
// StringBuffer is thread safe which means it can be accessed by multiple thread
// append(String)
// capacity()
// charAt(index)
// delete(start index, end index)
// insert(offset, String)
//====================================================

public String newSentence(String [] sentences){
	StringBuffer buffer = new StringBuffer();
	for(String s: sentences) buffer.append(s);
	return buffer;
}


//====================================================
// Linked List
// 2 Types of LL: single linked vs doubly linked list
// Single Linked List means each item only points to the next item in the list. So they cannot access the previous one
// Doubly Linked List means each item points to the next and the previous item
//====================================================

class Node{
	Node next = null;
	int data;
	public Node(int d){
		data = d;
	}

	void appendToTail(int d){
		Node n = new Node(d);
		Node current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = n;
	}
}


// Deleting from a Single Linked List. Assuming target exist in LL
public Node deleteNode(Node head, int target){
	Node current = head;
	if(current.data == target){
		return current.next;
	}
	while(current.next != null){
		if(current.next.data == target){
			current.next = current.next.next;
			return current;
		}
		current = current.next;
	}
}

//>>>>>>>>>>>>>QUESTION<<<<<<<<<<<<<
// Write code to remove duplicates from an unsorted linked list
// FOLLOW UP
// How would you solve this problem if a temporary buffer is not allowed?
public static void removeDup(Node n){
	HashMap<int, boolean> LLMap = new HashMap<int, boolean>();
	Node current = n;
	Node prev = null;
	while(current.next != null){
		if(LLMap.containsKey(current.data)){
			prev.next = current.next;
		}
		else{
			LLMap.put(current.data, true);
			prev = current;
		}
		current = current.next;
	}
}

// Idea here is to compare each item to the rest of the array, from the current item to the back.
public static void removeDupNoBuffer(Node n){
	if(n == null) return;
	Node current = n;
	while(current.next != null){
		Node prev = current;
		Node tail = current.next;
		while(tail.next != null){
			if(current.data == tail.data){
				tail = tail.next;
				prev.next = tail;
			}
			else{
				prev = prev.next;
				tail = tail.next;
			}
		}
		current = current.next;
	}
}

//>>>>>>>>>>>>>QUESTION<<<<<<<<<<<<<
// Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node



