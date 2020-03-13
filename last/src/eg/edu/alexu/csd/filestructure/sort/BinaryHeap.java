package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BinaryHeap implements IHeap {

    //private static BinaryHeap binaryHeap = new BinaryHeap();
    private static final int CAPACITY = 10;
    private int size = 0;
    private ArrayList<INode> heap;

    public ArrayList<INode> getHeap(){
        return this.heap;
    }
    /*
    public static BinaryHeap getInstance(){
        return binaryHeap;
    }
   */
    public BinaryHeap() {
    	heap = new ArrayList<>();
    }
    
    @Override
    public INode getRoot() {
    	if(size == 0) {
    		return null;
    	}
        return heap.get(1);
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Comparable extract() {
        if(size == 0) {
        	return null;
        }
        Comparable max = heap.get(1).getValue();
        heap.get(1).setValue(heap.get(size--).getValue());
        
        heap.get(size+1).setValue(max);/////
        
        heapify(heap.get(1));
        return max;
    }

    @Override
    public void insert(Comparable x) {
    	if(x == null) {
        	return;
        }
        if(size == 0) {
            heap.add(0,new node(null ,0,heap));
        }
        int pos = ++size;
        //System.out.println(pos);
        heap.add(pos,new node(null ,pos,heap));
        for(; pos>1 && x.compareTo(heap.get(pos/2).getValue()) > 0 ; pos = pos / 2) {
            heap.get(pos).setValue(heap.get(pos/2).getValue());
        }
        heap.get(pos).setValue(x);
    }



    @Override
    public void build(Collection unordered) {
    	try {
    		size = unordered.size();
            heap = new ArrayList<>();
            heap.add(null);
            int i = 1;
            for (Iterator iter = unordered.iterator(); iter.hasNext(); ) {
                heap.add(i, new node((Comparable) iter.next(),i,heap));
                i++;
            }
            //System.arraycopy(unordered,0,heap,1,size);
            for(int k = size/2;k>0;k--){
                heapify(heap.get(k));
            }
    	}catch(NullPointerException e) {
    		System.out.println("NUll Collection not allowed");
    	}
        
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public void heapify(INode node) {
    	if(node == null) {
    		return;
    	}
        Comparable tmp = node.getValue();
        int k = node.getNodeIndex();
        int child;
        for(;2*k <= size;k=child){
            child = 2*k;
            if(child != size && heap.get(child).getValue().compareTo(heap.get(child+1).getValue()) < 0) {
                child++;
            }
            if(tmp.compareTo(heap.get(child).getValue()) < 0) {
                heap.get(k).setValue(heap.get(child).getValue());
            }else {
                break;
            }
        }
        heap.get(k).setValue(tmp);
    }

    public String toString() {
        String elements = "";
        for(int k=1;k<=size;k++) elements += heap.get(k).getValue() + " ";
        return elements;
    }
}
