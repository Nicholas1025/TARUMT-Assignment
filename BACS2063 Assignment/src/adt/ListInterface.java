package adt;
 
/**
 *
 * @author NicholasTayJunYang
 */
 
public interface ListInterface<T> {
 
    boolean add(T newEntry);
 
    T remove(int givenPosition);
 
    T getEntry(int givenPosition);
 
    int getNumberOfEntries();
 
    boolean isEmpty();
 
    boolean isFull();
 
    int getLength();
 
    T get(int index) throws IndexOutOfBoundsException;
}