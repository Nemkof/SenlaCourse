public class Request {
    private final Book book;
    private RequestStatus status;

    public Request(Book book) {
        this.book = book;
        status = RequestStatus.Open;
    }

    public Book getBook() {
        return book;
    }

    public RequestStatus getStatus() {
        return status;
    }

    void closeRequest(){
        status = RequestStatus.Closed;
    }
}