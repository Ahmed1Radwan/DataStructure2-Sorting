package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class QuickSort {
	
	
	public static void sort(ArrayList<Comparable> arr) {
		
		
		part(arr,0,arr.size()-1);
		
	}

	private static void part(ArrayList<Comparable> arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l<r) {
			part(arr,l,(l+r)/2);
			part(arr,(l+r)/2+1,r);
			merge(arr,l,r);
		}
	}

	private static void merge(ArrayList<Comparable> arr, int l, int r) {
		// TODO Auto-generated method stub
		int mid = (l+r)/2+1,i=l,j=mid;
		Vector<Comparable> tmp = new Vector();
		
		while(i<mid && j<=r) {
			Comparable x = arr.get(i);
			Comparable y = arr.get(j);
			if(x.compareTo(y)<0) {
				tmp.add(arr.get(i++));
			}else {
				tmp.add(arr.get(j++));
			}
		}
		while(i<mid) {
			tmp.add(arr.get(i++));
		}
		while(j<=r) {
			tmp.add(arr.get(j++));
		}
		j=0;
		for(i =l;i<=r;i++) {
			arr.set(i, tmp.get(j++));
		}
	}
	
	
	/*
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
    */

}
