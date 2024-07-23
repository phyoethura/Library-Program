import java.util.InputMismatchException;
import java.util.Scanner;
public class Book extends SortingBook {
	private int size = 100;
	//private int front = 0;
	private int rear =0;
	private double[] bookId = new double[size]; 
	private String[] bookName = new String[size];
	private boolean[] bookVerify = new boolean[size];
	
	
	
	//SortingBook sortBook = new SortingBook();
	
	Scanner scan = new Scanner(System.in);
	
	public boolean borrowableVerify(int id)
	{
		if(bookVerify[id] = true)
		{
			System.out.println("You can borrow "+bookId + " : " + bookName + ".");
			return true;
		}
		else
		{
			System.out.println("Sorry, " + bookId + " : " + bookName + " is borrowed by someone.");
			System.out.println("Please Try Another Book");
			return false;
		}
	}
	
	public void setBookVerify(boolean v,int i)
	{
		bookVerify[i] = v;
	}
	public boolean getBookVerify(int i)
	{
		return bookVerify[i];
	}
	
	public void setBookId(double i, int j)
	{
		bookId[j] = i;
	}
	public double getBookId(int i)
	{
		return bookId[i];
	}
	
	public String getBookName(int i)
	{
		return bookName[i];
	}
	public void setBookName(String name,int i)
	{
		bookName[i] = name;
	}
	
	public void sort()
	{
		double[] tmpId = new double[size];
		String[] tmpName = new String[size];
		boolean[] tmpVerify = new boolean[size];
		
		for(int i = 0; i<rear ; i++)
		{
			tmpId[i] = bookId[i];
		}
		
		
		sortingBook(bookId,0,rear-1);
	
		for(int i = 0;i<rear;i++)
		{
			for(int j = 0; j<rear ; j++)
			{
				if(tmpId[j] == bookId[i])
					{
						tmpName[i] = bookName[j];
						tmpVerify[i] = bookVerify[j];
					}
				
			}
		}
		for(int i = 0; i<rear ; i++)
		{
			
			bookName[i] = tmpName[i];
			bookVerify[i] = tmpVerify[i];
		}
		//bookId = tmpId;
		
		//for(int i = 0; i<rear ; i++)
		//{
			//if(bookId[i] !=0)
			//{
				//System.out.print("Book id : " + bookId[i]);
				//System.out.println(" , Book Name : " + bookName[i]);
			//}
			
		//}
		
		//bookName = tmpName;
		//bookVerify = tmpVerify;
	}
	
	public Book()
	{
		for(int i = 0; i<10; i++)
		{
			bookId[i] = (i+1);
			bookName[i] = "OOP Book " + (i+1) ;
			bookVerify[i] = true;
			rear ++;
		}
		sort();
		
		
	}
	
	public int searchBook(double searchId)
	{
		int position = search(bookId,searchId ,rear);
		if(position != 999)
		{
			//System.out.println("Found "+ 17 + " at position " + position);
			return position;
		}
		else
			return -1;
			
		
	}
	
	public void insertBook()
	{
		boolean goodInput = false;
		double input=0;
		String inp=" ";
		do {
			try {
				System.out.print("Please Enter Book ID : ");
				input = scan.nextDouble();
				
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
		bookId[rear] = input;
		goodInput = false;
		do {
			try {
				System.out.print("Please Enter Book Name : ");
				inp=scan.next();
				
				goodInput = true;
		
			}
			catch(InputMismatchException e)
			{
				scan.nextLine();
				System.out.println("\n----------------------------------------------------\n");
				System.out.println("Input is not a String.");
				System.out.println("Try Again.");
				//System.out.println("\n----------------------------------------------------\n");
			}
		}while(goodInput == false);
		
		
		bookName[rear] = inp;
		bookVerify[rear] = true;
		System.out.println("Successfully inserted book id : " + bookId[rear] + ", book name : "+ bookName[rear] );
		rear ++;
		sort();
	}

	public void deleteBook()
	{
		checkBook();
		double input = 0;
		
		 boolean goodInput = false;
		do {
			try {
				System.out.print("Please select the book ID to delete : ");
				input = scan.nextDouble();
				
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
		
		int position = search(bookId,input ,rear);
		
		if(position != 999)
		{
			for(int i = position; i < rear-1; i++)
			{
				bookId[i] = bookId[i+1];
				bookName[i] = bookName[i+1];
				bookVerify[i] = bookVerify[i+1];
				
			}
			rear--;
			
			//sort();
			
			System.out.println("Book ID : " + input + " is deleted successfully!");
		}
		else
		{
			System.out.println("Book ID : " + input + " is not available!");
		}
	}
	
	public void checkBook()
	{
		System.out.println("\n----------------------------------------------------\n");
		for(int i = 0; i<rear ; i++)
		{
			if(bookId[i] !=0)
			{
				System.out.print("Book id : " + bookId[i]);
				System.out.println(" , Book Name : " + bookName[i]);
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
}
