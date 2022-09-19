package org.dev.quark.micro.resource;

import java.time.Instant;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

public class Book {
	
	@JsonbProperty("isbn_13")
	public String isbn13;
	
	
	public String title;
	
	public String author;
	
	@JsonbProperty("year_of_publication")
	public int yearOfPublication;
	
	public String genre;
	
	@JsonbDateFormat("dd-MM-YYYY")
	@JsonbProperty("creation_date")
	public Instant creationDate;	
	
	public String getIsbn13() {
		return isbn13;
	}
	
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Instant getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Book [isbn13=" + isbn13 + ", title=" + title + ", author=" + author + ", yearOfPublication="
				+ yearOfPublication + ", genre=" + genre + ", creationDate=" + creationDate + "]";
	}
	
		
	
		
}
