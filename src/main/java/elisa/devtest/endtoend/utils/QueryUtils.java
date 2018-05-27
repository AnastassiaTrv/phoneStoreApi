package elisa.devtest.endtoend.utils;

import elisa.devtest.endtoend.model.Customer;
import elisa.devtest.endtoend.model.OrderLine;

import java.util.List;

public class QueryUtils {

    private static final String SUFFIX = "', '";

    /**
     * Get sql query string for new customer insertion
     * @param customer - obkect with customer data
     * @return executable sql string
     */
    public static String getInsertQustomerQuery(Customer customer) {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("INSERT INTO customer (company_name, street, postal_code, city, country) VALUES ('")
                .append(customer.getCompanyName()).append(SUFFIX)
                .append(customer.getStreet()).append(SUFFIX)
                .append(customer.getPostalCode()).append(SUFFIX)
                .append(customer.getCity()).append(SUFFIX)
                .append(customer.getCountry()).append("');");

        return queryBuilder.toString();
    }


    /**
     * Get sql query string for new order insertion
     * @param customerId - id of customer to link with order
     * @return executable sql string
     */
    public static String getInsertOrderQuery(long customerId) {
        return "INSERT INTO orders (customer_id) VALUES (" + customerId + ");";
    }


    /**
     * Get sql query string for insertion of multiple orderLines
     * @param lines - list of order lines to insert
     * @param orderId - id of order to link with
     * @return executable sql string
     */
    public static String getInsertOrderLinesQuery(List<OrderLine> lines, long orderId) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO order_line (order_id, product_id, product_name, quantity) VALUES");

        lines.forEach( line -> queryBuilder.append(" ('").append(orderId).append(SUFFIX)
        .append(line.getProductId()).append(SUFFIX)
        .append(line.getProductName()).append(SUFFIX)
        .append(line.getQuantity()).append("'),"));

        String withoutComma = queryBuilder.substring(0, queryBuilder.toString().length() - 1);

        return withoutComma + ";";
    }


    /**
     * Get sql query for dropping tables in db
     * @return executable sql string
     */
    public static String getDropTablesQuery() {
        return "DROP TABLE IF EXISTS pricing_dump, product_dump, order_line, orders, customer;";
    }
}
