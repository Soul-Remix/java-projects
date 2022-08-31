public class Hideout<T> {
    private T item;

    public void putIntoHideout(T toHide) {
        item = toHide;
    }

    public T takeFromHideout() {
        T itemToTake = item;
        item = null;
        return itemToTake;
    }

    public boolean isInHideout() {
        return item != null;
    }
}
