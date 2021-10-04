/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Arrays;

/**
 *
 * @author pupil
 */
public class Book {
    private String caption;
    private Author[] author;
    private int publishedYear;
    public Book() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Author[] getAutor() {
        return author;
    }

    public void setAutor(Author[] autor) {
        this.author = autor;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" 
                + "caption=" + caption 
                + ",\n autor=" + Arrays.toString(author)
                + ",\n publishedYear=" + publishedYear 
                + "\n}";
    }
    
    
}
