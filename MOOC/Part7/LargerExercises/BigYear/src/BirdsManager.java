import java.util.ArrayList;

public class BirdsManager {
    private ArrayList<Bird> birds;

    public BirdsManager() {
        birds = new ArrayList<>();
    }

    public void addBird(String name, String latinName) {
        Bird newBird = new Bird(name, latinName);
        birds.add(newBird);
    }

    public boolean addObservation(String birdName) {
        boolean found = false;
        for (Bird b : birds) {
            if (b.getName().equals(birdName)) {
                b.increaseObservation();
                found = true;
            }
        }
        return found;
    }

    public ArrayList<Bird> getAllBirds() {
        return birds;
    }

    public Bird getBird(String birdName) {
        Bird bird = null;
        for (Bird b : birds) {
            if (b.getName().equals(birdName)) {
                bird = b;
            }
        }
        return bird;
    }
}
