package com.ecust.utms.model;

public class Book {
    private String ISBN;
    private String Name;
    private String Publisher;
    private String Author;
    private String PublishingDate;
    private String LibUrl;
    private Integer CID;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishingDate() {
        return PublishingDate;
    }

    public void setPublishingDate(String publishingDate) {
        PublishingDate = publishingDate;
    }

    public String getLibUrl() {
        return LibUrl;
    }

    public void setLibUrl(String libUrl) {
        LibUrl = libUrl;
    }

    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    @Override
    public String  toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", Name='" + Name + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Author='" + Author + '\'' +
                ", PublishingDate='" + PublishingDate + '\'' +
                ", LibUrl='" + LibUrl + '\'' +
                ", CID=" + CID +
                '}';
    }
}
