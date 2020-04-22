package lv.tsi.javacourses.bookshelf.books.control;

import lv.tsi.javacourses.bookshelf.books.model.AuthorEntity;
import lv.tsi.javacourses.bookshelf.books.model.BookEntity;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorDAO {
    @PersistenceContext
    private EntityManager em;

    public List<AuthorEntity> getAllAuthors() {
        return em.createQuery("select b from Author b", AuthorEntity.class)
                .getResultList();
    }

    public AuthorEntity getAuthorById(long id) {
        return em.find(AuthorEntity.class, id);
    }

    public AuthorEntity update(AuthorEntity author) {
        var tmp = em.merge(author);
        return tmp;
    }

    public void create(AuthorEntity author) {
        em.persist(author);
    }
}


