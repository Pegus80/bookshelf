package lv.tsi.javacourses.bookshelf.books.boundary;

import lv.tsi.javacourses.bookshelf.books.control.PublisherDAO;
import lv.tsi.javacourses.bookshelf.books.model.PublisherEntity;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class PublisherListBean  implements Serializable {

    @Inject
    private PublisherDAO publisherDAO;

    private Integer currentPage;
    private int pageCount;
    private int recordsOnPage = 5;


    public List<PublisherEntity> getPublishersByPage() {

        if (currentPage == null) {
            currentPage = 1;
        }

        pageCount=publisherDAO.getPublishersTotalPages(recordsOnPage);

        return publisherDAO.getPublishersByPage(currentPage, recordsOnPage);

    }


    public Integer getPreviousPage() {
        if (currentPage > 1) {
            return currentPage - 1;
        } else {
            return 1;
        }


    }

    public Integer getNextPage() {

        if (currentPage < pageCount) {
            return currentPage + 1;
        } else {
            return currentPage;
        }
    }


    public Integer getCurrentPage() {
        return currentPage;
    }


    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;

    }


    public int getPageCount() {
        return pageCount;
    }

    public List<Integer> getPageGap(int pageGap) {
        int pagesleft = currentPage-pageGap;
        int pagesright = currentPage+pageGap;

        if (pagesleft < 1) {
            pagesleft = 1;
        }
        if (pagesright > pageCount) {
            pagesright = pageCount;
        }


        ArrayList<Integer> tmpList = new ArrayList<Integer>();

        for (int i = pagesleft; i <=pagesright; i++) {
            tmpList.add(i);
        }

        return tmpList;
    }
}
