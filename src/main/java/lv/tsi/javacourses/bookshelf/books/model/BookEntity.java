package lv.tsi.javacourses.bookshelf.books.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Book")
@Table(name = "books")
public class BookEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Column(name = "title", length = 500, nullable = false)
    private String title;
    @NotBlank
    @Column(name = "isbn", length = 50, nullable = false)
    private String isbn;
    @Digits(integer = 4, fraction = 0)
    @Column(name = "year", nullable = false)
    private int year;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorEntity author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return year == that.year &&
                Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, year, author);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                '}';
    }
}
