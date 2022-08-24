public class PaymentCard {
    private double balance;

    public PaymentCard(double openingSum) {
        balance = openingSum;
    }

    public void addMoney(double amount) {
        if(amount <= 0) {
            return;
        }
        double newBalance = balance + amount;
        if(newBalance > 150) {
            balance = 150;
        }else {
            balance = newBalance;
        }
    }

    public void eatAffordably() {
        double newBalance = balance - 2.60;
        if (newBalance > 0) {
            balance = newBalance;
        }
    }

    public void eatHeartily() {
        double newBalance = balance - 4.60;
        if (newBalance > 0) {
            balance = newBalance;
        }
    }

    public String toString() {
        return "The card has a balance of " + balance + " euros";
    }
}
