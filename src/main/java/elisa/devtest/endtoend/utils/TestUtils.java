package elisa.devtest.endtoend.utils;

import elisa.devtest.endtoend.model.Customer;
import elisa.devtest.endtoend.model.Order;
import elisa.devtest.endtoend.model.OrderLine;

import java.util.Arrays;

public class TestUtils {


    /**
     * Get test order
     * @return order
     */
    public static Order getTestOrder() {
        Order order = new Order();

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setCity("Test city");
        customer.setCountry("Test country");
        customer.setCompanyName("Test company");
        customer.setPostalCode("12345");
        customer.setStreet("Test street");

        OrderLine line1 = new OrderLine();
        line1.setProductName("Test product 1");
        line1.setQuantity(3);

        OrderLine line2 = new OrderLine();
        line2.setProductName("Test product 2");
        line2.setQuantity(2);

        order.setCustomer(customer);
        order.setOrderLines(Arrays.asList(line1,line2));
        order.setOrderId(1);

        return order;
    }


    // constants used for testing purpose
    public static final String PRICING_DTO_JSON_TEST = "\n" +
            "[\n" +
            "    {\n" +
            "        \"id\": 1,\n" +
            "        \"sapId\": \"3ddssSDDFree34Fd\",\n" +
            "        \"recurringPrice\": 12.99,\n" +
            "        \"oneTimePrice\": 50.00,\n" +
            "        \"timeLeft\": \"13-03-2016\",\n" +
            "        \"description\": \"\",\n" +
            "        \"recurringCount\": 24\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 5,\n" +
            "        \"recurringPrice\": 22.351223,\n" +
            "        \"oneTimePrice\": 50.1233125,\n" +
            "        \"timeLeft\": \"nil\",\n" +
            "        \"sapId\": \"3ddssSDDFree34Fd\",\n" +
            "        \"description\": \"\",\n" +
            "        \"recurringCount\": 12\n" +
            "    }\n" +
            "]";

    public static final String PRODUCT_DTO_JSON_TEST = "[\n" +
            "    {\n" +
            "        \"id\": \"f3DFS234#212dfS\",\n" +
            "        \"priceId\": 1,\n" +
            "        \"name\": \"Nokia Lumia 1020 - Blue\",\n" +
            "        \"description\": \"Monster camera version of the famous Windows Phone.\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"s345664lkdLDSDf\",\n" +
            "        \"priceId\": 5,\n" +
            "        \"name\": \"Samsung Galaxy 4\",\n" +
            "        \"description\": \"Not the latest and not the greatest Samsung Galaxy. But it is on sale!\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": \"m873LDFkDF%#DSd\",\n" +
            "        \"priceId\": 1,\n" +
            "        \"name\": \"Nokia Lumia 1020 - White\",\n" +
            "        \"description\": \"Monster camera version of the famous Windows Phone.\"\n" +
            "    }\n" +
            "]";
}
