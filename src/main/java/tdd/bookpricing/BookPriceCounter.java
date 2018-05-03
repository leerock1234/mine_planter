package tdd.bookpricing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BookPriceCounter {
    private final static int UNIT_PRICE = 8;
    static double DISCOUNT_5_PERCENT = 5 / 100d;
    static double DISCOUNT_10_PERCENT = 10 / 100d;
    static double DISCOUNT_20_PERCENT = 20 / 100d;
    static double DISCOUNT_25_PERCENT = 25 / 100d;

    public static double pricing(List<Book> books) {
        double totalPrice = 0;

        for (Iterator<Book> iterator = books.iterator();iterator.hasNext();iterator = books.iterator()) {
            Book book1 = iterator.next();
            iterator.remove();
            Set<Book> booksSet = new HashSet<Book>();
            booksSet.add(book1);
            Iterator<Book> iterator2 = books.iterator();
            while (iterator2.hasNext()) {
                Book book = iterator2.next();
                if (!booksSet.contains(book)) {
                    booksSet.add(book);
                    iterator2.remove();
                }
            }
            totalPrice += cal(booksSet);
        }

        return totalPrice;
    }

    public static double pricing2(List<Book> books) {
        double totalPrice = 0;
        while (books.size() > 0) {
            Book book1 = books.get(0);
            books.remove(0);
            Set<Book> booksSet = new HashSet<Book>();
            booksSet.add(book1);
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                if (!booksSet.contains(book)) {
                    booksSet.add(book);
                    books.remove(i);
                    i--;
                }
            }
            totalPrice += cal(booksSet);
        }

        return totalPrice;
    }

    private static double cal(Set<Book> booksSet) {
        double discount = 0;
        if (booksSet.size() == 2) {
            discount = DISCOUNT_5_PERCENT;
        } else if (booksSet.size() == 3) {
            discount = DISCOUNT_10_PERCENT;
        } else if (booksSet.size() == 4) {
            discount = DISCOUNT_20_PERCENT;
        } else if (booksSet.size() == 5) {
            discount = DISCOUNT_25_PERCENT;
        }
        return UNIT_PRICE * booksSet.size() * (1 - discount);
    }
}
