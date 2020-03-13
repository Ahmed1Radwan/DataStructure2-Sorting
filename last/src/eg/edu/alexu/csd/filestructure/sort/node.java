package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class node implements INode {

    private ArrayList<INode> heap;
    
    private Comparable nodeValue;
    private int nodeIndex;

    public node(Comparable value,int index,ArrayList<INode> heap){
        this.nodeIndex = index;
        this.nodeValue = value;
        this.heap = heap;
    }

    @Override
    public INode getLeftChild() {
    	int size = heap.size() - 1;;
    	//System.out.println(size);
    	//System.out.println("------------------------");
    	int index = 2*nodeIndex;
    	//System.out.println(index);
    	//System.out.println("---------------------------");
    	//System.out.println(heap.getHeap().get(index));
    	if(index<= size) {
    		return (INode) heap.get(2*nodeIndex);
    	}
    	return null;
        
    }

    @Override
    public INode getRightChild() {
    	int size = heap.size() - 1;
    	int index = 2*nodeIndex+1;
    	if(index<=size) {
    		return (INode)heap.get(2*nodeIndex + 1);
    	}
        return null;
    }

    @Override
    public INode getParent() {
    	if(nodeIndex == 0 || nodeIndex == 1) {
    		return null;
    	}
        return (INode)heap.get(nodeIndex / 2);
    }

    @Override
    public Comparable getValue() {
        return nodeValue;
    }

    @Override
    public void setValue(Comparable value) {
        nodeValue = value;
    }

    public int getNodeIndex(){
        return nodeIndex;
    }
    public void setNodeIndex(int index){
        this.nodeIndex = index;
    }
}