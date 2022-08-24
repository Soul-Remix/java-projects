public class Archive {
    private String id;
    private String name;

    public Archive(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + ": " + name;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Archive)) {
            return false;
        }

        Archive comapredCasted = (Archive) compared;

        return this.id.equals(comapredCasted.id);
    }
}
