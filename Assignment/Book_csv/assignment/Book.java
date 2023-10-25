
package assignment;

/**
 *
 * @author FPTSHOP
 */
public class Book {
    // "ISBN";"Book-Title";"Book-Author";"Year-Of-Publication";"Publisher";"Image-URL-S";"Image-URL-M";"Image-URL-L"

    private String isbn, bookTitle, bookAuthor, publisher, imageS, imageM, imageL;
    private int yearOfPublishcation;

    public Book(String isbn, String bookTitle, String bookAuthor, String publisher, String imageS, String imageM, String imageL, int yearOfPublisher) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.imageS = imageS;
        this.imageM = imageM;
        this.imageL = imageL;
        this.yearOfPublishcation = yearOfPublisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageS() {
        return imageS;
    }

    public void setImageS(String imageS) {
        this.imageS = imageS;
    }

    public String getImageM() {
        return imageM;
    }

    public void setImageM(String imageM) {
        this.imageM = imageM;
    }

    public String getImageL() {
        return imageL;
    }

    public void setImageL(String imageL) {
        this.imageL = imageL;
    }

    public int getYearOfPublisher() {
        return yearOfPublishcation;
    }

    public void setYearOfPublisher(int yearOfPublisher) {
        this.yearOfPublishcation = yearOfPublisher;
    }

    @Override
    public String toString() {
        return "Book{" +"yearOfPublishcation=" + yearOfPublishcation+" , " + "isbn=" + isbn + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", publisher=" + publisher + ", imageS=" + imageS + ", imageM=" + imageM + ", imageL=" + imageL  + "}";
    }
    
}
