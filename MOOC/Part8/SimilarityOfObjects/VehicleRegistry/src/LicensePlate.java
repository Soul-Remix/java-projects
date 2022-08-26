import java.util.Objects;

public class LicensePlate {
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LicensePlate licensePlate = (LicensePlate) object;
        return liNumber.equals(licensePlate.liNumber) && country.equals(licensePlate.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liNumber, country);
    }
}
