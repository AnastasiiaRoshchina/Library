package entity;

import entity.Author;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Melnikov
 */
public class Book implements Serializable{
    private String caption;
    private List<Author> author;
    private int publishedYear;
    
    public Book() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
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
                + ",\n author=" + Arrays.toString(author.toArray())
                + ",\n publishedYear=" + publishedYear 
                + "\n}";
    }
    
    
}