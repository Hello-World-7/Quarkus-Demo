package org.acme.repo;

import org.acme.model.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class BookRepo {

    @ConfigProperty(name="books.name")
    String name;

    @ConfigProperty(name="books.year")
    int year;

    @ConfigProperty(name="books.id", defaultValue = "25")
    int id;

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1,"Hello Benjamin", 2022),
                new Book(2, "Dummy monkey", 2019)
        );
    }

    public Book getById(){
        return new Book(3, "Don't die", 2001);
    }

    public Book bookFromConfig(){
        return new Book(Integer.valueOf(id), name,year);
    }
}
