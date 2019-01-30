package org.osama.services;

import org.osama.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);
    public Book findBookById(int id);
}
