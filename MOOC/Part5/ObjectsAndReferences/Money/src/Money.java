public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    public Money plus(Money addition) {
        return new Money(this.euros + addition.euros,this.cents + addition.cents);
    }

    public Money minus(Money decreaser){
        int newEuros = this.euros - decreaser.euros;
        if(newEuros < 0) {
            newEuros = 0;
            return new Money(newEuros,0);
        }

        int newCents = this.cents - decreaser.cents;
        if(newCents < 0) {
            newCents = 100 + newCents;
            newEuros--;
        }

        return new Money(newEuros,newCents);
    }

    public boolean lessThan(Money compared) {
        if(this.euros < compared.euros) {
            return true;
        }
        if(this.cents < compared.cents) {
            return true;
        }
        return false;
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
}