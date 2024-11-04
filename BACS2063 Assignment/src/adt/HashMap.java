/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adt;

/**
 *
 * @author XIANG
 */
public class HashMap<K, V> implements MapInterface<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public Entry<K, V>[] table;
    private int size;

    public HashMap() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            entry = entry.getNext();
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
                entry = entry.getNext();
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            entry = entry.getNext();
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
        if (size >= table.length * LOAD_FACTOR) {
            resizeTable();
        }

        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.setNext(table[index]);
        table[index] = newEntry;
        size++;
    }

    @Override
    public V remove(K key) {
    int index = getIndex(key);
    Entry<K, V> entry = table[index];
    Entry<K, V> prevEntry = null;

    while (entry != null) {
        if (entry.getKey().equals(key)) {
            if (prevEntry != null) {
                prevEntry.setNext(entry.getNext());
            } else {
                table[index] = entry.getNext();
            }
            size--;
            return entry.getValue(); // Return the removed value here
        }
        prevEntry = entry;
        entry = entry.getNext();
    }

    return null; // Return null if the key is not found
}

    @Override
    public void clear() {
        table = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // Define a custom EntryList class to store entries
    public static class EntryList<K, V> {
        public Entry<K, V> entry;
        public EntryList<K, V> next;

        EntryList(Entry<K, V> entry) {
            this.entry = entry;
            this.next = null;
        }
    }

    // Add a custom method to iterate through entries
    public EntryList<K, V> entrySet() {
        EntryList<K, V> entries = null;
        EntryList<K, V> tail = null;

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                EntryList<K, V> newEntry = new EntryList<>(entry);
                if (entries == null) {
                    entries = newEntry;
                    tail = newEntry;
                } else {
                    tail.next = newEntry;
                    tail = newEntry;
                }
                entry = entry.getNext();
            }
        }

        return entries;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % table.length;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                int newIndex = getIndex(entry.getKey());
                Entry<K, V> next = entry.getNext();
                entry.setNext(newTable[newIndex]);
                newTable[newIndex] = entry;
                entry = next;
            }
        }

        table = newTable;
    }
    

    public static class Entry<K, V> implements MapInterface.Entry<K, V> {
        private final K key;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
        
    }
}

