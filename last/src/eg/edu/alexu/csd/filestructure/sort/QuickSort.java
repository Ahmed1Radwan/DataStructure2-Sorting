package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
	
	
	
    private static int partition(ArrayList<Comparable> arr, int low, int high)
    {
        Comparable pivot = arr.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr.get(j).compareTo(pivot) < 0)
            {
                i++;

                // swap arr[i] and arr[j]
                Comparable temp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Comparable temp = arr.get(i+1);
        arr.set(i+1,arr.get(high));
        arr.set(high,temp);

        return i+1;
    }
   

  
    public static void sort(ArrayList<Comparable> arr, int low, int high)
    {
    	
    		if (low < high)
            {
              
                int pi = partition(arr, low, high);	
                // Recursively sort elements before
                // partition and after partition
                sort(arr, low, pi-1);
                sort(arr, pi+1, high);
            }
    	
        
    }
    

}
