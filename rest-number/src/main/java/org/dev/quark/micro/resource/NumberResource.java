package org.dev.quark.micro.resource;

import java.time.Instant;
import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dev.quark.micro.IsbnNumbers;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

@Path("/api/numbers")
@Tag(name="Number REST Endpoint")
public class NumberResource {
	
	@Inject
	Logger logger;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary="Generates book numbers",
			description="ISBN13 and ISBN10 numbers")
	public IsbnNumbers generateIsbnNumbers() {
		IsbnNumbers isbnNumbers = new IsbnNumbers();
		isbnNumbers.isbn13 = "13-"+ new Random().nextInt(100_000_000);
		isbnNumbers.isbn10 = "10-"+ new Random().nextInt(100_000);
		isbnNumbers.generationDate = Instant.now();
		logger.info("Numbers generated" + isbnNumbers);
		return isbnNumbers;
	}
}
