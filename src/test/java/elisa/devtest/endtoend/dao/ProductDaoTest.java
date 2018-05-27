package elisa.devtest.endtoend.dao;

import elisa.devtest.endtoend.model.ProductDto;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest extends DaoTestBase{

    private ProductDao productDao = new ProductDao();

    @Test
    public void findProductsTest(){
        List<ProductDto> productDtos = productDao.findProducts();
        assertEquals(1, productDtos.size());
    }
}
