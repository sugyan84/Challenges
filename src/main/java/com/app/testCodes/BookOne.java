package com.app.testCodes;

import java.util.Objects;


public class BookOne {

    int bookID;
    String title;
    String authors;
    Double average_rating;
    Long isbn;
    String language_code;
    Long ratings_count;
    Double price;

    public BookOne() {
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BookOne bookOne = (BookOne) o;
        return bookID == bookOne.bookID &&
                Objects.equals(title, bookOne.title) &&
                Objects.equals(authors, bookOne.authors) &&
                Objects.equals(average_rating, bookOne.average_rating) &&
                Objects.equals(isbn, bookOne.isbn) &&
                Objects.equals(language_code, bookOne.language_code) &&
                Objects.equals(ratings_count, bookOne.ratings_count) &&
                Objects.equals(price, bookOne.price);
    }

    @Override public int hashCode() {
        return Objects.hash(bookID, title, authors, average_rating, isbn, language_code, ratings_count, price);
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(final int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(final String authors) {
        this.authors = authors;
    }

    public Double getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(final Double average_rating) {
        this.average_rating = average_rating;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(final Long isbn) {
        this.isbn = isbn;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(final String language_code) {
        this.language_code = language_code;
    }

    public Long getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(final Long ratings_count) {
        this.ratings_count = ratings_count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }
}
