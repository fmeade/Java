import java.util.*;

import javax.xml.soap.Node;

/**
 * A class that creates own Linked List
 * AddressList.java
 * @author fmeade
 */
public class AddressList
{	
	private ListNode head;       // Head Node
	private ListNode currentNode;// Current Node
	
	/*
	 * This nested, private class represents a node of a singly linked list.
	 */
	private class ListNode
	{
		private String name;  // name
		private String tel;   // Telephone number
		private String email; // email
		private String addr;  // Address
		private String dob;   // Date of birth
		private ListNode next;// Pointer to the next node

		private ListNode(String name, String tel, String email, String addr,
				String dob) {

			this.name = name;
			this.tel = tel;
			this.email = email;
			this.addr = addr;
			this.dob = dob;

		} // end of the constructor

		/* getter and setter methods */
		public String getName() {return name;}
		public String getTel() {return tel;}
		public String getEmail() {return email;}
		public String getAddr() {return addr;}
		public String getDob() {return dob;}
		public void setName(String name) {this.name = name;}
		public void setTel(String tel) {this.tel = tel;}
		public void setEmail(String email) {this.email = email;}
		public void setAddr(String addr) {this.addr = addr;}
		public void setDob(String dob) {this.dob = dob;}
		public ListNode getNext() {return next;}
		public void setNext(ListNode link) {next = link;}

	} // end of class ListNode

	/* isEmpty */
	public boolean isEmpty()
	{
		return head == null;
	} // end of isEmpty
	
	/**
	 * Adds a ListNode to the front of the list
	 * @param name name
	 * @param tel  phone number
	 * @param email email
	 * @param address address
	 * @param dob   date of birth
	 */
	public void addToFront(String name, String tel, String email, String address, String dob)
	{
		ListNode currentNode = new ListNode(name,tel,email,address,dob);
		currentNode.setNext(head);
		head = currentNode;
	} // end of addToFront
	
	/**
	 * Adds a ListNode to the back of the list
	 * @param name name
	 * @param tel  phone number
	 * @param email email
	 * @param address address
	 * @param dob   date of birth
	 */
	public void addToBack(String name, String tel, String email, String address, String dob)
	{
		ListNode node = new ListNode(name,tel,email,address,dob);
		add(node,head);
	} // end of addToBack
	/*
	 * private helper class that looks for end of list and then adds node
	 */
	private void add(ListNode newNode,ListNode current)
	{
		if(current == null)
		{
			head = newNode;
			head.setNext(null);
		}
		else if(current.getNext() != null){

			add(newNode,current.getNext());
			
		}
		else
		{
			currentNode = current;
			currentNode.setNext(newNode);
		}
	} // end of add
	
	/**
	 * toString
	 * @return String; information from the ListNodes
	 */
	public String toString()
	{
		return toStringHelper(head, "");
	} // end of toString
	/*
	 * private helper method that gathers the toString for each node
	 */
	private String toStringHelper(ListNode node, String str)
	{
		if(node == null)
		{
			return str;
		}
		
		str = str + node.name + " " + node.tel + " " + node.email + " " + node.addr + " " + node.dob + "\n";
		
		if(node.next == null)
		{
			return str;
		}
		
		return toStringHelper(node.next,str);
	} // end of toStringHelper
	
	/**
	 * reverse of toString
	 * @return String; the reversed toString
	 */
	public String reverseToString()
	{
		return reverseToStringHelper(head,"");
	} // end of reverseToString
	/*
	 * private helper method that gathers the toString of each node backwards
	 */
	private String reverseToStringHelper(ListNode node,String str)
	{
		if(node == null)
		{
			return str;
		}
		
		str += reverseToStringHelper(node.next,str);
		
		str += node.name + " " + node.tel + " " + node.email + " " + node.addr + " " + node.dob + "\n";
		
		return str;
	} // end of reverseToStringHelper
	
	/**
	 * Reverses the current list
	 * @return String; a reverse copy of the current list
	 */
	public AddressList reverse()
	{
		return reverseHelper(head,new AddressList());
	} // end of reverse
	/*
	 * private helper method that adds each node to a new list
	 * via addToFront
	 */
	private AddressList reverseHelper(ListNode node,AddressList newList)
	{
		if(node == null)
		{
			return newList;
		}
		
		newList.addToFront(node.getName(),node.getTel(),node.getEmail(),node.getAddr(),node.getDob());
		
		newList = reverseHelper(node.getNext(),newList);
		
		return newList;
	} // end of reverseHelper

	/**
	 * Size of current list
	 * @return int; size of current list
	 */
	public int sizeOf()
	{
		return count(head,0);
	} // end of sizeOf
	/*
	 * private helper method that counts number of nodes that are not null
	 */
	private int count(ListNode node,int i)
	{
		if(node == null)
		{
			return i;
		}
		if(node.next == null)
		{
			i = i+1;
			return i;
		}
		
		i = i+1;
		return count(node.next,i);
	} // end of count

	/**
	 * Finds phone number by given name
	 * @param name name entered
	 * @return String; phone number desired
	 */
	public String phoneNumberByName(String name)
	{
		return phoneNumberByNameHelper(name,head);
	} // end of phoneNUmberByName
	/*
	 * private helper method that searches for phone number by name
	 */
	private String phoneNumberByNameHelper(String name,ListNode node)
	{
		if(node == null)
		{
			return "No matching data";
		}
		
		if(node.getName().equals(name))
		{
			return node.getTel();
		}
		else
		{
			return phoneNumberByNameHelper(name,node.getNext());	
		}
	} // end of phoneNumberByNameHelper

	/**
	 * Finds email by given name
	 * @param name name entered
	 * @return String; email desired 
	 */
	public String emailByName(String name)
	{
		return emailByNameHelper(name,head);	
	} // end of emailByName
	/*
	 * private helper method that searches for email by name
	 */
	private String emailByNameHelper(String name,ListNode node)
	{
		if(node == null)
		{
			return "No matching data";
		}
		
		if(node.getName().equals(name))
		{
			return node.getEmail();
		}
		else
		{
			return emailByNameHelper(name,node.getNext());	
		}
	} // end of emailByNameHelper

	/**
	 * Finds name by given phone number
	 * @param tel phone number entered
	 * @return String; name desired 
	 */
	public String nameByPhoneNumber(String tel)
	{
		return nameByPhoneNumberHelper(tel,head);
	} // end of nameByPhoneNumber
	/*
	 * private helper method that searches for name by phone number
	 */
	private String nameByPhoneNumberHelper(String tel, ListNode node)
	{
		if(node == null)
		{
			return "No matching data";
		}
		
		if(node.getTel().equals(tel))
		{
			return node.getName();
		}
		else
		{
			return nameByPhoneNumberHelper(tel,node.getNext());	
		}
	} // end of nameByPhoneNumberHelper

	/**
	 * Finds date of birth by given name
	 * @param name name entered
	 * @return String; date of birth desired 
	 */
	public String dobByName(String name)
	{
		return dobByNameHelper(name,head);
	} // end of dobByName
	/*
	 * private helper method that searches for dob by name
	 */
	private String dobByNameHelper(String name, ListNode node)
	{
		if(node == null)
		{
			return "No matching data";
		}
		
		if(node.getName().equals(name))
		{
			return node.getDob();
		}
		else
		{
			return dobByNameHelper(name,node.getNext());	
		}
	} // end of dobByNameHelper

} // end of class AddressList