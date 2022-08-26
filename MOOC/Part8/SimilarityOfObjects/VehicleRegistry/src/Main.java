public class Main {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();
        LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FI", "UXE-465");
        LicensePlate li3 = new LicensePlate("D", "B WQ-431");

        registry.add(li1, "name1");
        registry.add(li2, "name2");
        registry.add(li3, "name1");

        registry.printLicensePlates();
        System.out.println(" --- ");
        registry.printOwners();
    }
}