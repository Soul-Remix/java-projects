public class Item {

    private String product;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {

        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String name() {
        return product;
    }

    public int price() {
        return unitPrice * qty;
    }

    public int qty() {
        return qty;
    }

    public void increaseQuantity() {
        qty++;
    }

    public String toString() {
        return product + ": " + unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Item)) {
            return false;
        }

        Item item = (Item) obj;

        return item.name().equals(this.name());
    }
}
