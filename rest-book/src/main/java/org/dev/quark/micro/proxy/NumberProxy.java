package org.dev.quark.micro.proxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dev.quark.micro.resource.IsbnThirteen;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;



@RegisterRestClient
@Path("/api/numbers")
public interface NumberProxy {
	


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary="Generates book numbers",
			description="ISBN13 and ISBN10 numbers")
	IsbnThirteen generateIsbnNumbers();
}
