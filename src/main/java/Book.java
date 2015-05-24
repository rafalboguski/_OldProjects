import javax.persistence.*;

@Entity
@Table(name ="Book")

public class Book {

    @Id @GeneratedValue
    @Column(name ="id")
    private  int id;

    @Column(name = "title")
    private String title;

    @Column(name = "autor")
    private String autor;

    @Column(name = "number_of_pages")
    private int pages;


    public Book(String title,  String autor ,int pages) {
        this.title = title;
        this.pages = pages;
        this.autor = autor;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
