package org.fundaciobit.basecamp.api3.beans;

public class Entries {

    private Entry[] entries;
    private long totalEntries;
    private int currentPage;

    public Entries() {
        super();
    }



    public Entries(Entry[] entries, long totalEntries, int currentPage) {
        super();
        this.entries = entries;
        this.totalEntries = totalEntries;
        this.currentPage = currentPage;
    }



    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }

    public long getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(long totalEntries) {
        this.totalEntries = totalEntries;
    }



    public int getCurrentPage() {
        return currentPage;
    }



    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

}
