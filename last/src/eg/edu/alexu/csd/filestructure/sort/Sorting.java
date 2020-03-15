package eg.edu.alexu.csd.filestructure.sort;


import java.util.ArrayList;

public class Sorting  implements ISort{

    //private BinaryHeap heap = BinaryHeap.getInstance();


    @Override
    public IHeap heapSort(ArrayList unordered) {
    	IHeap heap = new BinaryHeap();
    	try {
    		
    		heap.build(unordered);

            for(int i=unordered.size();i>0;i--) {
                unordered.set(i-1,heap.extract());
            }
            heap.setSize(unordered.size());
    	}catch(NullPointerException e) {
    		System.out.println("Null array not expected");
    	}

    	 return heap;
    }

    @Override
    public void sortSlow(ArrayList unordered) {
    	try {
    		InsertionSort.sort(unordered);
    	}catch(NullPointerException e) {
    		System.out.println("Null array not expected");
    	}
        
    }

    @Override
    public void sortFast(ArrayList unordered) {
    	try {
    		/*
    		IHeap heap = new BinaryHeap();
    		heap.build(unordered);
    		for(int i=unordered.size();i>0;i--) {
                unordered.set(i-1,heap.extract());
            }
            */
    		QuickSort.sort(unordered);
    		//QuickSort.sort(unordered,0,unordered.size()-1);
    		//QuickSort.bottomUp(unordered);
    	}catch(NullPointerException e) {
    		System.out.println("Null array not expected");
    	}
        
    }
}