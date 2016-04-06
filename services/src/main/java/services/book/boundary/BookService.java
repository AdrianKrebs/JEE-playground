package services.book.boundary;

import services.book.data.Book;
import services.book.data.Person;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by U116523 on 06.04.2016.
 */
@Stateless
@LocalBean
public class BookService extends  AbstractFacade<Book> {

    @PersistenceContext
    EntityManager entityManager;


    public BookService() {
        super(Book.class);
    }


    public Book saveBook(Book book) {
        if (book.getIsbn() == 0) {
            Person personToSave = new Person();
            personToSave.setName(book.getName());
            personToSave.setDescription(book.getDescription());
            entityManager.persist(book);
        } else {
            Book bookToUpdate = find(book.getIsbn());
            bookToUpdate.setName(book.getName());
            bookToUpdate.setDescription(book.getDescription());
            book = entityManager.merge(bookToUpdate);
        }

        return book;
    }



    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
