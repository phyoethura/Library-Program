import java.util.InputMismatchException;
import java.util.Scanner;

public class BorrowBook extends SortingBook {
	private int borrowSize = 100;
	//private int borrowFront = 0;
	private int borrowRear = 0;
	
	private double[] borrowBookId = new double[borrowSize];
	private String[] borrowBookName = new String [borrowSize];
	//private boolean[] borrowBookVerify = new boolean[borrowSize];
	
	
	//BorrowDetail borrowDetail = new BorrowDetail();
	Scanner scan = new Scanner(System.in);
	public BorrowBook()
	{
		
	}
	
	public void searchBook(Book b)
	{
		boolean goodInput = false;
		do {
			try {
				System.out.print("Press book ID to check a book borrowable or not : ");
				double input = scan.nextDouble();
				int availableBook = b.searchBook(input);
				if(availableBook != -1)
				{
					boolean checkBorrow = b.getBookVerify(availableBook);
					if(checkBorrow == true)
					{
						System.out.println("\n----------------------------------------------------\n");
						System.out.print("1. Borrow.\n2. Back.\nPress : ");
						int inputCheck = scan.nextInt();
						if(inputCheck == 1)
						{
							borrowBook(availableBook,b);
							
						}
						else
						{
							System.out.println("Sorry, the book you are searching is currently not available!");
							System.out.println("\n----------------------------------------------------\n");
						}
						
					}
					else
					{
						System.out.println("\n----------------------------------------------------\n");
						System.out.println("Sorry, the book you are searching is not from our system!");
						
						boolean goodInput2 = false;
						do {
							try {
								System.out.println("\n----------------------------------------------------\n");
								System.out.print("1. Check Book again.\n2. Exit.\nPress : ");
								input = scan.nextInt();
								if(input == 1)
								{
									searchBook(b);
								}
								else if(input == 2)
								{
									
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
						}while(goodInput2 == false);
						
					}
				}
				else if(availableBook == -1)
				{
					System.out.println("\n----------------------------------------------------\n");
					System.out.println("The Book is not from the system!!");
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
		
	}
	
	public void checkBook(Book b)
	{
		
		b.checkBook();
		boolean goodInput = false;
		do {
			try {
				System.out.print("Press book ID to check a book borrowable or not : ");
				double input = scan.nextDouble();
				int availableBook = b.searchBook(input);
				if(availableBook != -1)
				{
					boolean checkBorrow = b.getBookVerify(availableBook);
					if(checkBorrow == true)
					{
						System.out.println("\n----------------------------------------------------\n");
						System.out.print("1. Borrow.\n2. Back.\nPress : ");
						int inputCheck = scan.nextInt();
						if(inputCheck == 1)
						{
							borrowBook(availableBook,b);
							
						}
						else
						{
							System.out.println("Sorry, the book you are searching is currently not available!");
							System.out.println("\n----------------------------------------------------\n");
						}
						
					}
					else
					{
						System.out.println("\n----------------------------------------------------\n");
						System.out.println("Sorry, the book you are searching is not from our system!");
						
						boolean goodInput2 = false;
						do {
							try {
								System.out.println("\n----------------------------------------------------\n");
								System.out.print("1. Check Book again.\n2. Exit.\nPress : ");
								input = scan.nextInt();
								if(input == 1)
								{
									searchBook(b);
								}
								else if(input == 2)
								{
									
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
						}while(goodInput2 == false);
						
					}
				}
				else if(availableBook == -1)
				{
					System.out.println("\n----------------------------------------------------\n");
					System.out.println("The Book is not from the system!!");
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
	}
	
	public void borrowBook(int index,Book b)
	{
		System.out.println("Successfully borrowed " + b.getBookId(index) + " : " + b.getBookName(index) );
		System.out.println("\n----------------------------------------------------\n");
		b.setBookVerify(false, index);
		//borrowBookId[borrowRear] = b.getBookId(index);
		//borrowBookName[borrowRear] = b.getBookName(index);
		//borrowRear++;
		insertBorrowBook( b.getBookId(index), b.getBookName(index));
	}
	
	public void sort() {
		double[] tmpBookId = new double[borrowSize];
		String[] tmpBookName = new String[borrowSize];
		boolean[] tmpVerify = new boolean[borrowSize];
		
		for(int i = 0; i<borrowRear ; i++)
		{
			tmpBookId[i] = borrowBookId[i];
		}
		
		
		sortingBook(borrowBookId,0,borrowRear-1);
	
		for(int i = 0;i<borrowRear;i++)
		{
			for(int j = 0; j<borrowRear ; j++)
			{
				if(tmpBookId[j] == borrowBookId[i])
					{
						tmpBookName[i] = borrowBookName[j];
						//tmpVerify[i] = borrowBookVerify[j];
					}
				
			}
		}
		for(int i = 0; i<borrowRear ; i++)
		{
			
			borrowBookName[i] = tmpBookName[i];
			//borrowBookVerify[i] = tmpVerify[i];
		}
	}
	
	public void insertBorrowBook(double id, String name)
	{
		borrowBookId[borrowRear] = id;
		borrowBookName[borrowRear] = name;
		borrowRear++;
		sort();
	}
	
	public void returnBook(Book b)
	{
		
		double inp = 0;
		boolean goodInput = false;
		do {
			try {
				System.out.println("\n----------------------------------------------------\n");
				System.out.print("Please enter book id to return : ");
				 inp = scan.nextDouble();
				
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
		
		
		
		
		
		//int x = b.searchBook(inp);
		//if(x == 0)
		//{
		//	System.out.println("The book is not from the system.");
		//}
		//else
		//{
			
			
			int position = search(borrowBookId, inp,borrowRear);
			if(position != 999)
			{
				for(int i = position; i < borrowRear; i++)
				{
					borrowBookId[i] = borrowBookId[i+1];
					borrowBookName[i] = borrowBookName[i+1];
					//bookVerify[position] = bookVerify[position+1];
				}
				borrowRear--;
				
				sort();
				int pos = b.searchBook(inp);
				b.setBookVerify(true, pos);
				System.out.println("Book ID : " + inp + "is returned successfully");
			}
			else
			{
				System.out.println("Book ID : " + inp + " is not borrowed yet!");
			}
		//}
		
	}
	
	public void printBorrowBookDetail()
	{
		System.out.println("\n----------------------------------------------------\n");
		System.out.println("Books you borrowed are as follow!");
		if(borrowRear!= 0)
		{
			for(int i = 0; i<borrowRear ; i ++)
			{
				System.out.println("Book id : " + borrowBookId[i] + " , Book Name : " + borrowBookName[i]);
			}
		}
		else
			System.out.println("There is no book that you have borrowed !!");
		
		//System.out.println("\n----------------------------------------------------\n");
	}
	
	
}
