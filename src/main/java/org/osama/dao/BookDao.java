package org.osama.dao;

import org.osama.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getBooks();
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);
    public Book findBookById(int id);
}
