package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class InsertionSort {

    static  public void sort(ArrayList<Comparable> array){
    	try {
    		for(int i=1;i<array.size();i++){
                Comparable item = array.get(i);
                int j = i-1;
                for(;j>=0 && array.get(j).compareTo(item) >=0;--j){
                    array.set(j+1,array.get(j));
                }
                array.set(j+1,item);
            }
    	}catch(NullPointerException e) {
    		System.out.println("Error Null Array");
    	}
        
    }

}
