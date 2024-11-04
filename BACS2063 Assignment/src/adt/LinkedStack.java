/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.Iterator;
public class LinkedStack<T> implements StackInterface<T> {

    private Node topNode;
    private int numberOfEntries;
    private int numberOfEntriesIterator;

    @Override
    public void push(T newEntry) {
        //Create a new node
        Node newNode = new Node(newEntry);
        //Make the new node's next point to the current top node
        newNode.next = topNode;
        //Make the head reference topNode point to the new node 
        topNode = newNode;
        ++numberOfEntries;
    }
    
    
    @Override
    public T pop(int index) {
        T result = null;
        return result;
    }

    @Override
    public T pop() {
        T topElement = null;
        if (!isEmpty()) {
            topElement = topNode.data;
            topNode = topNode.next;
            numberOfEntries--;
        }
        return topElement;
    }

    @Override
    public T peek() {
        T topElement = null;
        if (!isEmpty()) {
            topElement = topNode.data;
        }
        return topElement;
    }

    @Override
    public T peek(int index) {
        T result = null;
        if (index >= 1 && index <= numberOfEntries+1) {
           Node currentNode = topNode;
           for(int i =0; i<index-1;++i){
               currentNode = currentNode.next;
           }
           result = currentNode.data;
        }
        if (index < 0 || index >= numberOfEntries+1) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return result;
    }


    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = topNode;
        while (currentNode != null) {
            outputStr += currentNode.data;
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    @Override
    public Iterator<T> getIterator() {
        return new LinkedIterator();
    }

    @Override
    public int getNUmberOfEntry() {
        return numberOfEntries;
    }

    @Override
    public int getnumberOfEntriesIterator() {
        return numberOfEntriesIterator;
    }

    @Override
    public T remove(int givenPosition) {
    T result = null;                 // return value

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = topNode.data;     // save entry to be removed
        topNode = topNode.next;
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = topNode;
        for (int i = 1; i < givenPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = nodeBefore.next.data;  // save entry to be removed
        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      numberOfEntries--;
    }

    return result; // return removed entry, or null if operation fails
  }

    

    private class LinkedIterator implements Iterator<T> {

        private Node currentNode = topNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T currentEntry = null;
            if (hasNext()) {
                currentEntry = currentNode.data;
                currentNode = currentNode.next;
                numberOfEntriesIterator++;
            }
            return currentEntry;
        }
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
