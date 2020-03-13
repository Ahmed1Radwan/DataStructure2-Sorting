package eg.edu.alexu.csd.filestructure.sort;

public interface ISort<T extends Comparable<T>> {

    // O(nlogn)
    IHeap<T> heapSort(java.util.ArrayList<T> unordered);
    // O(n^2)
    void sortSlow(java.util.ArrayList<T> unordered);
    // O(n logn)
    void sortFast(java.util.ArrayList<T> unordered);
}