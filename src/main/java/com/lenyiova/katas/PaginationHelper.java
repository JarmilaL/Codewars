package com.lenyiova.katas;

// For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class, which is a utility class helpful for querying paging information related to an array.
//
// The class is designed to take in an array of values and an integer indicating how many items will be allowed per each page. The types of values contained within the collection/array are not relevant.
//
// The following are some examples of how this class is used:
//
// PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
// helper.pageCount(); //should == 2
// helper.itemCount(); //should == 6
// helper.pageItemCount(0); //should == 4
// helper.pageItemCount(1); // last page - should == 2
// helper.pageItemCount(2); // should == -1 since the page is invalid
//
//// pageIndex takes an item index and returns the page that it belongs on
// helper.pageIndex(5); //should == 1 (zero based index)
// helper.pageIndex(2); //should == 0
// helper.pageIndex(20); //should == -1
// helper.pageIndex(-10); //should == -1

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;
    private List<Integer> pages;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;

        if (itemsPerPage > 0) {
            this.itemsPerPage = itemsPerPage;
        } else throw new IllegalArgumentException();

        this.pages = paginateItems(collection);
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (collection.isEmpty()) return 0;

        int pageCount = collection.size() / itemsPerPage;
        if (collection.size() % itemsPerPage > 0) pageCount += 1;

        return pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pages.size()) return -1;

        if (pageIndex == 0 && pages.size() == 1) {
            return collection.size();
        } else if (collection.size() % itemsPerPage != 0 && pageIndex == pages.size() - 1) {
            return collection.size() % itemsPerPage;
        } else {
            return itemsPerPage;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex > collection.size() - 1) return -1;

        for (int i = 0; i < pages.size(); i++) {
            if (itemIndex <= pages.get(i)) return i;
        }
        return -1;
    }

    /**
     * returns a list of size of pages count. Every item holds the biggest item index of the page.
     */
    private List<Integer> paginateItems(List<I> collection) {
        List<Integer> pages = new ArrayList<>();
        int pageCount = pageCount();

        if (pageCount == 0) return pages;

        if (collection.size() % itemsPerPage == 0) {
            for (int i = 0; i < pageCount; i++) {
                pages.add((itemsPerPage * (i + 1)) - 1);
            }
        } else {
            for (int i = 0; i < pageCount - 1; i++) {
                pages.add((itemsPerPage * (i + 1)) - 1);
            }

            pages.add(pageCount - 1, pages.get(pageCount - 2) + collection.size() % itemsPerPage);
        }

        return pages;
    }
}
