package Book.dao;

import Book.pojo.Book;
import Book.pojo.User;

public interface BookDao {
    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId,Integer price);
}
