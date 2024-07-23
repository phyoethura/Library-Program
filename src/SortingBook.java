
public class SortingBook  {
	
	public static int search(double[] data, double value,int length) {
		
		
		int L = 0; 
		int H = length - 1;
		int M;
		
		while(L<=H)
		{	
			M = (L+H)/2;
			if(data[M]==value)
				return M;
			else
				if(data[M]<value) {
					L = M+1;
				}
						
			else
			{
				H = M - 1;
			}
					
			
		}
		//System.out.println("Error"); 
		return 999;
		
	}
	
	
	
	public  void print(int[] a){
		  System.out.print("[");
		  for(int i = 0 ; i< a.length ; i++)
	    {
	    	
	    	if(i!= a.length - 1)
	    		System.out.print(a[i] + ",");
	    	else
	    		System.out.print(a[i]);
	    }
		  System.out.println("]");

	  }  
	  
	  public void sortingBook(double[] a, int low, int high) { 
		  if (low < high)
	      {
	          /* pi is partitioning index, a[pi] is 
	            now at right place */
	          int pi = partition(a, low, high);

	          // Recursively sort elements before
	          // partition and after partition
	          sortingBook(a, low, pi-1);
	          sortingBook(a, pi+1, high);
	      }
		  
	  }
	  
	  public  int partition(double[] a, int low, int high) { 
		  double pivot = a[high]; 
	      int i = (low-1); // index of smaller element
	      for (int j=low; j<high; j++)
	      {
	          // If current element is smaller than or
	          // equal to pivot
	          if (a[j] <= pivot)
	          {
	              i++;
	              swap(a,i,j);
	              // swap arr[i] and arr[j]
	              //int temp = a[i];
	              //a[i] = a[j];
	              //a[j] = temp;
	          }
	      }

	      // swap arr[i+1] and arr[high] (or pivot)
	      swap(a,i+1,high);
	      //int temp = a[i+1];
	      //a[i+1] = a[high];
	      //a[high] = temp;
	      return i+1;
		  }
	  
	  
	  public  void swap(double[] a, int i, int j) { 
		  double temp = a[i];
	      a[i] = a[j];
	      a[j] = temp;

	  } 
	  
	  
}
