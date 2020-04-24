package lv.tsi.javacourses.bookshelf.books.boundary;


import lv.tsi.javacourses.bookshelf.books.control.PublisherDAO;
import lv.tsi.javacourses.bookshelf.books.model.PublisherEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Named
@ViewScoped
public class PublisherBean implements Serializable {

    @Inject
    private PublisherDAO publisherDAO;

    private long id;
    private PublisherEntity publisherEntity;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public PublisherEntity getPublisherEntity() {
        return publisherEntity;
    }

    public void findPublisher() {
        publisherEntity = publisherDAO.getPublisher(id);

        if (publisherEntity==null) {
            publisherEntity = new PublisherEntity();
        }
    }

    public void savePublisher() {
        publisherEntity=publisherDAO.updatePublisher(publisherEntity);
    }

    public void deletePublisher() {
        publisherDAO.deletePublisher(publisherEntity);
        publisherEntity =null;
    }

}
