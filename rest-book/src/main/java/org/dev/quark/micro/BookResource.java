package org.dev.quark.micro;

import java.time.Instant;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dev.quark.micro.proxy.NumberProxy;
import org.dev.quark.micro.resource.Book;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/api/books")
public class BookResource {
	
	@Inject
	@RestClient
	NumberProxy numberProxy;
	
	@Inject
	Logger logger;
	
	
    @Retry(maxRetries = 3,delay = 3000)
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Fallback(fallbackMethod = "fallingbackOncreateABook")
    public Response createABook(@FormParam("title") String title,
    		@FormParam("author") String author,@FormParam("yearOfPublication") int yearOfPublication,
    		@FormParam("genre") String genre) {
    	Book book = new Book();
    	book.setTitle(title);
    	book.setAuthor(author);
    	book.setYearOfPublication(yearOfPublication);
    	book.setGenre(genre);
    	book.setCreationDate(Instant.now());
    	book.setIsbn13(numberProxy.generateIsbnNumbers().isbn13);
    	logger.info("Created book"+ book);
    	return Response.status(201).entity(book).build();
    }
   
    
    public Response fallingbackOncreateABook(String title, String author, int yearOfPublication,
    		String genre) {
    	Book book = new Book();
    	book.setTitle(title);
    	book.setAuthor(author);
    	book.setYearOfPublication(yearOfPublication);
    	book.setGenre(genre);
    	book.setCreationDate(Instant.now());
    	book.setIsbn13("Will be set later");
    	saveBook(book);
    	logger.warn("Book saved = "+ book);
    	return Response.status(206).entity(book).build();
    }
    
    private void saveBook(Book book) {
    	String bookJson = JsonbBuilder.create().toJson(book);
    	logger.info("Book saved in disk via json"+ bookJson);
	}
}