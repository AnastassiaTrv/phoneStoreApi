package elisa.devtest.endtoend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import elisa.devtest.endtoend.dao.ProductDao;
import elisa.devtest.endtoend.exception.JsonParseException;
import elisa.devtest.endtoend.model.Product;
import elisa.devtest.endtoend.model.ProductDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Get all phone group products from DB
     * @return list of phones
     */
    public List<Product> findProducts() {
        List<Product> products = new ArrayList<>();
        productDao.findProducts().forEach(productDto -> products.addAll(mapAsProducts(productDto)));
        return products;
    }

    /**
     * Parse products JSON into list of products
     * @param productDto - dto with JSON to parse
     * @return list of Product objects
     */
    private List<Product> mapAsProducts(ProductDto productDto)  {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(productDto.getProductJson(), new TypeReference<List<Product>>(){});
        } catch (IOException e) {
            throw new JsonParseException(e);
        }
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
