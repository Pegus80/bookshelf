package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.Other.PagingBean;
import lv.tsi.javacourses.bookshelf.books.control.PublisherDAO;
import lv.tsi.javacourses.bookshelf.books.model.PublisherEntity;

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
    @Inject
    private PagingBean pagingBean;

    public void prepareView() {

        var recordsCount = publisherDAO.getPublishersCount();
        pagingBean.preparePaging(recordsCount, 5, 3);

    }


  public List<PublisherEntity> getPublishersByPage() {
        var from = pagingBean.getCurrentPage();
        var to = pagingBean.getRecordsOnPage();

        return publisherDAO.getPublishers(from, to);

    }


}
