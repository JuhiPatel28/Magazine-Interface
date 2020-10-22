/*
 * Class: CS 3345
 * Section: 003
 * Semester: Spring 2019
 * Project 2: Make a magazine list using interfaces and generic classes
 */

public class Magazine implements IDedObject
{
	//class variables
	private int magazineID;
	private String magazineName;
	private String publisherName;
	
	public Magazine(int id, String mname, String pname) //constructor
	{
		magazineID = id;
		magazineName = mname;
		publisherName = pname;
	}
	
	//get id
	public int getID() 
	{
		return magazineID;
	}
	
	public void printID() //prints the details of the magazine when called
	{
		System.out.println("Magazine ID: " + magazineID);	
		System.out.println("Magazine Name: " + magazineName);	
		System.out.println("Publisher Name: " + publisherName);	
		System.out.println();
	}
	
	//get magazine/publisher names
	public String getMagName()
	{
		return magazineName;
	}
	
	public String getPubName()
	{
		return publisherName;
	}
}
