package adt;

import java.util.Iterator;

public class LinkedQueue<T> implements QueueInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int numberOfData = 0;

    public LinkedQueue() {
        clear();
        this.numberOfData = 0;
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        this.numberOfData++;
    }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
        }

        return front;
    }

    public int size() {
        return numberOfData;
    }

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
            firstNode = firstNode.next;

            if (firstNode == null) {
                lastNode = null;
            }
        }

        return front;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public final void clear() {
        firstNode = null;
        lastNode = null;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }
    
    public T indexOf(int index) {
        T result = null;

        if ((index >= 0) && (index <= numberOfData)) {
            Node currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }

        return result;
    }

    public boolean set(int index, T anEntry) {

        boolean successful = false;

        if ((index >= 1) && (index <= numberOfData)) {
            Node currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.data = anEntry;
            successful = true;
        }

        return successful;
    }

    @Override
    public String toString() {

        String output = "";
        Node currentNode = this.firstNode;

        if (currentNode != null) {
            while (currentNode != lastNode) {
                output += currentNode.data.toString();
                currentNode = currentNode.next;
            }
        }

        return output;

    }

    @Override
    public Iterator<T> getIterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {

        private Node currentNode;

        public LinkedQueueIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnData = currentNode.data;
                currentNode = currentNode.next;

                return returnData;
            } else {
                return null;
            }
        }
        
        
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
