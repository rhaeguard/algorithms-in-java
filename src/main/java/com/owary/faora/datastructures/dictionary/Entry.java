package com.owary.faora.datastructures.dictionary;

public class Entry<K, V>{

    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(){}

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K key() {
        return key;
    }

    public V value() {
        return value;
    }

    public Entry<K, V> next(){
        return next;
    }

    public void next(Entry<K, V> entry){
        this.next = entry;
    }

    public boolean hasNext(){
        return this.next()!=null;
    }

    @Override
    public String toString() {
        String str = key+" [ (" + value + ") -> ";
        Entry<K, V> tmp = this;
        while(tmp.hasNext()){
            str+="("+tmp.next().value()
                    + ") -> ";
            tmp = tmp.next();
        }
        str = str.substring(0, str.length()-4);
        str+=") ]";
        return str;
    }

}
