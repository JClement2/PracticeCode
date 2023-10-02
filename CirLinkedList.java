/**
Circular linked list  - 20 bonus points for Exam #1

Todo: complete the following functionalities for the given class
1. main driver to test all functionalities 4pts
2. copy constructor 4pts
3. add method 4pts
4. toString method 4pts
5. iterator 4pts

@author Jonathan Clement
@version 1.1
@since 9/27/2023

New Functions added:

+ added copy Constructor
+ added toString method
+ added iterator
+ added a method to add new elements to list
+ added test cases in main driver

*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CirLinkedList<T> implements Iterable<T>{
 
	//======= Start of nested class =========
	/**
	 * The Node class to encapsulate the data and reference of a data structure 
	 * node - the class is rewritten as an nested class
    */
	protected class Node<T> {
		protected T data;
		protected Node<T> next, prev;
		
		public Node(T data) { //initialize the attributes
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}	//====== end of nested class ========

	/**
	 * Iterator class for the Circular Linked List
	 */
	protected class CirLinkedListIterator implements Iterator<T> {
		protected Node<T> current = cur;
		protected boolean first = true;

		/**
		 * hasNext method from Iterator get overrided
		 */
		@Override
		public boolean hasNext() {
			return cur != null && (first || current != cur);
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			current = current.next;
			first = false;
			return data;
		}

	}


	//attribute of the list class
	protected Node<T> cur; //point at the last accessed, i.e, current node
	public int size;
  
	//=========== solution following ==============
	
	public CirLinkedList(){ //default constructor
		this.cur = null;
		this.size = 0;
	}

	/**
	 * Copy constructor to copy a list over to a new list
	 * 
	 * @param original - list to be copied
	 */
	public CirLinkedList(CirLinkedList<T> original) {
		if(original.cur == null) {
			this.cur = null;
		}
		Node<T> originCurrent = original.cur;
		Node<T> copyCurrent = new Node<>(originCurrent.data);
		this.cur = copyCurrent;
		originCurrent = originCurrent.next;
		// Traverse the original list and copy contained elements
		while(originCurrent != original.cur) {
			copyCurrent.next = new Node<>(originCurrent.data);
			copyCurrent = copyCurrent.next;
			originCurrent = originCurrent.next;
		}
		copyCurrent.next = this.cur;
		this.size = original.size;
	}
	
	/////////////////////////////////////////
	/**
	 * A method that adds data into a circular linked list
	 * 
	 * @param data - what is to be added to the list
	 */
	public void add(T data){
		 Node<T> newNode = new Node<>(data);
		 if(cur == null) {
			this.cur = newNode;
			cur.next = this.cur; // point to itself for circularity
		 }
		 Node<T> current = this.cur;
		 while(current.next != this.cur) {
			current = current.next;
		 }
		 current.next = newNode;
		 newNode.next = this.cur;
		 this.size++;
		}

	
	/**
	 * Return elements as a string using toString
	 */
    public String toString(){
		StringBuilder sb = new StringBuilder();
		if(cur == null) {
			sb.append("Empty List");
		}
		Node<T> current = cur;
		do {
			sb.append(current.data).append(" ");
			current = current.next;
		} while(current != cur);
		return sb.toString();
	}

	/**
	 * Method used to iterate through the list
	 * 
	 * @return - iterate through the list and return elements
	 */
	@Override
	public Iterator<T> iterator() {
		return new CirLinkedListIterator();
	}
	
	//============================================
	//===           main driver                 ==
	public static void main(String[] args){
		CirLinkedList<Integer> cl = new CirLinkedList();
		cl.add(5);
		System.out.println(cl);
		cl.add(4);
		System.out.println(cl);
		cl.add(3);
		System.out.println(cl);
		cl.add(2);
		System.out.println(cl);
		
		System.out.println("List Contents: " + cl.toString());

		// Use the iterator to traverse and print the list
		System.out.print("Using Iterator: ");
		for(int item : cl) {
			System.out.print(item + " ");
		}
		System.out.println(" ");

		//test the rest of the functionalities here
	}

}