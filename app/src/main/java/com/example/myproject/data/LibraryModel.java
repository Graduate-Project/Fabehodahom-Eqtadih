package com.example.myproject.data;

public class LibraryModel {

    private String bookCategory;
    private String bookLink;
    private String bookDiscription;
    private String coverPic;
    private String author;
    private String BookName;
    private int BookId;

    public LibraryModel(String coverPic, String bookName) {
        this.coverPic = coverPic;
        BookName = bookName;
    }

    public LibraryModel(LibraryModel libraryModel, String bookName) {

    }

    public LibraryModel(String bookDiscription, String coverPic, String author, String bookName) {
        this.bookDiscription = bookDiscription;
        this.coverPic = coverPic;
        this.author = author;
        BookName = bookName;
    }

    public LibraryModel(String bookCategory, String bookLink, String bookDiscription, String coverPic, String author, String bookName, int bookId) {
        this.bookCategory = bookCategory;
        this.bookLink = bookLink;
        this.bookDiscription = bookDiscription;
        this.coverPic = coverPic;
        this.author = author;
        BookName = bookName;
        BookId = bookId;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookLink() {
        return bookLink;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public String getBookDiscription() {
        return bookDiscription;
    }

    public void setBookDiscription(String bookDiscription) {
        this.bookDiscription = bookDiscription;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }
}
