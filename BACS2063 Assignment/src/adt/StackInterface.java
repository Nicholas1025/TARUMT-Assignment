/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;

/**
 * An interface for the ADT stack.
 *
 * @author Wong Kinn HOe
 * @version 2.0
 * @param <T>
 */
public interface StackInterface<T> {

    Iterator<T> getIterator();

    /**
     * Task: Adds a new entry to the top of the stack.
     *
     * @param newEntry an object to be added to the stack
     */
    public void push(T newEntry);

    /**
     * Task: Removes and returns the stack's top entry.
     *
     * @return either the object at the top of the stack or, if the stack is
     * empty before the operation, null
     */
    public T pop();

    public T pop(int index);

    public int getNUmberOfEntry();
    public int getnumberOfEntriesIterator();

    public T peek(int index);

    /**
     * Task: Retrieves the stack's top entry.
     *
     * @param index
     * @return either the object at the top of the stack or null if the stack is
     * empty
     */
    public T peek();

    /**
     * Task: Detects whether the stack is empty.
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Task: Removes all entries from the stack
     */
    public void clear();
    
    public T remove(int givenPosition);
} // end StackInterface
