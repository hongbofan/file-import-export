package com.flyread.file.imp0rt.base;

/**
 * @author by hongbf on 2018/3/21.
 */
public class Book {
    private String isbn;
    private String name;
    private String infoAuthor;
    private String infoPublisher;
    private String infoPubdate;
    private String infoPrice;
    private Double orderCount;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfoAuthor() {
        return infoAuthor;
    }

    public void setInfoAuthor(String infoAuthor) {
        this.infoAuthor = infoAuthor;
    }

    public String getInfoPublisher() {
        return infoPublisher;
    }

    public void setInfoPublisher(String infoPublisher) {
        this.infoPublisher = infoPublisher;
    }

    public String getInfoPubdate() {
        return infoPubdate;
    }

    public void setInfoPubdate(String infoPubdate) {
        this.infoPubdate = infoPubdate;
    }

    public String getInfoPrice() {
        return infoPrice;
    }

    public void setInfoPrice(String infoPrice) {
        this.infoPrice = infoPrice;
    }

    public Double getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Double orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "orderCount='" + orderCount + '\'' +
                ", infoPrice='" + infoPrice + '\'' +
                ", infoPubdate='" + infoPubdate + '\'' +
                ", infoPublisher='" + infoPublisher + '\'' +
                ", infoAuthor='" + infoAuthor + '\'' +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
