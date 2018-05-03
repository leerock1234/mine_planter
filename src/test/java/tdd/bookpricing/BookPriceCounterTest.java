package tdd.bookpricing;

import org.junit.Test;
import tdd.bookpricing.Book;
import tdd.bookpricing.BookPriceCounter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookPriceCounterTest {
    @Test
    public void should_be_0_when_no_buying() {
        List<Book> books = new ArrayList<Book>();
        double price = BookPriceCounter.pricing(books);
        assertEquals(0d, price, 0.0001d);
    }

    @Test
    public void should_be_8_when_buy_one_book() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("A");
        books.add(book);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8d, price, 0.0001d);
    }

    @Test
    public void should_pricing_with_discount_when_buy_2_diff_book() {
//        Book book1 = new Book();
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("B");
        books.add(book1);
        books.add(book2);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 2 * (1 - 5 / 100d), price, 0.0001d);
    }

    @Test
    public void should_pricing_no_discount_when_buy_2_same_book() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("A");
        books.add(book1);
        books.add(book2);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 2, price, 0.0001d);
    }


    @Test
    public void should_pricing_with_discount_when_buy_3_diff_book() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("B");
        Book book3 = new Book("C");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 3 * (1 - 10 / 100d), price, 0.0001d);
    }

    @Test
    public void should_pricing_with_discount_when_buy_2_diff_book_and_one_same() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("B");
        Book book3 = new Book("A");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 2 * (1 - 5 / 100d) + 8, price, 0.0001d);
    }

    @Test
    public void should_pricing_no_discount_when_buy_3_same_book() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("A");
        Book book3 = new Book("A");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 3, price, 0.0001d);
    }

    @Test
    public void should_pricing_no_discount_when_buy_4_same_book() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("A");
        Book book3 = new Book("A");
        Book book4 = new Book("A");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 4, price, 0.0001d);
    }

    @Test
    public void should_pricing_with_discount_when_buy_1_book_diff_among_4() {
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book("A");
        Book book2 = new Book("B");
        Book book3 = new Book("A");
        Book book4 = new Book("A");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        double price = BookPriceCounter.pricing(books);
        assertEquals(8 * 2 * (1 - 5 / 100d) + 8 * 2, price, 0.0001d);
    }
}
