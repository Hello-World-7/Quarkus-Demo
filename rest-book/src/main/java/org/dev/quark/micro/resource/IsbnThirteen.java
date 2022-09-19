package org.dev.quark.micro.resource;

import javax.json.bind.annotation.JsonbProperty;

public class IsbnThirteen {
	
	@JsonbProperty("isbn_13")
	public String isbn13;

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	
}
