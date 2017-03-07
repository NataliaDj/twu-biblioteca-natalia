package com.twu.biblioteca;

/**
 * Created by nataliadjohari on 27/02/2017.
 */
public abstract class LibraryItem {
    private enum Status { CHECKEDOUT, AVAILABLE }

    private Status status;
    private String title;

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
        return this.status == Status.CHECKEDOUT;
    }

    public void checkoutItem() {
        this.status = Status.CHECKEDOUT;
    }

    public void returnItem() {
        this.status = Status.AVAILABLE;
    }
}
