import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{
		
		boolean goodInput = false;
		boolean okay = false;
		Scanner scan = new Scanner(System.in);
		int input;
		
		Student kelvin = new Student();
		BorrowBook studentBook = new BorrowBook();		
		
		Teacher arjan = new Teacher();
		BorrowBook teacherBook = new BorrowBook();
		
		Staff mrKelvin = new Staff();
		BorrowBook staffBook = new BorrowBook();
		
		Book book = new Book();
		Librarians lib = new Librarians();
		
		System.out.println("_________________________________________________________\n");
		System.out.println("|        WELCOME TO SABAIDEE LIBRARY SYSTEM             |");
		System.out.println("_________________________________________________________");
		
		String name=" ";
		double id=0;
		
		 boolean goodInput4 = false;
		do {
			try {
				System.out.print("Enter your name : ");
				 name = scan.nextLine();
				
				goodInput4 = true;
		
			}
			catch(InputMismatchException e)
			{
				scan.nextLine();
				System.out.println("\n----------------------------------------------------\n");
				System.out.println("Input is not a number.");
				System.out.println("Try Again.");
				System.out.println("\n----------------------------------------------------\n");
			}
		}while(goodInput4 == false);
		
		boolean goodInput5 = false;
		do {
			try {
				System.out.print("Enter your id : ");
				 id = scan.nextDouble();
				
				goodInput5 = true;
		
			}
			catch(InputMismatchException e)
			{
				scan.nextLine();
				System.out.println("\n----------------------------------------------------\n");
				System.out.println("Input is not a number.");
				System.out.println("Try Again.");
				System.out.println("\n----------------------------------------------------\n");
			}
		}while(goodInput5 == false);
		
		
		System.out.println("\n--------------------------------------------------------------------------\n");
		System.out.println("Hello "+name+ "! \nPlease select who you are!");
		//BorrowBook bobo = new BorrowBook();
		do {
			do {
				try {
					System.out.println("\n--------------------------------------------------------------------------\n");
					System.out.print("1. Librarian.\n2. Member.\nPress : ");
					input = scan.nextInt();
					if(input == 1)
					{
						lib.setId(id);
						lib.setName(name);
						lib.startLibrarian(book);
					}
					
					else if(input == 2)
						
					{
						boolean goodInput2 = false;
						do {
							try {
									System.out.println("\n-----------------------------------\n");
									System.out.print("\n1. Teacher\n2. Student\n3. Staff.\n4.Exit.\nPress who you are :");
									input = scan.nextInt();
									
									if(input == 1)
										{
											arjan.setId(id);
											arjan.setName(name);
											arjan.startTeacher(book,teacherBook);
										}
									else if(input == 2)
										{
											kelvin.setId(id);
											kelvin.setName(name);
											kelvin.startStudent(book, studentBook);
										}
									else if(input == 3)
										{
											mrKelvin.setId(id);
											mrKelvin.setName(name);
											mrKelvin.startStaff(book, staffBook);
										}
									else if(input ==4)
									{
										
									}
									else 
									{
										System.out.println("Please press 1-4 only! Try Again!");
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
		
				
				
				goodInput = false;
				do {
					try {
						System.out.println("\n----------------------------------------------------\n");
						System.out.print("1. RESTART Program.\n2. Exit\nPress : ");
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
		
		System.out.println("\n-----------------------------------------------------------------\n");
		System.out.println("|          Thank You for Using SaBaiDee Library System	        |");
		System.out.println("\n-----------------------------------------------------------------\n");

		
		
		
		
		
	}
}
