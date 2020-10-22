/*
 * Class: CS 3345
 * Section: 003
 * Semester: Spring 2019
 * Project 2: Make a magazine list using interfaces and generic classes
 */

public class linkedlist<AnyType extends IDedObject>
{
	//nested node class
	private static class Node<AnyType>
	{
		//node variables
		public AnyType contents;
		public Node <AnyType> next;
		
		public Node(AnyType c, Node<AnyType> n) //node constructor
		{
			contents = c;
			next = n;
		}
	}
	
	//head and tail of linked list
	private Node<AnyType> head; 
	private Node<AnyType> tail;	
	
	public linkedlist() //linked list constructor
	{
		//set head and tail to null
		head = new Node<>(null, null);
        tail = new Node<>(null, null);
		head.next = tail; //link head to tail
	}
	
	public void makeEmpty() //empties the linked list
	{
		head.next = tail; //link head to tail
	}
	
	public AnyType findID(int ID) // Get the generic type to get the particular id and returns AnyType. Don’t remove the object from the list. returns null if the list is empty or ID not found.
	{
		Node<AnyType> temp = head.next; //set a temp node
		while(temp != tail) //loop until the end of the list
		{
			if(temp.contents.getID() == ID) //if the id matches
			{
				return temp.contents; //return the matching magazine
			}
			temp = temp.next;
		}
		
		return null;
	}
	
	public boolean insertAtFront(AnyType x) // insert at front of list or return false if that ID already exists
	{
		if(findID(x.getID()) != null) //check if the magazine already is in the list
		{
			return false;
		}
		else
		{
			Node<AnyType> temp = new Node<>(x, null); //create a new node with the data provided
			temp.next = head.next; //set the temp node to head.next
			head.next = temp; //set the head.next to temp
			return true;
		}
	}
	
	public AnyType deleteFromFront() // delete and return the record at the front of the list or return null if the list is empty
	{
		Node<AnyType> temp = head.next;
		if(temp != tail)
		{
			head.next = temp.next;
			return temp.contents;
		}
		else
		{
			return null;
		}
	}
	
	public AnyType delete(int ID) // find and delete the record with the given ID or return null if it isn’t found 
	{
		if(findID(ID) == null)
		{
			return null;
		}
		else
		{
			Node<AnyType> temp = head; //set temp node to head
			while(temp.next != tail) //loop while not the end of the list
			{
				if(temp.next.contents.getID() == ID) //if the ids match
				{
					Node<AnyType> delete = temp.next; //set delete node to the temp.next
					temp.next = delete.next; //set the temp.next to delete.next
					return delete.contents; //return the delete contents
				}
				temp = temp.next; //go to the next node
			}
		}
		return null;
	}
	
	public void printAllRecords() // print all elements in the order they appear in the linked list. if list is empty print appropriate message.
	{
		Node<AnyType> temp = head; //set temp to head
		if(temp.next == tail) //if the list is empty
		{
			System.out.println("Empty List.");
		}
		else
		{
			int counter = 1;
			temp = temp.next;
			while(temp != tail) //print the entire list
			{
				System.out.println("Magazine #" + counter + ":");
				temp.contents.printID();
				temp = temp.next;
				counter++;
			}
		}		
	}
}
