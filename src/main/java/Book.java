
public class Book {

    private  int id;
    private String title;
    private String autor;
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
