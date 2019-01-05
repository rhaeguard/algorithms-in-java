package com.owary.faora.datastructures.dictionary;

import com.owary.faora.datastructures.trees.binarysearchtree.BinarySearchTree;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Dictionary<K extends Comparable<K>, V extends Comparable<V>> {

    private final int ARRAY_CAPACITY = 64;

    private int size = 0;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] bucket;

    private BinarySearchTree<K> keys;

    public Dictionary(){
        this.bucket = new Entry[ARRAY_CAPACITY];
        this.keys = new BinarySearchTree<>();
    }

    public void add(K key, V value){
        int index = getHashedKey(key);
        if(contains(key)){
            Entry<K, V> temp = bucket[index];
            while (temp.hasNext()){
                temp = temp.next();
            }
            temp.next(new Entry<>(key, value));
        }else {
            bucket[index] = new Entry<>(key, value);
            addKey(key);
        }
        size++;
    }

    /**
     * Retrieve an entry by provided key
     * @param key
     * @return Entry
     */
    public Entry<K, V> get(K key){
        int index = getHashedKey(key);
        return bucket[index];
    }

    /**
     * Removes an element with given key.
     * Removes everything related to the key
     * Not appropriate for removing "chained" elements
     * @param key
     */
    public void delete(K key){
        if(!this.contains(key)){throw new NoSuchElementException();}
        int index = getHashedKey(key);
        bucket[index] = null;
        deleteKey(key);
        size--;
    }

    /**
     * Removes an element with given key and value
     * Appropriate for removing an element from "chain"
     * @param key
     * @param value
     */
    public void delete(K key, V value){
        if(!this.contains(key)){throw new NoSuchElementException();}
        int index = getHashedKey(key);
        if(bucket[index].value().equals(value) && !bucket[index].hasNext()){
            delete(key);
        }else if(bucket[index].value().equals(value) && bucket[index].hasNext()){
            bucket[index] = bucket[index].next();
            size--;
        }else{
            Entry<K, V> prev = bucket[index];
            Entry<K, V> current = prev.next();
            int s = size;
            while(s-->0){
                if(current.value().equals(value)){
                    prev.next(current.next());
                    break;
                }
                prev = current;
                current = current.next();
            }
            size--;
        }
        deleteKey(key);
    }

    public int size(){return size;}

    /**
     * Returns the keys
     * @return K[]
     */
    public K[] keys(){
        K[] keys = (K[]) new Comparable[size];
        int j=0;
        for(int i=0;i<bucket.length;i++){
            if(bucket[i]!=null){
                keys[j] = bucket[i].key();
                j++;
            }
        }
        return Arrays.copyOfRange(keys, 0, j);
    }

    public boolean contains(K key){
        return get(key)!=null;
    }

    private void addKey(K key){
        if(!keys.contains(key)){
            keys.add(key);
        }
    }

    private void deleteKey(K key){
        if(keys.contains(key)){
            keys.delete(key);
        }else{
            throw new NoSuchElementException();
        }
    }

    private int getHashedKey(K key){
        return Math.abs(key.hashCode()%ARRAY_CAPACITY);
    }
}
