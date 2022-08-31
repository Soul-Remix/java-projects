public class List<T> {
    private T[] values;
    private int firstFreeIndex;

    public List() {
        values = (T[]) new Object[10];
        firstFreeIndex = 0;
    }

    public void add(T value) {
        if (firstFreeIndex == values.length) {
            this.grow();
        }
        values[firstFreeIndex] = value;
        firstFreeIndex++;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public void remove(T value) {
        int index = indexOf(value);
        if (index == -1) {
            return;
        }
        moveToTheLeft(index);
        firstFreeIndex--;
    }

    public T value(int index) {
        if (index < 0 || index >= firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[index];
    }

    public int size() {
        return firstFreeIndex;
    }

    public int indexOf(T value) {
        int index = -1;
        for (int i = 0; i < firstFreeIndex; i++) {
            if (values[i] == value || values[i].equals(value)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    private void grow() {
        int newSize = values.length + values.length / 2;
        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < firstFreeIndex; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }
}
