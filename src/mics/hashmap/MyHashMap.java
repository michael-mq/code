package mics.hashmap;

public class MyHashMap<K, V> {
    private MyMapBucket[] bucket;
    private int capacity;
    private int size;

    public MyHashMap() {
        this(1 << 4);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        bucket = new MyMapBucket[capacity];
        size = 0;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);

        return bucket[hash] != null && getEntry(key) != null;
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            MyKeyValueEntry myKeyValueEntry = getEntry(key);
            myKeyValueEntry.setValue(value);
        } else {
            int hash = getHash(key);

            if (bucket[hash] == null) {
                bucket[hash] = new MyMapBucket();
            }

            bucket[hash].addEntry(new MyKeyValueEntry(key, value));

            size++;
        }
    }

    public V get(K key) {
        if (containsKey(key)) {
            return (V) getEntry(key).getValue();
        }

        return null;
    }

    public void remove(K key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));

            size--;
        }
    }

    public int size() {
        return size;
    }

    private MyKeyValueEntry getEntry(K key) {
        int hash = getHash(key);

        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
            MyKeyValueEntry myKeyValueEntry = bucket[hash].getEntries().get(i);

            if (myKeyValueEntry.getKey().equals(key)) {
                return myKeyValueEntry;
            }
        }

        return null;
    }

    private int getHash(K key) {
        return key.hashCode() % capacity;
    }


}
