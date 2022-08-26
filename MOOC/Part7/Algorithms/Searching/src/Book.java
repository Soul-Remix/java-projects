public class Book {
    private int id;
    private String name;

    public Book(int Id, String bookName) {
        id = Id;
        name = bookName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
