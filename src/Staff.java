import java.util.InputMismatchException;
import java.util.Scanner;
public class Staff extends User {
	private double id;
	private String name;
	private String position;
	private final int PIN = 666;
	boolean goodInput = false;
	
	
	Scanner scan = new Scanner(System.in);
	
	public Staff ()
	{
		id = 987;
		name = "ArjanKelvin";
		position = "Teacher";
	}
	
	public Staff (double id, String name, String position)
	{
		this.id = id;
		this.name = name;
		this.position = position;
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
			System.out.println("\n----------------------------------------------------\n");
			System.out.println("Please Verify to login with PIN!");
			System.out.print("Press PIN or Press 0 to exit : ");
			int inputLogin = scan.nextInt();
			if(inputLogin == PIN)
			{
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
			System.out.println("\n----------------------------------------------------\n");
		}
	}while(goodInput == false);
		
		return apk;	
		
	}
	
	public void startStaff(Book b, BorrowBook bBook)
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
						System.out.println("1. Borrow Book.\n2. Return Book.\n3. Print borrowed books details.\n4. Exit.");
						System.out.print("Press : ");
						int input = scan.nextInt();
						if(input == 1)
						{
							boolean goodInput2 = false;
							
							do {
								try {
									System.out.println("1. Check Book.\n2. Search Book.\n3. Exit.");
									System.out.print("Press : ");
									int put = scan.nextInt();
									if ( put == 1)
									{
										bBook.checkBook(b);
									}
									else if(put == 2)
									{
										bBook.searchBook(b);
									}
									else
									{
										System.out.println("Please press 1-3 only! Try Again!");
										continue;
									}
									
									goodInput2 = true;
							
								}
								catch(InputMismatchException e)
								{
									scan.nextLine();
									System.out.println("\n----------------------------------------------------\n");
									System.out.println("Input is not a number.");
									System.out.println("Try Again.");
									//System.out.println("\n----------------------------------------------------\n");
								}
							}while(goodInput2 == false);
							
						}
						else if(input ==2 )
						{
							bBook.returnBook(b);
						}
						else if(input == 3)
						{
							bBook.printBorrowBookDetail();
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
						System.out.println("\n----------------------------------------------------\n");
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
