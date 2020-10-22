/*
 * Class: CS 3345
 * Section: 003
 * Semester: Spring 2019
 * Project 2: Make a magazine list using interfaces and generic classes
 */

import java.util.*;

public class Proj2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		//user choice variables
		int choice = 0;
		String c;		
		linkedlist list = new linkedlist(); //create linkedlist object
		
		while(choice != 7) //repeat until user exits
		{
			displayChoice(); //display menu
			boolean valid = false;
			while(!valid) //validate user input
			{
				System.out.print("Enter a number (1-7): ");
				c = in.nextLine(); //get user input
				try
				{
					choice = Integer.parseInt(c); 
					valid = true;
				}
				catch (NumberFormatException | NullPointerException nfe) 
				{
					valid = false;
				}
				
				if(choice > 7 || choice < 1)
				{
					valid = false;
				}
				
				if(!valid)
				{
					System.out.println("Invalid Input.");
				}
			}
						
			switch(choice) //switch for user input
			{
				case 1:
				{
					list.makeEmpty(); //call makeEmpty function
					System.out.println("List emptied.");
					break;
				}
				case 2:
				{
					int ID = getID(); //get and validate user input
					
					if(list.findID(ID) == null) //check if the magazine is in the list
					{
						System.out.println("Not found.");
					}
					else
					{
						list.findID(ID).printID(); //if it is, print the details
					}
					
					break;
				}
				case 3:
				{
					int ID = getID(); //get and validate user input
					
					String mname;
					System.out.print("Please enter a magazine name: ");
					mname = in.nextLine(); //get magazine name
					
					String pname;
					System.out.print("Please enter a publisher name: ");
					pname = in.nextLine(); //get publisher name
					
					Magazine newMag = new Magazine(ID, mname, pname); //create a new magazine object
					
					boolean exists = list.insertAtFront(newMag); //check if the magazine is already in the list
					if(!exists)
					{
						System.out.println("Magazine already in list.");
					}
					else
					{
						System.out.println("Magazine added."); 
					}
					
					break;
				}
				case 4:
				{
					if(list.deleteFromFront() == null) //check if the list is empty
					{
						System.out.println("The list is empty.");
					}
					else
					{
						System.out.println("Magazine deleted.");
					}
					break;
				}
				case 5:
				{
					int ID = getID(); //get and validate user input
					
					if(list.delete(ID) == null) //check if the magazine is in the list
					{
						System.out.println("ID not found.");
					}
					else
					{
						System.out.println("Magazine Deleted.");
					}
					break;
				}
				case 6:
				{
					list.printAllRecords(); //print the list
					break;
				}
				case 7:
				{
					System.out.print("Goodbye!"); //leave
					break;
				}		
			}
		}
		
	}
	
	public static void displayChoice() //display menu
	{
		System.out.println("1. Make Empty");
		System.out.println("2. Find ID");
		System.out.println("3. Insert At Front");
		System.out.println("4. Delete From Front");
		System.out.println("5. Delete ID");
		System.out.println("6. Print All Records");
		System.out.println("7. Done");		
	}
	
	public static int getID() //get and validate user input
	{
		Scanner in = new Scanner(System.in);
		//validation variables
		int id = 0;
		String ID;
		boolean valid = false;
		
		while(!valid) //loop until valid
		{
			System.out.print("Enter an ID number: ");
			ID = in.nextLine(); //get user input
			try //validate user input
			{
				id = Integer.parseInt(ID);
				valid = true;
			}
			catch (NumberFormatException | NullPointerException nfe) 
			{
				System.out.println("Invalid Input.");
				valid = false;
			}
		}
		return id; //return validated user input
	}
}
