package eg.edu.alexu.csd.filestructure.sort;


public interface IHeap<T extends Comparable<T>> extends Cloneable {

    INode<T> getRoot();
    void setSize(int size);
    int size();
    void heapify(INode<T> node);
    T extract();
    void insert(T element);
    void build(java.util.Collection<T> unordered);

}
