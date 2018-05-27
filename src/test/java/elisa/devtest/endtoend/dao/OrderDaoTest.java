package elisa.devtest.endtoend.dao;
import elisa.devtest.endtoend.model.Customer;
import elisa.devtest.endtoend.model.Order;
import elisa.devtest.endtoend.model.OrderLine;
import elisa.devtest.endtoend.utils.TestUtils;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest extends DaoTestBase{

    private OrderDao orderDao = new OrderDao();

    @Test
    public void findOrdersTest(){
        List<Order> orders = orderDao.findOrders();
        assertEquals(2, orders.size());

        Customer firstCustomer = orders.get(0).getCustomer();
        List<OrderLine> orderlines = orders.get(0).getOrderLines();

        assertEquals("Putka Oy", firstCustomer.getCompanyName());
        assertEquals(1, orderlines.size());
    }


    @Test
    public void addOrderTest(){
        Order order = TestUtils.getTestOrder();
        long customerId = order.getCustomer().getCustomerId();

        orderDao.addOrder(customerId);

        List<Order> orders = orderDao.findOrders();
        assertEquals(3, orders.size());
        assertEquals(1, customerId);
    }


    @Test
    public void addOrderLinesTest(){
        Order order = TestUtils.getTestOrder();
        orderDao.addOrderLines(order.getOrderLines(), order.getOrderId());

        List<OrderLine> lines = orderDao.findOrderLines(order.getOrderId());
        assertEquals(3, lines.size());
    }

}
