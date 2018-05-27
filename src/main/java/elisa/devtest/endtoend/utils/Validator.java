package elisa.devtest.endtoend.utils;

import elisa.devtest.endtoend.model.Customer;
import elisa.devtest.endtoend.model.Order;
import elisa.devtest.endtoend.model.OrderLine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order and customer data validator.
 */
public class Validator {

    private Map<String, String> errors = new HashMap<>();

    /**
     * Validate order
     * @return map with validation errors
     */
    public Map<String, String> getOrderValidationResult(Order order) {
        validateOrderProductList(order.getOrderLines());
        validateCustomer(order.getCustomer());

        return errors;
    }


    /**
     * Validate orders product list and check if it is not empty
     * @param products - list of order lines
     */
    private void validateOrderProductList(List<OrderLine> products) {
        if (products.isEmpty()) {
            addError("empty", "Empty order is not allowed");
        }
    }

    /**
     * Validate customer objects properties before saving into DB
     * @param customer - customer object ro validate
     */
    private void validateCustomer(Customer customer) {
        validateCompanyName(customer.getCompanyName());
        validateStreetName(customer.getStreet());
        validatePostalCode(customer.getPostalCode());
        validateCity(customer.getCity());
        validateCountry(customer.getCountry());
    }

    private void validateCompanyName(String companyName) {
        if (companyName.length() > Constants.COMPANY_NAME_MAX_LENGTH) {
            addError("companyName", "Company name is too long");
        }
    }

    private void validateStreetName(String street) {
        if (street.length() > Constants.STREET_MAX_LENGTH) {
            addError("street", "Street name is too long");
        }
    }

    private void validatePostalCode(String postalCode) {
        if (postalCode.length() > Constants.POSTAL_CODE_LENGTH) {
            addError("postalCode", "Postal code is invalid");
        }
    }

    private void validateCity(String city) {
        if (city.length() > Constants.CITY_MAX_LENGTH) {
            addError("city", "City name is too long");
        }
    }

    private void validateCountry(String country) {
        if (country.length() > Constants.COUNTRY_MAX_LENGTH) {
            addError("country", "Country name is too long");
        }
    }

    private void addError(String key, String msg) {
        errors.put(key, msg);
    }
}
