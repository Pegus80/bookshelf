package lv.tsi.javacourses.bookshelf.books.control;


import lv.tsi.javacourses.bookshelf.books.model.AuthorEntity;
import lv.tsi.javacourses.bookshelf.books.model.BookEntity;
import lv.tsi.javacourses.bookshelf.books.model.PublisherEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PublisherDAO {


    @PersistenceContext
    private EntityManager em;



    public List<PublisherEntity> getAllPublishers() {
        return em.createQuery("select b from Publisher b", PublisherEntity.class)
                .getResultList();
    }


    public List<PublisherEntity> getPublishersByPage(int currentPage, int recordsOnPage) {
        return  em.createQuery("select b from Publisher b", PublisherEntity.class)
                .setFirstResult((currentPage-1) * recordsOnPage)
                .setMaxResults(recordsOnPage)
                .getResultList();
    }


    public int getPublishersTotalPages(int recordsOnPage) {
        //TODO Лучше заминить на облегченный запрос, когда запрашивается только кольчество записей без обьектов
        int a =em.createQuery("select b from Publisher b", PublisherEntity.class).getResultList().size();

        return (int) Math.ceil(((float) a / recordsOnPage));

    }

    public PublisherEntity getPublisher (Long id) {
        return em.find(PublisherEntity.class, id);
    }


    public PublisherEntity updatePublisher (PublisherEntity publisherEntity) {
       return (PublisherEntity)em.merge(publisherEntity);
    }

    public void deletePublisher (PublisherEntity publisherEntity) {
        em.remove(em.merge(publisherEntity));

    }


}
