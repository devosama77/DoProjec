package org.osama.dao;

import org.hibernate.SessionFactory;
import org.osama.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Book> getBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.getResultList();
    }
    @Override
    public void saveBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
    }

    @Override
    public void deleteBook(int id) {
        Book book = sessionFactory.getCurrentSession().get(Book.class, id);
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    public Book findBookById(int id) {
        Book book=sessionFactory.getCurrentSession().get(Book.class,id);
        return book;
    }
}
