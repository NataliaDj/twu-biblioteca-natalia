package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 27/02/2017.
 */
public abstract class LibraryItem {
    public enum Type { BOOK, MOVIE }

    private Type type;
    private String title;
    private String borrower;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    abstract String getDetails();

    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.title;
    }

    public boolean isCheckedout() {
        return borrower != null;
    }

    public boolean isAvailable() {
        return borrower == null;
    }

    public void checkoutItem(String borrower) {
        this.borrower = borrower;
    }

    public String getCheckoutDetail() {
        return this.borrower;
    }

    public void returnItem() {
        this.borrower = null;
    }

    public Type getType() {
        return type;
    }

    protected void setType(Type type) {
        this.type = type;
    }
}
