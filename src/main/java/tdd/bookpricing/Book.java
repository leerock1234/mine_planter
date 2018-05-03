package tdd.bookpricing;

public class Book {
    String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object obj) {
        return this.bookName.equals(((Book) obj).bookName);
    }

    @Override
    public int hashCode() {
        return bookName.hashCode();
    }
}
