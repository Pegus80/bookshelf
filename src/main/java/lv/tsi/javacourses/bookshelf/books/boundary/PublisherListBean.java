package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.control.PublisherDAO;
import lv.tsi.javacourses.bookshelf.books.model.AuthorEntity;
import lv.tsi.javacourses.bookshelf.books.model.PublisherEntity;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class PublisherListBean  implements Serializable {

    @Inject
    private PublisherDAO publisherDAO;

    private List<PublisherEntity> allPublishers;


    public List<PublisherEntity> getAllPublishers() {

        return allPublishers = publisherDAO.getAllPublishers();
    }


}
