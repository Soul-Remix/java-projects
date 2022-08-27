import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item itemToAdd= new Item(product, 1, price);
        if(items.contains(itemToAdd)) {
            int index = items.indexOf(itemToAdd);
            items.get(index).increaseQuantity();
        }else {
            items.add(itemToAdd);
        }
    }

    public int price() {
        int totalPrice = 0;
        for (Item i : items) {
            totalPrice += i.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item i : items) {
            System.out.println(i.name() + ": " + i.qty());
        }
    }
}
