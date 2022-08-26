import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private ArrayList<String> owners;
    private final HashMap<LicensePlate, String> licensePlates;

    public VehicleRegistry() {
        owners = new ArrayList<>();
        licensePlates = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.licensePlates.containsKey(licensePlate)) {
            return false;
        }
        this.licensePlates.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        return this.licensePlates.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (!this.licensePlates.containsKey(licensePlate)) {
            return false;
        }
        this.licensePlates.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        for (LicensePlate lp : licensePlates.keySet()) {
            System.out.println(lp);
        }
    }

    public void printOwners() {
        for (String owner : licensePlates.values()) {
            if (!owners.contains(owner)) {
                owners.add(owner);
                System.out.println(owner);
            }
        }
    }
}
