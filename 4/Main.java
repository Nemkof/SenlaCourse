import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MainManagerImpl myManager = new MainManagerImpl();

        // Проверяем работоспособность магазина: создаем книги, заказы и т.п.
        testMyManager(myManager);

        // Получаем списки книг с разной сортировкой
        //testBooksGetters(myManager);

        // Получаем списки заказов с разной сортировкой
        //testOrdersGetters(myManager);

        // Получаем список запросов на книгу (сортировка по количеству запросов, по цене)
        //testGetOrdersByBooks(myManager);

        // Получаем список выполненных заказов за период времени (сортировка по дате, цене)
        //testCompletedOrders(myManager);

        // Получаем сумму заработанных средств за период времени
        //testGetSum(myManager);

        // Количество выполненных заказов за период времени
        //testGetCountCompletedOrders(myManager);

        // Список залежавшихся книг, не проданных более чем 6 месяцев (по дате поступления, цене)
        //testGetStaleBooks(myManager);

        // Посмотреть детали заказа
        //testShowOrderDetails(myManager);

        // Посмотреть описание книги
        //testShowBookDetails(myManager);
    }

    public static void testGetOrdersByBooks(MainManagerImpl myManager){
        System.out.println("Получаем список запросов на книгу (сортировка по количеству запросов)");
        List<Map.Entry<Book, List<Order>>> results = myManager.getOrdersByBooksByCount();
        results.forEach(entry -> {
            System.out.println(entry.getKey().getName() + ": ");
            entry.getValue().forEach(value -> System.out.println(value.getInfoAbout()));
        });
        System.out.println("---------------------------------------");

        System.out.println("Получаем список запросов на книгу (сортировка по цене)");
        results = myManager.getOrdersByBooksByDate();
        results.forEach(entry -> {
            System.out.println(entry.getKey().getName() + ": ");
            entry.getValue().forEach(value -> System.out.println(value.getInfoAbout()));
        });
        System.out.println("---------------------------------------");
    }

    public static void testGetStaleBooks(MainManagerImpl myManager){
        List<Book> books = myManager.getStaleBooksByDate();
        System.out.println("Залежавшиеся книги, сортировка по дате поступления");
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");

        books = myManager.getStaleBooksByPrice();
        System.out.println("Залежавшиеся книги, сортировка по цене");
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");
    }

    public static void testShowBookDetails(MainManagerImpl myManager){
        System.out.println();
        System.out.println("Посмотреть описание книги: ");
        Book testBook = new Book("Ревизор", "Н.В.Гоголь", 200, 1835);
        myManager.showBookDetails(testBook);
        System.out.println("---------------------------------------");
    }

    public static void testShowOrderDetails(MainManagerImpl myManager){
        System.out.println("Посмотреть детали заказа: ");
        Book testBook = new Book("Дубровский", "А.С.Пушкин", 450, 1833);
        myManager.showOrderDetails("Степан Краснов", testBook);
        System.out.println("---------------------------------------");
    }

    public static void testGetCountCompletedOrders(MainManagerImpl myManager){
        System.out.println("Количество выполненных заказов за период времени: ");
        System.out.println(myManager.getCountCompletedOrders(LocalDate.of(2024, 10, 1),
                LocalDate.of(2024,12,31)));
        System.out.println("---------------------------------------");
    }

    public static void testGetSum(MainManagerImpl myManager){
        System.out.println("Сумма заработанных средств за период времени: ");
        System.out.println(myManager.getEarnedSum(LocalDate.of(2024, 10, 1),
                LocalDate.of(2024,12,31)));
        System.out.println("---------------------------------------");
    }

    public static void testBooksGetters(MainManagerImpl myManager){
        System.out.println("На складе есть следующие книги:");
        List<Book> books = myManager.getBooks();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка книг по алфавиту");
        books = myManager.getBooksByAlphabet();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка книг по дате издания");
        books = myManager.getBooksByDate();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка книг по цене");
        books = myManager.getBooksByPrice();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка книг по наличию");
        books = myManager.getBooksByAvailable();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
        }
        System.out.println("---------------------------------------");
    }

    public static void testOrdersGetters(MainManagerImpl myManager){
        System.out.println("В магазине есть следующие заказы:");
        List<Order> orders = myManager.getOrders();
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка заказов по дате выполнения:");
        orders = myManager.getOrdersByDate();
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка заказов по цене:");
        orders = myManager.getOrdersByPrice();
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");

        System.out.println("Сортировка заказов по статусу:");
        orders = myManager.getOrdersByStatus();
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    public static void testCompletedOrders(MainManagerImpl myManager){
        List<Order> orders = myManager.getCompletedOrdersByDate(LocalDate.of(2024, 10, 1),
                LocalDate.of(2024,12,31));

        System.out.println("Список заказов за период времени, сортировка по дате заказа:");
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");

        orders = myManager.getCompletedOrdersByPrice(LocalDate.of(2024, 10, 1),
                LocalDate.of(2024,12,31));

        System.out.println("Список заказов за период времени, сортировка по цене заказа:");
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    public static void testMyManager(MainManagerImpl myManager){
        printAbout(myManager);

        // Списать книгу со склада
        System.out.println("Списать книгу со склада: Дубровский");
        Book testBook = new Book("Дубровский", "А.С.Пушкин", 450, 1833);
        myManager.writeOff(testBook, 1);
        printAbout(myManager);

        // Создать заказ
        System.out.println("Создать заказ: Капитанская дочка");
        Book testBook1 = new Book("Капитанская дочка", "А.С.Пушкин", 200, 1836);
        myManager.createOrder(testBook1, "Дарья Иванова");
        printAbout(myManager);

        // Оставить запрос на книгу
        System.out.println("Оставить запрос на книгу: Капитанская почка");
        Book testBook2 = new Book("Капитанская почка", "А.С.Пупкин", 300, 2024);
        myManager.createOrder(testBook2, "Сергей Юртаев");
        printAbout(myManager);

        // Изменить статус заказа
        System.out.println("Изменить статус заказа: Капитанская дочка");
        Order testOrder1 = new Order(testBook1, "Дарья Иванова");
        myManager.setOrderStatus(testOrder1, OrderStatus.NotCompleted);
        printAbout(myManager);

        // Отменить заказ
        System.out.println("Отменить заказ: Капитанская почка");
        Order testOrder2 = new Order(testBook2, "Игорь Дроздов");
        myManager.cancelOrder(testOrder2);
        printAbout(myManager);

        // Добавить книгу на склад
        System.out.println("Добавить книгу на склад: Капитанская дочка");
        myManager.addBook(testBook1, 1);
        printAbout(myManager);
    }

    public static void printAbout(MainManagerImpl manager){
        System.out.println("    BOOKS:");

        List<Book> books = manager.getLibraryManager().getBooks();
        for (Book book : books) {
            System.out.println(book.getInfoAbout());
            System.out.println();
        }

        System.out.println("    ORDERS:");

        List<Order> orders = manager.getOrdersManager().getOrders();
        for (Order order : orders) {
            System.out.println(order.getInfoAbout());
            System.out.println(order.getInfoAboutBook());
            System.out.println();
        }

        System.out.println("---------------------------------------");
    }
}