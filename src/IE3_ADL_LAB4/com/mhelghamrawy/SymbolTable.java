package IE3_ADL_LAB4.com.mhelghamrawy;

import java.util.Iterator;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    abstract void put(Key key, Value val);
    abstract Value get(Key key);
    abstract Iterator<Key> iterator();

    default boolean contains(Key key) {
        return (get(key) != null);
    }
}
