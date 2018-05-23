package elisa.devtest.endtoend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import elisa.devtest.endtoend.dao.OrderDao;
import elisa.devtest.endtoend.model.Order;

public class OrderService {
    private final OrderDao orderDao = new OrderDao();
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Add new order into DB
     * @param order - object with order information
     * @return submitted order
     */
    public Order addOrder(Order order) {
        return orderDao.submitOrder(order);
    }

}
