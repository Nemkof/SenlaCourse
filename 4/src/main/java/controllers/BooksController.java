package controllers;

public interface BooksController extends Controller {
    void addBook();

    void writeOff();

    void showBookDetails();

    void getBooksByAlphabet();

    void getBooksByDate();

    void getBooksByPrice();

    void getBooksByAvailable();

    void getStaleBooksByDate();

    void getStaleBooksByPrice();

    void importAll();

    void importBook();

    void exportBook();
}
