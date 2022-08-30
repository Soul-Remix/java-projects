public class Book {
    private String name;
    private int publishingYear;
    private int pageCount;
    private String author;

    public Book(String name, int publishingYear, int pageCount, String author) {

        this.name = name;
        this.publishingYear = publishingYear;
        this.pageCount = pageCount;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }
}
