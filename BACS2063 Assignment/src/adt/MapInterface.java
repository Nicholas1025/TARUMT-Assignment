/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author XIANG
 */
public interface MapInterface<K, V> {
    
    // Returns the number of key-value pairs in the map
    public int size();
    
    // Returns true if the map is empty, false otherwise
    public boolean isEmpty();
    
    // Returns true if the map contains the specified key, false otherwise
    public boolean containsKey(K key);
    
    // Returns true if the map contains the specified value, false otherwise
    public boolean containsValue(V value);
    
    // Returns the value associated with the specified key, or null if the key is not found
    public V get(K key);
    
    // Associates the specified value with the specified key in the map
    public void put(K key, V value);
    
    // Removes the mapping for the specified key from the map
    public V remove(K key);
    
    // Removes all key-value mappings from the map
    public void clear();
    
    // Represents a key-value pair (entry) in the map
    public interface Entry<K, V> {
        
        // Returns the key associated with this entry
        public K getKey();
        
        // Returns the value associated with this entry
        public V getValue();
        
        // Replaces the value associated with this entry with the specified value
        public void setValue(V value);
    }
}
