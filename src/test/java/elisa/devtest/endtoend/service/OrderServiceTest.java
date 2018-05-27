package elisa.devtest.endtoend.service;

import elisa.devtest.endtoend.dao.CustomerDao;
import elisa.devtest.endtoend.dao.OrderDao;
import elisa.devtest.endtoend.model.Order;
import elisa.devtest.endtoend.utils.Constants;
import elisa.devtest.endtoend.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    private OrderService orderService = new OrderService();
    private OrderDao orderDao = mock(OrderDao.class);
    private CustomerDao customerDao = mock(CustomerDao.class);

    @Before
    public void setUp() {
        orderService.setOrderDao(orderDao);
        orderService.setCustomerDao(customerDao);
    }

    @Test
    public void getOrder(){

        Order order = TestUtils.getTestOrder();

        long customerId = order.getCustomer().getCustomerId();
        long orderId = order.getOrderId();
        int addedCount = order.getOrderLines().size();

        when(customerDao.addCustomer(order.getCustomer())).thenReturn(customerId);
        when(orderDao.addOrder(customerId)).thenReturn(orderId);
        when(orderDao.addOrderLines(order.getOrderLines(), orderId)).thenReturn(addedCount);

        Map<String, Object> result = orderService.addOrder(order);

        assertEquals(true, result.get(Constants.SUCCESS));
        assertEquals(customerId, result.get(Constants.CUSTOMER_ID));
        assertEquals(orderId, result.get(Constants.ORDER_ID));
        assertEquals(addedCount, result.get(Constants.ADDED_COUNT));
    }

}
