package org.osama.services;

import org.osama.dao.BookDao;
import org.osama.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Transactional
    @Override
    public List<Book> getBooks() {
        return bookDao.getBooks();
    }
    @Transactional
    @Override
    public void saveBook(Book book) {
         bookDao.saveBook(book);
    }
    @Transactional
    @Override
    public void updateBook(Book book) {
       bookDao.updateBook(book);
    }
    @Transactional
    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }
    @Transactional
    @Override
    public Book findBookById(int id) {
        return bookDao.findBookById(id);
    }
}
