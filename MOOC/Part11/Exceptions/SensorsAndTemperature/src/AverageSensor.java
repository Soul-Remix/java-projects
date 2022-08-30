import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private final ArrayList<Sensor> sensors;
    private final ArrayList<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean everySensorOn = true;
        return sensors.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (sensors.size() == 0) {
            throw new IllegalStateException();
        }
        int avg = (int) sensors.stream().mapToInt(Sensor::read).average().getAsDouble();
        readings.add(avg);
        return avg;
    }

    public List<Integer> readings() {
        return readings;
    }
}
