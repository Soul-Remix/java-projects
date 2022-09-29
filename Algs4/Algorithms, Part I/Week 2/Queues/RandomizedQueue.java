import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int lastIndex = 0;
    private int itemsCount = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return itemsCount;
    }

    // add the item
    public void enqueue(Item item) {
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

    // remove and return a random item
    public Item dequeue() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        if (itemsCount > 0 && lastIndex == queue.length / 4) {
            resize(queue.length / 2);
        }
        int randIndex = StdRandom.uniformInt(0, itemsCount);
        Item item = queue[randIndex];
        queue[randIndex] = queue[itemsCount - 1];
        queue[itemsCount - 1] = null;
        itemsCount--;
        lastIndex--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (itemsCount == 0) {
            throw new NoSuchElementException();
        }
        int rand = StdRandom.uniformInt(0, itemsCount);
        return queue[rand];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private int index = 0;
        private Item[] randQueue;

        public RandomIterator() {
            randQueue = (Item[]) new Object[queue.length];
            for (int i = 0; i < itemsCount; i++) {
                randQueue[i] = queue[i];
            }
            rand();
        }

        public boolean hasNext() {
            return index < itemsCount;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return randQueue[index++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void rand() {
            for (int i = itemsCount - 1; i > 0; i--) {

                // Pick a random index from 0 to i
                int j = StdRandom.uniformInt(0, i);

                // Swap array[i] with the element at random index
                Item temp = randQueue[i];
                randQueue[i] = randQueue[j];
                randQueue[j] = temp;
            }
        }
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
        RandomizedQueue<Integer> rQueue = new RandomizedQueue<>();
        rQueue.enqueue(1);
        rQueue.enqueue(2);
        rQueue.enqueue(3);
        rQueue.enqueue(4);
        rQueue.enqueue(5);
    }

}