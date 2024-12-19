package Controllers.Impl.FileControllers;

public class CsvConstants {
    public static final String BOOK_HEADER =
            "id;name;author;publicationYear;amount;price;lastDeliveredDate;lastSaleDate";
    public static final String ORDER_HEADER =
            "id;clientName;price;status;orderDate;completeDate;book1;amount1;book2;amount2;...;bookN;amountN";
    public static final String REQUEST_HEADER = "id;bookId;status";

    public static final String IMPORT_BOOK_PATH = "4/Import/importBooks.csv";
    public static final String EXPORT_BOOK_PATH = "4/Export/exportBooks.csv";

    public static final String IMPORT_ORDER_PATH = "4/Import/importOrders.csv";
    public static final String EXPORT_ORDER_PATH = "4/Export/exportOrders.csv";

    public static final String IMPORT_REQUEST_PATH = "4/Import/importRequests.csv";
    public static final String EXPORT_REQUEST_PATH = "4/Export/exportRequests.csv";
}
