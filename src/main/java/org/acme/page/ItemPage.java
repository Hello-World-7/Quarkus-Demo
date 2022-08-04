package org.acme.page;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.acme.model.Book;
import org.acme.repo.BookRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/page")
@Produces({MediaType.TEXT_HTML})
public class ItemPage {


    @Inject
    private BookRepo bookRepo;

    @CheckedTemplate
    public static class Templates{
        public static  native TemplateInstance book(Book book);
        public static  native TemplateInstance books(List<Book> books);
    }

    @GET
    public TemplateInstance getBook(){
        return Templates.book(bookRepo.getById());
    }

    @GET
    @Path("/all")
    public TemplateInstance getBooks(){
        return Templates.books(bookRepo.getAllBooks());
    }
}
