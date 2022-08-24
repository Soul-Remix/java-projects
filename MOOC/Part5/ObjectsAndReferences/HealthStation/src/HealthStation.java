public class HealthStation {
    private int weighingsCount;

    public int weigh(Person person) {
        weighingsCount++;
        return person.getWeight();
    }

    public void feed(Person person) {
        int currentWeight = person.getWeight();
        person.setWeight(currentWeight + 1);
    }

    public int weighings() {
        return weighingsCount;
    }
}
