package services.book.boundary;

import services.book.data.Person;
import services.book.data.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST Service to expose the data to display in the UI grid.
 *
 * @author Roberto Cortez
 */
@Stateless
@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource extends AbstractFacade<Book> {
    @PersistenceContext
    private EntityManager entityManager;

    public BookResource() {
        super(Book.class);
    }

    private Integer countBooks() {
        Query query = entityManager.createQuery("SELECT COUNT(b.isbn) FROM Book b");
        return ((Long) query.getSingleResult()).intValue();
    }

    private List<Book> findBooks(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query = entityManager.createQuery("SELECT b FROM Book b ORDER BY b." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    @GET
    @Path("{isbn}")
    public Book getBook(@PathParam("isbn") Long id) {
        return new Book();
    }

    @GET
    @Path("/getBooks")
    public Response getBook() {
        return Response.ok().build();
    }

    @POST
    public Book saveBook(Book book) {
        if (book.getIsbn() == 0) {
            Person personToSave = new Person();
            personToSave.setName(book.getName());
            personToSave.setDescription(book.getDescription());
            entityManager.persist(book);
        } else {
            Book bookToUpdate = getBook(book.getIsbn());
            bookToUpdate.setName(book.getName());
            bookToUpdate.setDescription(book.getDescription());

            book = entityManager.merge(bookToUpdate);
        }

        return book;
    }

    @DELETE
    @Path("{id}")
    public void deletePerson(@PathParam("id") Long id) {
        entityManager.remove(getBook(id));
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
