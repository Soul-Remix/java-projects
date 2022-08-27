import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private final HashMap<String, ArrayList<String>> storages;

    public StorageFacility() {
        storages = new HashMap<>();
    }

    public void add(String unit, String item) {
        storages.putIfAbsent(unit, new ArrayList<>());
        storages.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return storages.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> items = storages.get(storageUnit);
        items.remove(item);
        if (items.size() == 0) {
            storages.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        return new ArrayList<>(storages.keySet());
    }
}
