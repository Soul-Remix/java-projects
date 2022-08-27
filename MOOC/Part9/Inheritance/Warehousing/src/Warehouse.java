public class Warehouse {
    private double capacity;
    private double balance;

    public Warehouse(double capacity) {
        this.capacity = capacity > 0 ? capacity : 0;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getCapacity() {
        return capacity;
    }

    public double howMuchSpaceLeft() {
        return capacity - balance;
    }

    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }

        if (balance + amount > capacity) {
            balance = capacity;
        } else {
            balance += amount;
        }
    }

    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0.0;
        }

        if (balance - amount < 0) {
            balance = 0;
        } else {
            balance -= amount;
        }
        return amount;
    }

    public String toString() {
        return "balance = " + balance + ", space left " + howMuchSpaceLeft();
    }
}
