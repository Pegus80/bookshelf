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
    private List<Integer> pageGapList;



    private static final int RECORDS_ON_PAGE = 5;
    private static final int PAGE_GAP = 3;

    public List<PublisherEntity> getPublishersByPage() {

        if (currentPage == null || currentPage<1) {
            currentPage = 1;
        }

        getPageCount();
        preparePageGapList();


        int from = (currentPage - 1) * RECORDS_ON_PAGE;

        return publisherDAO.getPublishersFromTo(from, RECORDS_ON_PAGE);

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
        if (currentPage < 1) {
            currentPage = 1;
        }

        if (currentPage > getPageCount()) {
            currentPage = pageCount;
        }

//        TODO Надо ли тут дополнительно в лог писать ошибку или excpetion бросать, если пользлватель запросил страницу
//        TODO за пределами диапозона, или достаточно защиты вышe?
        this.currentPage = currentPage;

    }


    public int getPageCount() {
        var count = publisherDAO.getPublishersCount();
        return pageCount=(int) Math.ceil(((float) count / RECORDS_ON_PAGE));
    }



    public void preparePageGapList() {
        int pagesleft = currentPage-PAGE_GAP;
        int pagesright = currentPage+PAGE_GAP;

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


        pageGapList=tmpList;
    }


    public List<Integer> getPageGapList() {
        return pageGapList;
    }
}
