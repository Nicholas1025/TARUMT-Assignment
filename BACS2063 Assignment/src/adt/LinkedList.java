    package ADT;
 
    import adt.ListInterface;
 
    /**
     *
     * @author NicholasTayJunYang
     */
 
    public class LinkedList<T> implements ListInterface<T> {
 
        private Node firstNode;
        private int numberOfEntries;
 
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
 
        public LinkedList() {
            firstNode = null;
            numberOfEntries = 0;
        }
 
        public boolean add(T newEntry) {
            Node newNode = new Node(newEntry);
            if (isEmpty()) {
                firstNode = newNode;
            } else {
                Node currentNode = firstNode;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = newNode;
            }
            numberOfEntries++;
            return true;
        }
 
        public T remove(int givenPosition) {
            if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
                T result;
                if (givenPosition == 1) {
                    result = firstNode.data;
                    firstNode = firstNode.next;
                } else {
                    Node nodeBefore = getNodeAt(givenPosition - 1);
                    Node nodeToRemove = nodeBefore.next;
                    result = nodeToRemove.data;
                    nodeBefore.next = nodeToRemove.next;
                }
                numberOfEntries--;
                return result;
            } else {
                return null;
            }
        }
 
        public T getEntry(int givenPosition) {
            if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
                return getNodeAt(givenPosition).data;
            } else {
                return null;
            }
        }
 
        public int getNumberOfEntries() {
            return numberOfEntries;
        }
 
        public boolean isEmpty() {
            return (numberOfEntries == 0);
        }
 
        public boolean isFull() {
            // LinkedLists are generally not bound by capacity, so it's not full.
            return false;
        }
 
        public int getLength() {
            return numberOfEntries;
        }
 
        public T get(int index) throws IndexOutOfBoundsException {
            if (index < 1 || index > getLength()) {
                throw new IndexOutOfBoundsException("Index out of bounds.");
            }
            return getNodeAt(index).data;
        }
 
        private Node getNodeAt(int givenPosition) {
            Node currentNode = firstNode;
            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }
 