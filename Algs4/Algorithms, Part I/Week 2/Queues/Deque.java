import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Item[] queue;
    private int firstIndex = 0;
    private int lastIndex = 0;
    private int itemsCount = 0;

    // construct an empty deque
    public Deque() {
        queue = (Item[]) new Object[1];
    }

    // is the deque empty?
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    // return the number of items on the deque
    public int size() {
        return itemsCount;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (lastIndex == queue.length) {
            resize(queue.length * 2);
        }
        queue[lastIndex] = item;
        lastIndex++;
        itemsCount++;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        if (itemsCount > 0 && lastIndex == queue.length / 4) {
            resize(queue.length / 2);
        }
        Item item = queue[lastIndex];
        queue[--lastIndex] = null;
        itemsCount--;
        return item;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (firstIndex == 0) {
            resizeFirst(queue.length * 2);
        }
        firstIndex--;
        queue[firstIndex] = item;
        itemsCount++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        Item item = queue[firstIndex];
        queue[firstIndex] = null;
        firstIndex++;
        itemsCount--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private int index = firstIndex;

        public boolean hasNext() {
            return index < lastIndex;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return queue[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resizeFirst(int newSize) {
        Item[] newQueue = (Item[]) new Object[newSize];
        firstIndex = newSize / 2;
        lastIndex += firstIndex;
        int j = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            newQueue[i] = queue[j++];
        }
        queue = newQueue;
    }

    private void resize(int newSize) {
        Item[] newQueue = (Item[]) new Object[newSize];
        for (int i = 0; i < lastIndex; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(4);
        deque.removeFirst();
        deque.removeFirst();
        deque.addLast(1);
        deque.addFirst(4);
        deque.addFirst(4);
        for (int i : deque) {
            StdOut.println(i);
        }
    }
}
