package elisa.devtest.endtoend.service;

import elisa.devtest.endtoend.dao.CustomerDao;
import elisa.devtest.endtoend.dao.OrderDao;
import elisa.devtest.endtoend.model.Order;
import elisa.devtest.endtoend.utils.Constants;
import elisa.devtest.endtoend.utils.Validator;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private OrderDao orderDao = new OrderDao();
    private CustomerDao customerDao = new CustomerDao();

    /**
     * Add new order into DB
     * @param order - object with order information
     * @return submitted order
     */
    public Map<String, Object> addOrder(Order order) {

        Map<String, Object> resultMap;
        Map<String, String> validationResult = new Validator().getOrderValidationResult(order);

        if (validationResult.isEmpty()) {

            long customerId = customerDao.addCustomer(order.getCustomer());
            long orderId = orderDao.addOrder(customerId);
            int addedCount = orderDao.addOrderLines(order.getOrderLines(), orderId);

            resultMap = getSuccessResultMap(customerId, orderId, addedCount);

        } else {
            resultMap = getErrorResultMap(validationResult);
        }

        return resultMap;
    }

    /**
     * Get result map for successful operation
     * @param customerId - id or customer added
     * @param orderId - id of order added
     * @param addedCount - order lines added
     * @return map wit info
     */
    private Map<String, Object> getSuccessResultMap(long customerId, long orderId, int addedCount) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put(Constants.SUCCESS, true);
        resultMap.put(Constants.CUSTOMER_ID, customerId);
        resultMap.put(Constants.ORDER_ID, orderId);
        resultMap.put(Constants.ADDED_COUNT, addedCount);

        return resultMap;
    }


    /**
     * Get result map for operation with errors
     * @param errors - validation errors
     * @return map with errors info
     */
    private Map<String, Object> getErrorResultMap(Map<String, String> errors) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("success", false);
        resultMap.put("errors", errors);

        return resultMap;
    }


    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
