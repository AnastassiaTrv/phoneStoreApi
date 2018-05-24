package elisa.devtest.endtoend.dao;

import elisa.devtest.endtoend.QueryUtils;
import elisa.devtest.endtoend.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class CustomerDao {

    /**
     * Insert new customer from order into DB
     * @param customer - customer object with information
     * @return id of added customer
     */
    public int addCustomer(Customer customer) {
        JdbcTemplate template = new JdbcTemplate(DBConnection.getDataSource());
        String query = QueryUtils.getInsertQustomerQuery(customer);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(connection -> connection.prepareStatement(query, new String[] {"customer_id"}), keyHolder);

        return keyHolder.getKey().intValue();
    }
}
