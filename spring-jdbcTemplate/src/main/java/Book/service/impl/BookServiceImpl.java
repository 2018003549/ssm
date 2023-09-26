package Book.service.impl;

import Book.dao.BookDao;
import Book.dao.impl.BookDaoImpl;
import Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao=new BookDaoImpl();
     @Override
     @Transactional(timeout = 5,noRollbackForClassName = "java.lang.ArithmeticException")
    public void buyBook(Integer bookId,Integer userId){
         try {
             TimeUnit.SECONDS.sleep(5);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         Integer price=bookDao.getPriceByBookId(bookId);//根据图书编号查询图书价格
        bookDao.updateStock(bookId);//更新图书库存
        bookDao.updateBalance(userId,price);
    }
}
