import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersManagerImpl implements OrdersManager{
    private final List<Order> orders;
    private final List<Request> requests;

    public OrdersManagerImpl() {
        orders = new ArrayList<>();
        requests = new ArrayList<>();

        orders.add(new Order(new Book("Война и Мир", "Л.Н.Толстой", 100, 1869),
                OrderStatus.COMPLETED, LocalDate.of(2024, 5, 12), "Максим Иванов"));
        orders.add(new Order(new Book("Анна Каренина", "Л.Н.Толстой", 150, 1877),
                OrderStatus.COMPLETED, LocalDate.of(2024, 5, 9), "Илья Петров"));
        orders.add(new Order(new Book("Капитанская почка", "А.С.Пупкин", 200, 2024),
                OrderStatus.NOTCOMPLETED, null, "Игорь Дроздов"));
        orders.add(new Order(new Book("Мёртвые души", "Н.В.Гоголь", 350, 1842),
                OrderStatus.NOTCOMPLETED, null, "Екатерина Смирнова"));
        orders.add(new Order(new Book("Гарри Поттер и узник Азкабана", "Дж.К.Роулинг", 450, 1999),
                OrderStatus.NOTCOMPLETED, null, "Дмитрий Розанов"));

        orders.add(new Order(new Book("Введение в алгебру", "А.И.Кострикин", 450, 2001),
                OrderStatus.NOTCOMPLETED, null, "Алина Петрова"));
        orders.add(new Order(new Book("Преступление и наказание", "Ф.М.Достоевский", 200, 1866),
                OrderStatus.COMPLETED, LocalDate.of(2024, 11, 23), "Александр Бессонов"));
        orders.add(new Order(new Book("Дубровский", "А.С.Пушкин", 450, 1833),
                OrderStatus.COMPLETED, LocalDate.of(2024, 11, 1), "Степан Краснов"));
        orders.add(new Order(new Book("Мёртвые души", "Н.В.Гоголь", 350, 1842),
                OrderStatus.NOTCOMPLETED, null, "Григорий Лепс"));
        orders.add(new Order(new Book("Идиот", "Ф.М.Достоевский", 350, 1868),
                OrderStatus.COMPLETED, LocalDate.of(2024, 11, 30), "Игорь Некрасов"));

        requests.add(new Request(new Book("Капитанская почка", "А.С.Пупкин", 200, 2024)));
        requests.add(new Request(new Book("Мёртвые души", "Н.В.Гоголь", 350, 1842)));
        requests.add(new Request(new Book("Гарри Поттер и узник Азкабана", "Дж.К.Роулинг", 450, 1999)));
        requests.add(new Request(new Book("Введение в алгебру", "А.И.Кострикин", 450, 2001)));
        requests.add(new Request(new Book("Мёртвые души", "Н.В.Гоголь", 350, 1842)));
        requests.add(new Request(new Book("Мёртвые души", "Н.В.Гоголь", 350, 1842)));
    }

    // Закрыть запросы по книге
    @Override
    public void closeRequests(Book book){
        for (Request request : requests) {
            if (request.getBook().equals(book) && request.getStatus() == RequestStatus.OPEN) {
                request.closeRequest();
            }
        }
        for (Order order : orders) {
            if (order.getBook().equals(book) && order.getStatus() == OrderStatus.NOTCOMPLETED) {
                order.setStatus(OrderStatus.COMPLETED);
            }
        }
    }

    // Добавить заказ
    @Override
    public void addOrder(Order order){
        orders.add(order);
        // Если статус заказа "NotCompleted", то нужно создать запрос на книгу
        if(!order.isCompleted()){
            requests.add(new Request(order.getBook()));
        }
    }

    // Отменить заказ
    @Override
    public void cancelOrder(Order order){
        orders.remove(order);
        // Если на данную книгу есть еще заказы, то ничего не делаем
        for (Order it : orders) {
            if (it.getBook().equals(order.getBook()) && it.getStatus() == OrderStatus.NOTCOMPLETED) {
                return;
            }
        }
        // Если заказов больше нет, нужно закрыть все запросы на книгу
        for (Request request : requests) {
            if (request.getBook().equals(order.getBook()) && request.getStatus() == RequestStatus.OPEN) {
                request.closeRequest();
            }
        }
    }

    // Изменить статус заказа
    @Override
    public void setOrderStatus(Order order, OrderStatus status){
        // Если статус заказа изменился с NotCompleted на Completed
        // И больше нет заказов на данную книгу
        // То нужно закрыть все запросы на эту книгу
        if(order.getStatus() == OrderStatus.NOTCOMPLETED && status == OrderStatus.COMPLETED){
            boolean flag = true;
            for (Order it : orders) {
                if(it.getBook().equals(order.getBook()) && it.getStatus() == OrderStatus.NOTCOMPLETED) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                for (Request request : requests) {
                    if (request.getBook().equals(order.getBook()) && request.getStatus() == RequestStatus.OPEN) {
                        request.closeRequest();
                    }
                }
            }
        }

        // Меняем статус заказа
        for (Order value : orders) {
            if (value.equals(order)) {
                value.setStatus(status);
            }
        }
    }

    @Override
    public List<Order> getOrders(){
        return orders;
    }

    @Override
    public List<Request> getRequests(){
        return requests;
    }
}
