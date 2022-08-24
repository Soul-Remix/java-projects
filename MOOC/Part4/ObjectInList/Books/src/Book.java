public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String bookTitle, int numPages, int publishYear) {

        title = bookTitle;
        pages = numPages;
        year = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + ", " + pages + " pages, " + year;
    }
}
