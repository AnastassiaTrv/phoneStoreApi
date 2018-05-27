package elisa.devtest.endtoend.model;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderId;
    private Customer customer;
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order() {}

    public Order(long orderId, Customer customer, List<OrderLine> orderLines) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderLines = orderLines;
    }

    public long getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
