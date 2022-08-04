package org.acme.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int id;
    private String name;
    private int year;

    public Book(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
