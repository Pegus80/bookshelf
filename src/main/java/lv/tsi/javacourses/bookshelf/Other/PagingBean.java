package lv.tsi.javacourses.bookshelf.Other;


import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class PagingBean implements Serializable {


    private int pageCount;
    private long recordCount;
    private int currentPage;
    private int recordsOnPage;
    private int pageGap;
    private ArrayList<Integer> pageGapList ;



    public void preparePaging(long recordsCount, int recordsOnPage, int pageGap) {
        this.recordCount = recordsCount;
        this.recordsOnPage = recordsOnPage;
        this.pageGap = pageGap;


        pageCount = calculatePageCount();

        if (isFirstRecord()) currentPage = 1;
        if (isLastRecord()) currentPage = pageCount;

        pageGapList = preparePageGapList();
    }





    public boolean isLastRecord() {
        return (currentPage >= pageCount || pageCount==0);
    }

    public boolean isFirstRecord() {
        return (currentPage <= 1 || pageCount==0);
    }


    public int getCurrentPage() {
        return currentPage;
    }


    public void setCurrentPage(int currentPage) {

        this.currentPage = currentPage;

    }

    public int getPageCount() {
        return pageCount ;
    }



    public int getRecordsOnPage() {
        return recordsOnPage;
    }



    public ArrayList<Integer> getPageGapList() {
        return pageGapList;
    }


    private int calculatePageCount() {
        return (int) Math.ceil(((float) recordCount / recordsOnPage));
    }


    private ArrayList<Integer> preparePageGapList() {
        int pagesleft = currentPage - pageGap;
        int pagesright = currentPage + pageGap;

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
