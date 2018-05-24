package elisa.devtest.endtoend.service;

import elisa.devtest.endtoend.dao.CustomerDao;
import elisa.devtest.endtoend.dao.OrderDao;
import elisa.devtest.endtoend.model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private final OrderDao orderDao = new OrderDao();
    private final CustomerDao customerDao = new CustomerDao();

    /**
     * Add new order into DB
     * @param order - object with order information
     * @return submitted order
     */
    public Map<String, Object> addOrder(Order order) {

        Map<String, Object> resultMap = new HashMap<>();

        if (isOrderNotEmpty(order)) {

            int customerId = customerDao.addCustomer(order.getCustomer());
            int orderId = orderDao.addOrder(customerId);
            int addedCount = orderDao.addOrderLines(order.getOrderLines(), orderId);

            resultMap.put("customerId", customerId);
            resultMap.put("orderId", orderId);
            resultMap.put("addedCount", addedCount);
            resultMap.put("success", true);

        } else {
            resultMap.put("success", false);
        }

        return resultMap;
    }


    /**
     * Check if order contains is not empty (contains order lines)
     * @param order - order to check
     * @return boolean
     */
    private boolean isOrderNotEmpty(Order order) {
        return !order.getOrderLines().isEmpty();
    }

}
