package Library.entities;


import Library.entities.Book;

import javax.persistence.*;

@Entity
public class Page {

    @Id
    @GeneratedValue
    private int id;

    private int page_number;

    private String text;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public Page(int page_number, String text, Book book) {
        this.page_number = page_number;
        this.text = text;
        this.book = book;
    }

    public Page() {
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return page_number + ": " + text;
    }
}
