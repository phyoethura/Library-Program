import java.util.InputMismatchException;
import java.util.Scanner;
public class Librarians extends User {
	private double id;
	private String name;
	private String position;
	private final int PIN = 777;
	
	boolean goodInput = false;
	
	Scanner scan = new Scanner(System.in);
	
	public Librarians ()
	{
		id = 123;
		name = "Mr. Kelvin Staff";
		position = "L-Staff";
	}
	
	public Librarians (double id, String name, String position)
	{
		this.id = id;
		this.name = name;
		this.position = position;
	}
	
	public void setId()
	{
		id = 123;
	}
	
	public void setId (double id)
	{
		this.id = id;
	}
	
	public double getId()
	{
		return id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setPosition (String position)
	{
		this.position = position;
	}
	public String getPosition()
	{
		return position;
	}
	
	public boolean verifyLogin()
	{
		boolean apk=false;
		do {
		try {
			System.out.println("\n--------------------------------------------------------------------------\n");
			System.out.println("Please Verify to login as a Librarian with PIN!");
			System.out.print("Press PIN or Press 0 to exit    : ");
			int inputLogin = scan.nextInt();
			if(inputLogin == PIN)
			{
				System.out.println("\n----------------------------------------------------\n");
				System.out.println("Success verification of Librarian!");
				apk = true;
			}
			else if(inputLogin == 0)
			{
				
			}
			else
			{
				System.out.println("Please press 1 or 2 only! Try Again!");
				continue;
			}
			goodInput = true;
	
		}
		catch(InputMismatchException e)
		{
			scan.nextLine();
			System.out.println("\n----------------------------------------------------\n");
			System.out.println("Input is not a number.");
			System.out.println("Try Again.");
			//System.out.println("\n----------------------------------------------------\n");
		}
	}while(goodInput == false);
		
		return apk;	
		
	}
	
	public void startLibrarian(Book b)
	{
		
		boolean loginSuccess = false;
		loginSuccess = verifyLogin();
		boolean okay = false;
		if(loginSuccess == true)
		{
			do {
				 
			
				do {
					try {
						System.out.println("\n----------------------------------------------------\n");
						System.out.println("1. Insert Book.\n2. Delete Book.\n3. Check Books.\n4. Exit.");
						System.out.print("Press : ");
						int input = scan.nextInt();
						if(input == 1)
						{
							b.insertBook();
						}
						else if(input ==2 )
						{
							b.deleteBook();
						}
						else if(input == 3)
						{
							b.checkBook();
						}
						else if(input == 4)
						{
							
						}
						else
						{
							System.out.println("Please press 1-4 only! Try Again!");
							continue;
						}
						
						goodInput = true;
				
					}
					catch(InputMismatchException e)
					{
						scan.nextLine();
						System.out.println("\n----------------------------------------------------\n");
						System.out.println("Input is not a number.");
						System.out.println("Try Again.");
						//System.out.println("\n----------------------------------------------------\n");
					}
				}while(goodInput == false);
				
				goodInput = false;
				do {
					try {
						System.out.println("\n--------------------------------------------------------------------------\n");
						System.out.print("1. RESTART Process.\n2. Exit.\nPress : ");
						int k = scan.nextInt();
						if(k == 1)
						{
							okay = false;
						}
						else if(k == 2)
						{
							okay = true;
						}
						else						
						{
							System.out.println("Please press 1-2 only! Try Again!");
							continue;
						}
						
						goodInput = true;
				
					}
					catch(InputMismatchException e)
					{
						scan.nextLine();
						System.out.println("\n----------------------------------------------------\n");
						System.out.println("Input is not a number.");
						System.out.println("Try Again.");
						//System.out.println("\n----------------------------------------------------\n");
					}
				}while(goodInput == false);
			
			
			}while(okay == false);
				
		}
		else
		{
			
		}
		
	}
}
