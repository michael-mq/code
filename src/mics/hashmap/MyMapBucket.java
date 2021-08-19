package mics.hashmap;

import java.util.LinkedList;
import java.util.List;

public class MyMapBucket {
    private List<MyKeyValueEntry> entries;

    public MyMapBucket() {
        entries = new LinkedList<>();
    }

    public List<MyKeyValueEntry> getEntries() {
        return entries;
    }

    public void addEntry(MyKeyValueEntry entry) {
        entries.add(entry);
    }

    public void removeEntry(MyKeyValueEntry entry) {
        entries.remove(entry);
    }
}
