package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.model.BookEntity;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class BooksBean implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private List<BookEntity> books;
    private int page;

    
//    Ограничение по количкству загружаемых записей из БД
//    и реализация отображения по станицам
    public void loadBooks() {
        books = em.createQuery("select b from Book b", BookEntity.class)
                .setFirstResult(page * 100)
                .setMaxResults(100)
                .getResultList();
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
