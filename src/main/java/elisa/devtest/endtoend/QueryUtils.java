package elisa.devtest.endtoend;

import elisa.devtest.endtoend.model.Customer;

public class QueryUtils {

    /**
     * Get sql query for customer insert
     * @param customer - obkect with customer data
     */
    public static String getInsertQustomerQuery(Customer customer) {
        StringBuilder queryBuilder = new StringBuilder();
        String suffix = "', '";

        queryBuilder.append("INSERT INTO customer (company_name, street, postal_code, city, country) VALUES ('")
                .append(customer.getCompanyName()).append(suffix)
                .append(customer.getStreet()).append(suffix)
                .append(customer.getPostalCode()).append(suffix)
                .append(customer.getCity()).append(suffix)
                .append(customer.getCountry()).append("');");

        return queryBuilder.toString();
    }
}
