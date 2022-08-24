public class PaymentTerminal {
    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals

    public PaymentTerminal() {
        money = 1000;
        affordableMeals = 0;
        heartyMeals = 0;
    }

    public double eatAffordably(double payment) {
        double mealPrice = 2.50;
        if (payment < mealPrice) {
            return payment;
        }
        money += mealPrice;
        affordableMeals++;
        return payment - mealPrice;
    }

    public double eatHeartily(double payment) {
        double mealPrice = 4.30;
        if (payment < mealPrice) {
            return payment;
        }
        money += mealPrice;
        heartyMeals++;
        return payment - mealPrice;
    }

    public boolean eatAffordably(PaymentCard card) {
        double mealPrice = 2.50;
        boolean haveCredit = card.takeMoney(mealPrice);
        if (!haveCredit) {
            return false;
        }
        affordableMeals++;
        return true;
    }

    public boolean eatHeartily(PaymentCard card) {
        double mealPrice = 4.30;
        boolean haveCredit = card.takeMoney(mealPrice);
        if (!haveCredit) {
            return false;
        }
        heartyMeals++;
        return true;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        card.addMoney(sum);
        money += sum;
    }

    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}