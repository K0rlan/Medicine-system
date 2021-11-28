package kz.iitu.payment.model;

public class OrderRequest {
    private String id;
    private Order order;

    public OrderRequest() {
    }

    public OrderRequest(String id, Order order) {
        this.id = id;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String userId) {
        this.id = id;
    }

    public Order getBook() {
        return order;
    }

    public void setBook(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id='" + id + '\'' +
                ", order=" + order +
                '}';
    }
}
