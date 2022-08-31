import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        values = new ArrayList[40];
        firstFreeIndex = 0;
    }

    public V get(K key) {
        int hashValue = Math.abs(key.hashCode()) % values.length;
        if (values[hashValue] == null) {
            return null;
        }

        ArrayList<Pair<K, V>> valuesAtIndex = values[hashValue];

        for (Pair<K, V> atIndex : valuesAtIndex) {
            if (atIndex.getKey().equals(key)) {
                return atIndex.getValue();
            }
        }
        return null;
    }

    public void add(K key, V value) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index > 0) {
            valuesAtIndex.get(index).setValue(value);
        } else {
            valuesAtIndex.add(new Pair<>(key, value));
        }

        if ((1.0 * firstFreeIndex) / values.length > 0.75) {
            grow();
        }
    }

    public V remove(K key) {
        ArrayList<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }

    private ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }

        return values[hashValue];
    }


    private int getIndexOfKey(ArrayList<Pair<K, V>> myList, K key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        // crete a new array
        ArrayList<Pair<K, V>>[] newValues = new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            // copy the values of the old array into the new one
            copy(newValues, i);
        }

        // replace the old array with the new one
        this.values = newValues;
    }

    private void copy(ArrayList<Pair<K, V>>[] newArray, int fromIdx) {
        for (int i = 0; i < this.values[fromIdx].size(); i++) {
            Pair<K, V> value = this.values[fromIdx].get(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }
}
