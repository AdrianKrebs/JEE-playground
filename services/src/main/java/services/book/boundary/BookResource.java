package services.book.boundary;


import services.book.control.PaginatedListWrapper;
import services.book.data.Person;
import services.book.data.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
        System.out.println("trorlsdfsdeoel");
        System.out.println("this isd a test");
        System.out.println("work mof of");
        System.out.println("lick my ass");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Book> findBooks(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT b FROM Book b ORDER BY b." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        System.out.println("work jrebel, work!!!!");
        return query.getResultList();
    }

    private PaginatedListWrapper findBooks(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countBooks());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findBooks(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listBooks(@DefaultValue("1")
                                            @QueryParam("page")
                                            Integer page,
                                          @DefaultValue("isbn")
                                            @QueryParam("sortFields")
                                            String sortFields,
                                          @DefaultValue("asc")
                                            @QueryParam("sortDirections")
                                            String sortDirections) {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findBooks(paginatedListWrapper);
    }

    @GET
    @Path("{isbn}")
    public Book getBook(@PathParam("isbn") Long id) {
        return new Book();
    }

    @GET
    @Path("/getBooks")
    public Book getBook() {
        return new Book();
    }

    @POST
    public Book saveBook(Book book) {
        if (book.getIsbn() == 0){
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
