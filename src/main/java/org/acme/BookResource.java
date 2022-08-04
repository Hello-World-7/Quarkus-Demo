package org.acme;


import org.acme.model.Book;
import org.acme.repo.BookRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import java.util.List;

@Path("/books")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class BookResource {

    @Inject
    private BookRepo bookRepo;

    @GET
    @Path("/all")
    public List<Book> allBooks(){
        return bookRepo.getAllBooks();
    }


    @GET
    @Path("/single")
    public Book getBook(){
        return bookRepo.getById();
    }

    @GET
    @Path("/conf")
    public Book getConfBook(){
        return bookRepo.bookFromConfig();
    }
}
