package org.dev.quark.micro;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@ApplicationPath("/")
@OpenAPIDefinition(
		info=@Info(
				title="Number Microservice",
				description="This micro generates books number", 
				version="1.0",
				contact=@Contact(name="rsattar", url="somerandom.ww.com")),
		externalDocs = @ExternalDocumentation(url="http://github.com", description="All code"),
		tags = {
				@Tag(name="api", description="Public Api that can be used"),
				@Tag(name="numbers", description="Anybody interested"),
		}
)
public class NumberMicroservice extends Application {

}
